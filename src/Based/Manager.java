package Based;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The class for implementation of the Manager of the game.
 * Manager's main job is to take care of the cards in the deck
 */
public class Manager {
    /**
     * The constant ANSI_RESET.
     * Used to reset the coloring of the output texts
     */
    public static final String ANSI_RESET = "\u001B[0m";
    /**
     * The constant ANSI_BLACK.
     * Used print the output texts in black
     */
    public static final String ANSI_BLACK = "\u001B[30m";
    /**
     * The constant ANSI_RED.
     * Used print the output texts in red
     */
    public static final String ANSI_RED = "\u001B[31m";
    /**
     * The constant ANSI_GREEN.
     * Used print the output texts in green
     */
    public static final String ANSI_GREEN = "\u001B[32m";
    /**
     * The constant ANSI_BLUE.
     * Used print the output texts in blue
     */
    public static final String ANSI_BLUE = "\u001B[34m";

    /*** ArrayList of the players in the game*/
    private ArrayList<Player> players;
    /*** ArrayList of the cards in the deck*/
    private ArrayList<Card> deck;

    /**
     * Constructor for creating a new Manager.
     * It also creates all 52 cards of the game and puts them in an ArrayList called "deck" which is the deck of the game
     * @param players the ArrayList of the players in the game
     */
    public Manager(ArrayList<Player> players) {
        deck = new ArrayList<>();

        this.players = players;

        for (int i = 0; i < 4; i++) {
            int value = 0;
            for (int j = 0; j < 13; j++) {
                if (i==0){
                    //black
                    if (j==0){
                        ActionCard actionCard = new ActionCard2("2","black");
                        deck.add(actionCard);
                    }
                    else if (j>=1&&j<=4){
                        value = j+2;
                        NonActionCard nonActionCard = new NonActionCard(value+"","black",j+2);
                        deck.add(nonActionCard);
                    }
                    else if (j==5){
                        ActionCard actionCard = new ActionCard7Black("7","black");
                        deck.add(actionCard);
                    }
                    else if (j==6){
                        ActionCard actionCard = new ActionCard8("8","black");
                        deck.add(actionCard);
                    }
                    else if (j==7){
                        NonActionCard nonActionCard = new NonActionCard("9","black",9);
                        deck.add(nonActionCard);
                    }
                    else if (j==8){
                        ActionCard actionCard = new ActionCard10("10","black");
                        deck.add(actionCard);
                    }
                    else if (j==9){
                        ActionCard actionCard = new ActionCardA("A","black");
                        deck.add(actionCard);
                    }
                    else if (j==10){
                        ActionCard actionCard = new ActionCardB("B","black");
                        deck.add(actionCard);
                    }
                    else if (j==11){
                        NonActionCard nonActionCard = new NonActionCard("C","black",12);
                        deck.add(nonActionCard);
                    }
                    else if (j==12){
                        NonActionCard nonActionCard = new NonActionCard("D","black",13);
                        deck.add(nonActionCard);
                    }
                }
                else if (i==1){
                    //red
                    if (j==0){
                        ActionCard actionCard = new ActionCard2("2","red");
                        deck.add(actionCard);
                    }
                    else if (j>=1&&j<=4){
                        value = j+2;
                        NonActionCard nonActionCard = new NonActionCard(value+"","red",j+2);
                        deck.add(nonActionCard);
                    }
                    else if (j==5){
                        ActionCard actionCard = new ActionCard7NonBlack("7","red");
                        deck.add(actionCard);
                    }
                    else if (j==6){
                        ActionCard actionCard = new ActionCard8("8","red");
                        deck.add(actionCard);
                    }
                    else if (j==7){
                        NonActionCard nonActionCard = new NonActionCard("9","red",9);
                        deck.add(nonActionCard);
                    }
                    else if (j==8){
                        ActionCard actionCard = new ActionCard10("10","red");
                        deck.add(actionCard);
                    }
                    else if (j==9){
                        ActionCard actionCard = new ActionCardA("A","red");
                        deck.add(actionCard);
                    }
                    else if (j==10){
                        ActionCard actionCard = new ActionCardB("B","red");
                        deck.add(actionCard);
                    }
                    else if (j==11){
                        NonActionCard nonActionCard = new NonActionCard("C","red",12);
                        deck.add(nonActionCard);
                    }
                    else if (j==12){
                        NonActionCard nonActionCard = new NonActionCard("D","red",13);
                        deck.add(nonActionCard);
                    }
                }
                else if (i==2){
                    //green
                    if (j==0){
                        ActionCard actionCard = new ActionCard2("2","green");
                        deck.add(actionCard);
                    }
                    else if (j>=1&&j<=4){
                        value = j+2;
                        NonActionCard nonActionCard = new NonActionCard(value+"","green",j+2);
                        deck.add(nonActionCard);
                    }
                    else if (j==5){
                        ActionCard actionCard = new ActionCard7NonBlack("7","green");
                        deck.add(actionCard);
                    }
                    else if (j==6){
                        ActionCard actionCard = new ActionCard8("8","green");
                        deck.add(actionCard);
                    }
                    else if (j==7){
                        NonActionCard nonActionCard = new NonActionCard("9","green",9);
                        deck.add(nonActionCard);
                    }
                    else if (j==8){
                        ActionCard actionCard = new ActionCard10("10","green");
                        deck.add(actionCard);
                    }
                    else if (j==9){
                        ActionCard actionCard = new ActionCardA("A","green");
                        deck.add(actionCard);
                    }
                    else if (j==10){
                        ActionCard actionCard = new ActionCardB("B","green");
                        deck.add(actionCard);
                    }
                    else if (j==11){
                        NonActionCard nonActionCard = new NonActionCard("C","green",12);
                        deck.add(nonActionCard);
                    }
                    else if (j==12){
                        NonActionCard nonActionCard = new NonActionCard("D","green",13);
                        deck.add(nonActionCard);
                    }
                }
                else if (i==3){
                    //blue
                    if (j==0){
                        ActionCard actionCard = new ActionCard2("2","blue");
                        deck.add(actionCard);
                    }
                    else if (j>=1&&j<=4){
                        value = j+2;
                        NonActionCard nonActionCard = new NonActionCard(value+"","blue",j+2);
                        deck.add(nonActionCard);
                    }
                    else if (j==5){
                        ActionCard actionCard = new ActionCard7NonBlack("7","blue");
                        deck.add(actionCard);
                    }
                    else if (j==6){
                        ActionCard actionCard = new ActionCard8("8","blue");
                        deck.add(actionCard);
                    }
                    else if (j==7){
                        NonActionCard nonActionCard = new NonActionCard("9","blue",9);
                        deck.add(nonActionCard);
                    }
                    else if (j==8){
                        ActionCard actionCard = new ActionCard10("10","blue");
                        deck.add(actionCard);
                    }
                    else if (j==9){
                        ActionCard actionCard = new ActionCardA("A","blue");
                        deck.add(actionCard);
                    }
                    else if (j==10){
                        ActionCard actionCard = new ActionCardB("B","blue");
                        deck.add(actionCard);
                    }
                    else if (j==11){
                        NonActionCard nonActionCard = new NonActionCard("C","blue",12);
                        deck.add(nonActionCard);
                    }
                    else if (j==12){
                        NonActionCard nonActionCard = new NonActionCard("D","blue",13);
                        deck.add(nonActionCard);
                    }
                }
            }
        }
    }

    /**
     * Deals a random card after shuffling the deck to a player.
     * Used in the beginning of the game to give each player 7 random cards from deck
     * @param index the index of the player who is receiving the card
     */
    public void dealCard(int index){

        Player player = players.get(index);

        Random random = new Random();

        int randomCardIndex = random.nextInt(deck.size());

        Card card = deck.get(randomCardIndex);

        player.getPlayerHand().addCard(card);

        deck.remove(randomCardIndex);
    }

    /**
     * Picks the card which is in the bottom of the deck from it and returns it.
     *
     * @return the card which was in the bottom of the deck and removes it from deck
     */
    public Card pickCard(){
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    /**
     * Sets the TopCard of the deck (middle card in the doc) as a random non action card.
     */
    public void setTopRandomNonActionCard(){
        Collections.shuffle(deck);
        Card card = deck.get(deck.size()-1);
        while (!(card instanceof NonActionCard)){
            Collections.shuffle(deck);
            card = deck.get(deck.size()-1);
        }
    }

    /**
     * Gets the top card (middle card in the doc) of the deck.
     *
     * @return the top card (middle card in the doc) of the deck
     */
    public Card getTopCard(){
        return deck.get(deck.size()-1);
    }

    /**
     * Adds a new top card (middle card in the doc).
     *
     * @param card the card wich is played by the player and is going to be the top card (middle card in the doc) of the deck
     */
    public void addNewTopCard(Card card){
        Card preTopCard = deck.get(deck.size()-1);
        Collections.reverse(deck);
        deck.add(preTopCard);
        deck.remove(0);
        Collections.reverse(deck);
        deck.add(card);
    }

    /**
     * Prints top card (middle card in the doc).
     * It shows which card is the beginner card at the start of the game and shows the played card by previous player,
     * basically it prints the top card (middle card in the doc) with the color based on the top card's color
     */
    public void printTopCard(){
        if (deck.get(deck.size()-1).getColor().equals("black"))
            System.out.print(""+ANSI_BLACK);
        else if (deck.get(deck.size()-1).getColor().equals("blue"))
            System.out.print(""+ANSI_BLUE);
        else if (deck.get(deck.size()-1).getColor().equals("green"))
            System.out.print(""+ANSI_GREEN);
        else if (deck.get(deck.size()-1).getColor().equals("red"))
            System.out.print(""+ANSI_RED);
        System.out.println("+-----------+");
        System.out.printf("|  %2s       |\n",deck.get(deck.size()-1).getValue());
        System.out.println("|           |");
        System.out.println("|           |");
        System.out.printf("|       %2s  |\n",deck.get(deck.size()-1).getValue());
        System.out.println("+-----------+"+ANSI_RESET);
    }

    /**
     * Gets players which is the ArrayList of the players in the game.
     *
     * @return the players, the ArrayList of the players in the game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

}
