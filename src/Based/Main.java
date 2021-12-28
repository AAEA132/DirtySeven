package Based;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Getting the number of players
        System.out.print("Please enter the number of players (3 to 5): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner = new Scanner(System.in);
        boolean rightInput = false;
        while (!rightInput){
            int length = input.length();
            if (length==1&&Character.isDigit(input.charAt(0))) {
                if (Integer.parseInt(input) <= 5 && Integer.parseInt(input) >= 3)
                    rightInput = true;
            }
            else {
                System.out.print("Try again: ");
                input = scanner.nextLine();
                scanner = new Scanner(System.in);
            }
        }
        //Creating a game and getting its manager
        Game game = new Game(Integer.parseInt(input));
        Manager manager = game.getManager();
        //Shuffling to set the StartCard as a NonAction card
        manager.setTopRandomNonActionCard();
        //A boolean to determine the game is clockwise or anticlockwise
        boolean clockwise = true;
        //Determining the random starter of the game and its index
        Random random = new Random();
        int currentPlayerIndex = random.nextInt(manager.getPlayers().size());
        Player currentPlayer = manager.getPlayers().get(currentPlayerIndex);
        //A Card to determine the top card (middle card in doc) of the deck
        Card topCard = manager.getTopCard();
        //A Hand to determine the playable cards of the current player in player's turn
        Hand playableHandForCurrentPlayer;
        //A Hand which has all the 7-Cards of the player's hand
        Hand all7CardsInHand ;
        //A int variable to determine how many rimes before player couldn't play a card and the bottom card of the deck is added to player's hand
        int couldNotPlay = 0;
        //A int variable to determine is any 7-Punishment going and if yes how many cards it has now
        int punishment7 = 0;
        //Two variables which determine the playable cards of a player's hand
        String valueOfNextCard = topCard.getValue();
        String colorOfNextCard = topCard.getColor();
        //A boolean variable which ensures the loop to continue
        boolean exit = false;
        //The games loop
        while (!exit){
            //Printing if game is Clockwise or not
            if (clockwise) System.out.println("Clockwise");
            else System.out.println("Anticlockwise");
            //Printing whose turn is it
            System.out.println("Player "+((currentPlayerIndex%manager.getPlayers().size())+1)+" 's turn");
            //Printing the top card of the turn
            System.out.println("Top Card at the start of turn: ");
            manager.printTopCard();

            //If its the user turn (user is always player with index 0)
            if (currentPlayer.getIndex()==0 && couldNotPlay<2) {
                //Printing other computer players' known info!
                for (int i = 1; i < manager.getPlayers().size(); i++) {
                    System.out.println("Player"+(i+1)+"--- "+ manager.getPlayers().get(i).getPlayerHand().getHandList().size()+" cards in hand");
                }
                //The procedure if there is a 7-Punishment going
                if (punishment7 != 0) {
                    System.out.println("You have 7-punishment! It means if a card with value of 7 is not dealt by you, " + (punishment7 * 2) + " cards will be added to your hand!");
                    if (currentPlayer.getPlayerHand().contains7()) {
                        System.out.print("You have at least one card with the value of 7! If you want to deal it enter -1 (if not, enter any number to receive cards and continue): ");
                        input = scanner.nextLine();
                        scanner = new Scanner(System.in);
                        rightInput = false;
                        while (!rightInput) {
                            int length = input.length();
                            if (length == 2 && Character.isDigit(input.charAt(1)))
                                rightInput = true;
                            else {
                                System.out.print("Try again: ");
                                input = scanner.nextLine();
                                scanner = new Scanner(System.in);
                            }
                        }

                        if (Integer.parseInt(input) == -1) {
                            all7CardsInHand = currentPlayer.get7Cards();
                            System.out.print("Here is all your 7-cards! Enter the number of the card you want to deal: ");
                            all7CardsInHand.printHand();

                            input = scanner.nextLine();
                            scanner = new Scanner(System.in);
                            rightInput = false;
                            while (!rightInput) {
                                int length = input.length();
                                if (length == 1 && Character.isDigit(input.charAt(0))) {
                                    if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= all7CardsInHand.getHandList().size()) {
                                        rightInput = true;
                                    }
                                } else {
                                    System.out.print("Try again: ");
                                    input = scanner.nextLine();
                                    scanner = new Scanner(System.in);
                                }
                            }
                            Card chosen7 = all7CardsInHand.getHandList().get(Integer.parseInt(input) - 1);
                            if (chosen7 instanceof ActionCard7Black)
                                punishment7 += 2;
                            else if (chosen7 instanceof ActionCard7NonBlack)
                                punishment7 += 1;
                            currentPlayer.getPlayerHand().removeCard(chosen7);
                            manager.addNewTopCard(chosen7);

                            valueOfNextCard = "7";
                            colorOfNextCard = chosen7.getColor();
                        } else {
                            System.out.println("You chose to receive the punishment!");
                            for (int i = 0; i < (punishment7 * 2); i++) {
                                currentPlayer.getPlayerHand().addCard(manager.pickCard());
                            }
                            punishment7 = 0;
                        }
                    } else {
                        System.out.println("You don't have any 7-card, so " + (punishment7 * 2) + " cards will be added to your hand");
                        for (int i = 0; i < (punishment7 * 2); i++) {
                            currentPlayer.getPlayerHand().addCard(manager.pickCard());
                        }
                        punishment7 = 0;
                    }
                }
                //The procedure if there is not a 7-Punishment going or player has been punished!
                if (punishment7 == 0) {
                    //Printing player's hand
                    System.out.println("Your hand: ");
                    currentPlayer.getPlayerHand().printHand();
                    //Determining the playable cards for the player
                    playableHandForCurrentPlayer = currentPlayer.getPlayableCards(colorOfNextCard, valueOfNextCard);
                    //The procedure if player's playable hand is not empty
                    if (playableHandForCurrentPlayer.getHandList().size() != 0) {
                        //Printing player's playable hand
                        System.out.println("Cards you can play: ");
                        playableHandForCurrentPlayer.printHand();

                        System.out.print("Please enter the number of the card you want to play: ");
                        input = scanner.nextLine();
                        scanner = new Scanner(System.in);
                        String[] inputArray = input.split(" ", -1);
                        rightInput = false;
                        while (!rightInput) {
                            boolean isDigited = true;
                                for (int i = 0; i < input.length(); i++) {
                                    if (!Character.isDigit(input.charAt(i))) {
                                        System.out.print("Try again: ");
                                        input = scanner.nextLine();
                                        scanner = new Scanner(System.in);
                                        inputArray = input.split(" ", -1);
                                        isDigited = false;
                                    }
                                }
                            if (isDigited){
                                    String number = inputArray[0];
                                    if (Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= playableHandForCurrentPlayer.getHandList().size())
                                        rightInput = true;
                            }
                            else {
                                System.out.print("Try again: ");
                                input = scanner.nextLine();
                                scanner = new Scanner(System.in);
                                inputArray = input.split(" ", -1);
                            }
                        }
                        Card card = playableHandForCurrentPlayer.getHandList().get(Integer.parseInt(input)-1);
                        //Checking if card is NonAction or not
                        if (card instanceof NonActionCard) {
                            currentPlayer.getPlayerHand().removeCard(card);
                            manager.addNewTopCard(card);
                            valueOfNextCard = card.getValue();
                            colorOfNextCard = card.getColor();
                            couldNotPlay=0;
                        }
                        //Checking if card is Action or not
                        else if (card instanceof ActionCard) {
                            //Checking if card is 2-Card or not
                            if (card instanceof ActionCard2) {
                                //Procedure if the only card in player's hand is the 2 card
                                if (currentPlayer.getPlayerHand().getHandList().size() == 1) {
                                    System.out.println("Seems like you cant handover a card! A card is added to your hand from the end of the deck");
                                    currentPlayer.getPlayerHand().addCard(manager.pickCard());
                                    if (clockwise)
                                        currentPlayerIndex--;
                                    else
                                        currentPlayerIndex++;
                                }
                                //Procedure if there is more cards
                                else {
                                    //Getting the receiver player info
                                    System.out.print("Please enter the number of the player you want to give a random card from your hand (from 2 to " + manager.getPlayers().size() + ") :");
                                    input = scanner.nextLine();
                                    scanner = new Scanner(System.in);
                                    rightInput = false;
                                    while (!rightInput) {
                                        int length = input.length();
                                        if (length == 1 && Character.isDigit(input.charAt(0))) {
                                            if (Integer.parseInt(input) <= manager.getPlayers().size() && Integer.parseInt(input) >= 2)
                                                rightInput = true;
                                        } else {
                                            System.out.print("Try again: ");
                                            input = scanner.nextLine();
                                            scanner = new Scanner(System.in);
                                        }
                                    }
                                    int indexOfGetter = Integer.parseInt(input) - 1;
                                    //Determining the random card to be given to the chosen player by user
                                    manager.getPlayers().get(indexOfGetter).getPlayerHand().addCard(currentPlayer.getPlayerHand().dealCard(card));
                                    currentPlayer.getPlayerHand().removeCard(card);
                                    manager.addNewTopCard(card);
                                    valueOfNextCard = card.getValue();
                                    colorOfNextCard = card.getColor();
                                    couldNotPlay=0;
                                }
                            }
                            //Checking if card is 7-NonBlackCard or not
                            else if (card instanceof ActionCard7NonBlack) {
                                currentPlayer.getPlayerHand().removeCard(card);
                                manager.addNewTopCard(card);
                                punishment7 += 1;
                                valueOfNextCard = card.getValue();
                                colorOfNextCard = card.getColor();
                                couldNotPlay=0;
                            }
                            //Checking if card is 7-BlackCard or not
                            else if (card instanceof ActionCard7Black) {
                                currentPlayer.getPlayerHand().removeCard(card);
                                manager.addNewTopCard(card);
                                punishment7 += 2;
                                valueOfNextCard = card.getValue();
                                colorOfNextCard = card.getColor();
                                couldNotPlay=0;
                            }
                            //Checking if card is 8-Card or not
                            else if (card instanceof ActionCard8) {
                                //Procedure if the only playable card in player's hand is the 8 card
                                if (playableHandForCurrentPlayer.getHandList().size() == 1) {
                                    System.out.println("Seems like you cant play another card! A card is added to your hand from the end of the deck");
                                    currentPlayer.getPlayerHand().addCard(manager.pickCard());
                                    if (clockwise)
                                        currentPlayerIndex--;
                                    else
                                        currentPlayerIndex++;
                                    couldNotPlay++;
                                }
                                //Procedure if there is more cards
                                else {
                                    currentPlayer.getPlayerHand().removeCard(card);
                                    manager.addNewTopCard(card);
                                    valueOfNextCard = card.getValue();
                                    colorOfNextCard = card.getColor();
                                    if (clockwise)
                                        currentPlayerIndex--;
                                    else
                                        currentPlayerIndex++;
                                    couldNotPlay=0;

                                }
                            }
                            //Checking if card is 10-Card or not
                            else if (card instanceof ActionCard10) {
                                currentPlayer.getPlayerHand().removeCard(card);
                                manager.addNewTopCard(card);
                                clockwise = !clockwise;
                                valueOfNextCard = card.getValue();
                                colorOfNextCard = card.getColor();
                            }
                            //Checking if card is A-Card or not
                            else if (card instanceof ActionCardA) {
                                currentPlayer.getPlayerHand().removeCard(card);
                                manager.addNewTopCard(card);
                                if (clockwise)
                                    currentPlayerIndex++;
                                else
                                    currentPlayerIndex--;
                                valueOfNextCard = card.getValue();
                                colorOfNextCard = card.getColor();
                                couldNotPlay=0;

                            }
                            //Checking if card is B-Card or not
                            else if (card instanceof ActionCardB) {
                                System.out.print("You want to deal a B card, please enter thr color for next players: ");
                                input = scanner.nextLine();
                                scanner = new Scanner(System.in);
                                rightInput = false;
                                while (!rightInput) {
                                    if (input.equals("red") || input.equals("black") || input.equals("green") || input.equals("blue"))
                                        rightInput = true;
                                    else {
                                        System.out.print("Try again: ");
                                        input = scanner.nextLine();
                                        scanner = new Scanner(System.in);
                                    }
                                }
                                currentPlayer.getPlayerHand().removeCard(card);
                                manager.addNewTopCard(card);
                                valueOfNextCard = "B";
                                colorOfNextCard = input;
                                couldNotPlay=0;
                            }
                        }
                    }
                    //Procedure if there is no playable card in player's hand
                    else {
                        System.out.println("Seems like you cant play a card! A card is added to your hand from the end of the deck");
                        currentPlayer.getPlayerHand().addCard(manager.pickCard());
                        if (clockwise)
                            currentPlayerIndex--;
                        else
                            currentPlayerIndex++;
                        couldNotPlay++;
                    }
                }
                //If player has won, lets finish the game!
                if (currentPlayer.getPlayerHand().calculateHandScore()==0)
                    break;
            }
            //If its the computer's player turn (its is always player with index greater than 0)
            else if (currentPlayerIndex>0&&currentPlayerIndex<manager.getPlayers().size()&&couldNotPlay<2){
                //The procedure if there is a 7-Punishment going
                if (punishment7 != 0) {
                    if (currentPlayer.getPlayerHand().contains7()) {
                        Random random1 = new Random();
                        int deal7 = random1.nextInt(2);
                        if (deal7 == 0) {
                            all7CardsInHand = currentPlayer.get7Cards();
                            Card chosen7 = all7CardsInHand.getHandList().get(random1.nextInt(all7CardsInHand.getHandList().size()));
                            if (chosen7 instanceof ActionCard7Black)
                                punishment7 += 2;
                            else if (chosen7 instanceof ActionCard7NonBlack)
                                punishment7 += 1;
                            currentPlayer.getPlayerHand().removeCard(chosen7);
                            manager.addNewTopCard(chosen7);

                            valueOfNextCard = "7";
                            colorOfNextCard = chosen7.getColor();
                        } else {
                            for (int i = 0; i < (punishment7 * 2); i++) {
                                currentPlayer.getPlayerHand().addCard(manager.pickCard());
                            }
                            punishment7 = 0;
                        }
                    } else {
                        for (int i = 0; i < (punishment7 * 2); i++) {
                            currentPlayer.getPlayerHand().addCard(manager.pickCard());
                        }
                        punishment7 = 0;
                    }
                }
                //The procedure if there is not a 7-Punishment going or player has been punished!
                if (punishment7 == 0) {
                    //Determining the playable cards for the player
                    playableHandForCurrentPlayer = currentPlayer.getPlayableCards(colorOfNextCard, valueOfNextCard);
                    //The procedure if player's playable hand is not empty
                    if (playableHandForCurrentPlayer.getHandList().size() != 0) {

                        Random random1 = new Random();
                        Card card = playableHandForCurrentPlayer.getHandList().get(random1.nextInt(playableHandForCurrentPlayer.getHandList().size()));
                        //Checking if card is NonAction or not
                        if (card instanceof NonActionCard) {
                            currentPlayer.getPlayerHand().removeCard(card);
                            manager.addNewTopCard(card);
                            valueOfNextCard = card.getValue();
                            colorOfNextCard = card.getColor();
                            couldNotPlay=0;
                        }
                        //Checking if card is Action or not
                        else if (card instanceof ActionCard) {
                            //Checking if card is 2-Card or not
                            if (card instanceof ActionCard2) {
                                //Procedure if the only card in player's hand is the 2 card
                                if (currentPlayer.getPlayerHand().getHandList().size() == 1) {
                                    currentPlayer.getPlayerHand().addCard(manager.pickCard());
                                    if (clockwise)
                                        currentPlayerIndex--;
                                    else
                                        currentPlayerIndex++;
                                }
                                //Procedure if there is more cards
                                else {
                                    manager.getPlayers().get(random1.nextInt(manager.getPlayers().size())).getPlayerHand().addCard(currentPlayer.getPlayerHand().dealCard(card));
                                    currentPlayer.getPlayerHand().removeCard(card);
                                    manager.addNewTopCard(card);
                                    valueOfNextCard = card.getValue();
                                    colorOfNextCard = card.getColor();
                                    couldNotPlay=0;
                                }
                            }
                            //Checking if card is 7-NonBlackCard or not
                            else if (card instanceof ActionCard7NonBlack) {
                                currentPlayer.getPlayerHand().removeCard(card);
                                manager.addNewTopCard(card);
                                punishment7 += 1;
                                valueOfNextCard = card.getValue();
                                colorOfNextCard = card.getColor();
                                couldNotPlay=0;
                            }
                            //Checking if card is 7-BlackCard or not
                            else if (card instanceof ActionCard7Black) {
                                currentPlayer.getPlayerHand().removeCard(card);
                                manager.addNewTopCard(card);
                                punishment7 += 2;
                                valueOfNextCard = card.getValue();
                                colorOfNextCard = card.getColor();
                                couldNotPlay=0;
                            }
                            //Checking if card is 8-Card or not
                            else if (card instanceof ActionCard8) {
                                //Procedure if the only playable card in player's hand is the 8 card
                                if (playableHandForCurrentPlayer.getHandList().size() == 1) {
                                    currentPlayer.getPlayerHand().addCard(manager.pickCard());
                                    if (clockwise)
                                        currentPlayerIndex--;
                                    else
                                        currentPlayerIndex++;
                                    couldNotPlay++;
                                }
                                //Procedure if there is more cards
                                else {
                                    currentPlayer.getPlayerHand().removeCard(card);
                                    manager.addNewTopCard(card);
                                    valueOfNextCard = card.getValue();
                                    colorOfNextCard = card.getColor();
                                    if (clockwise)
                                        currentPlayerIndex--;
                                    else
                                        currentPlayerIndex++;
                                    couldNotPlay=0;

                                }
                            }
                            //Checking if card is 10-Card or not
                            else if (card instanceof ActionCard10) {
                                currentPlayer.getPlayerHand().removeCard(card);
                                manager.addNewTopCard(card);
                                clockwise = !clockwise;
                                valueOfNextCard = card.getValue();
                                colorOfNextCard = card.getColor();
                            }
                            //Checking if card is A-Card or not
                            else if (card instanceof ActionCardA) {
                                currentPlayer.getPlayerHand().removeCard(card);
                                manager.addNewTopCard(card);
                                if (clockwise)
                                    currentPlayerIndex++;
                                else
                                    currentPlayerIndex--;
                                valueOfNextCard = card.getValue();
                                colorOfNextCard = card.getColor();
                                couldNotPlay=0;

                            }
                            //Checking if card is B-Card or not
                            else if (card instanceof ActionCardB) {
                                int colorIndex = random1.nextInt(4);
                                String nextColor = "";
                                if (colorIndex==0)
                                    nextColor="red";
                                else if (colorIndex==1)
                                    nextColor="black";
                                else if (colorIndex==2)
                                    nextColor="blue";
                                else if (colorIndex==3)
                                    nextColor="green";
                                currentPlayer.getPlayerHand().removeCard(card);
                                manager.addNewTopCard(card);
                                valueOfNextCard = "B";
                                colorOfNextCard = nextColor;
                                couldNotPlay=0;
                            }
                        }
                    }
                    //Procedure if there is no playable card in player's hand
                    else {
                        currentPlayer.getPlayerHand().addCard(manager.pickCard());
                        if (clockwise)
                            currentPlayerIndex--;
                        else
                            currentPlayerIndex++;
                        couldNotPlay++;
                    }
                }
                //If player has won, lets finish the game!
                if (currentPlayer.getPlayerHand().calculateHandScore()==0)
                    break;
            }
            //Chcking again if there is someone with 0 score
            for (int i = 0; i < game.getPlayers().size(); i++) {
                if (game.getPlayers().get(i).getPlayerHand().calculateHandScore()==0) {
                    exit = true;
                    break;
                }
            }
            //Determining the next player for next turn if game is clockwise
            if (clockwise){
                currentPlayerIndex++;
                currentPlayerIndex = currentPlayerIndex%game.getPlayers().size();
                currentPlayer = game.getPlayers().get(currentPlayerIndex);
            }
            //Determining the next player for next turn if game is anticlockwise
            else {
                currentPlayerIndex--;
                if (currentPlayerIndex<0) {
                    currentPlayerIndex += game.getPlayers().size();
                }
                currentPlayerIndex = currentPlayerIndex%game.getPlayers().size();
                currentPlayer = game.getPlayers().get(currentPlayerIndex);
            }
        }
        //Printing the winner
        System.out.println("Winner Player"+(currentPlayer.getIndex()+1));
        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < game.getPlayers().size(); i++) {
            scores.add(game.getPlayers().get(i).getPlayerHand().calculateHandScore());
            players.add(game.getPlayers().get(i));
        }
        Collections.sort(scores);
        //Printing other players in a sorted order based on their scores
        for (Integer score : scores) {
            if (score > 0) {
                for (int j = 0; j < game.getPlayers().size(); j++) {
                    if (players.get(j).getPlayerHand().calculateHandScore() == score) {
                        System.out.println("Player" + (players.get(j).getIndex() + 1) + "--- Hand score: " + score);
                        players.remove(j);
                        break;
                    }
                }
            }
        }
    }
}
