package Based;

import java.util.ArrayList;
import java.util.Random;

/**
 *  * The class for implementation of Hand.
 *  A hand is an ArrayList of cards together
 */
public class Hand {
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

    /*** ArrayList of the cards in the hand*/
    private ArrayList<Card> handList;

    /**
     * Constructor for creating a new Hand.
     */
    public Hand() {
        handList = new ArrayList<>();
    }

    /**
     * Adds a card to the hand's ArrayList of cards.
     *
     * @param card the card which is going to be added to the hand's ArrayList of cards
     */
    public void addCard(Card card){
        handList.add(card);
    }

    /**
     * Removes a card from the hand's ArrayList of cards.
     *
     * @param card the card which is going to be removed from the hand's ArrayList of cards
     */
    public void removeCard(Card card){
        handList.remove(card);
    };

    /**
     * Calculate the hand's score based on the cards it has.
     *
     * @return an int which is the total score of the hand
     */
    public int calculateHandScore(){
        int score = 0;
        for (Card card : handList) {
            score += card.getScore();
        }
        return score;
    }

    /**
     * Gets the  hand's Array List of cards.
     *
     * @return the hand's Array List of cards
     */
    public ArrayList<Card> getHandList() {
        return handList;
    }

    /**
     * Deals a random card from the hand and removes it from hand's Array List of cards.
     *It is used for giving a random card to a player when playing the 2-Card
     * @param card the 2-Card which is played and is going to be the next top card (middle card in the doc), so it cant be given
     * @return the random card which is going to be given to another player and is not the played 2=Card
     */
    public Card dealCard(Card card){
        Random random = new Random();
        int randomIndex = random.nextInt(handList.size());
        while (card.equals(handList.get(randomIndex))){
            randomIndex = random.nextInt(handList.size());
        }
        Card dealtRandomCard = handList.get(randomIndex);
        handList.remove(randomIndex);
        return dealtRandomCard;
    }

    /**
     * Checks if the hand's ArrayList of cards contains a 7-Card.
     *Used when a player has 7-Punishment in the game
     * @return true if the hand has at least one 7-Card, otherwise returns false
     */
    public boolean contains7(){
        for (Card card : handList){
            if (card.getValue().equals(7+""))
                return true;
        }
        return false;
    }

    /**
     * Prints the hand in a format similar to the one in doc.
     * Its colorized based on the color of the cards it has!
     */
    public void printHand(){
        for (int i = 0; i < handList.size()-1; i++){

            if (handList.get(i).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
            else if (handList.get(i).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
            else if (handList.get(i).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
            else if (handList.get(i).getColor().equals("red")) System.out.print(""+ANSI_RED);

            System.out.print("+------ ");
        }

        if (handList.get(handList.size()-1).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
        else if (handList.get(handList.size()-1).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
        else if (handList.get(handList.size()-1).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
        else if (handList.get(handList.size()-1).getColor().equals("red")) System.out.print(""+ANSI_RED);

        System.out.println("+-----------+");

        for (int i = 0; i < handList.size(); i++){

            if (handList.get(i).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
            else if (handList.get(i).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
            else if (handList.get(i).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
            else if (handList.get(i).getColor().equals("red")) System.out.print(""+ANSI_RED);

            System.out.printf("|  %2s   ",handList.get(i).getValue());
        }

        if (handList.get(handList.size()-1).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
        else if (handList.get(handList.size()-1).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
        else if (handList.get(handList.size()-1).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
        else if (handList.get(handList.size()-1).getColor().equals("red")) System.out.print(""+ANSI_RED);

        System.out.println("    |");

        for (int i = 0; i < handList.size()-1; i++){
            if (handList.get(i).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
            else if (handList.get(i).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
            else if (handList.get(i).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
            else if (handList.get(i).getColor().equals("red")) System.out.print(""+ANSI_RED);
            System.out.print("|       ");
        }
        if (handList.get(handList.size()-1).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
        else if (handList.get(handList.size()-1).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
        else if (handList.get(handList.size()-1).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
        else if (handList.get(handList.size()-1).getColor().equals("red")) System.out.print(""+ANSI_RED);

        System.out.println("|           |");

        for (int i = 0; i < handList.size()-1; i++) {

            if (handList.get(i).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
            else if (handList.get(i).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
            else if (handList.get(i).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
            else if (handList.get(i).getColor().equals("red")) System.out.print(""+ANSI_RED);

            System.out.print("|       ");
        }
        if (handList.get(handList.size()-1).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
        else if (handList.get(handList.size()-1).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
        else if (handList.get(handList.size()-1).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
        else if (handList.get(handList.size()-1).getColor().equals("red")) System.out.print(""+ANSI_RED);
        System.out.println("|           |");

        for (int i = 0; i < handList.size()-1; i++){

            if (handList.get(i).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
            else if (handList.get(i).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
            else if (handList.get(i).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
            else if (handList.get(i).getColor().equals("red")) System.out.print(""+ANSI_RED);
            System.out.print("|       ");

        }
        if (handList.get(handList.size()-1).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
        else if (handList.get(handList.size()-1).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
        else if (handList.get(handList.size()-1).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
        else if (handList.get(handList.size()-1).getColor().equals("red")) System.out.print(""+ANSI_RED);
        System.out.printf("|       %2s  |\n",handList.get(handList.size()-1).getValue());

        for (int i = 0; i < handList.size()-1; i++) {

            if (handList.get(i).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
            else if (handList.get(i).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
            else if (handList.get(i).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
            else if (handList.get(i).getColor().equals("red")) System.out.print(""+ANSI_RED);

            System.out.print("+------ ");
        }

        if (handList.get(handList.size()-1).getColor().equals("black")) System.out.print(""+ANSI_BLACK);
        else if (handList.get(handList.size()-1).getColor().equals("blue")) System.out.print(""+ANSI_BLUE);
        else if (handList.get(handList.size()-1).getColor().equals("green")) System.out.print(""+ANSI_GREEN);
        else if (handList.get(handList.size()-1).getColor().equals("red")) System.out.print(""+ANSI_RED);

        System.out.println("+-----------+"+ANSI_RESET);

        for (int i = 0; i < handList.size(); i++) {
            System.out.printf("   %2d   ",(i+1));
        }
        System.out.printf("\n");
    }
}
