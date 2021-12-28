package Based;

/**
 * The class for implementation of each player in game.
 */
public class Player {
    private Hand playerHand;
    private int index;

    /**
     * Constructor for creating a new Player.
     * @param index the index of the player in the list of the players in game;
     *              Used for specifying which player is playing in each turn
     */
    public Player(int index) {
        playerHand = new Hand();
        this.index = index;
    }

    /**
     * Gets the player's hand.
     *
     * @return the player's hand which is an ArrayList of it's cards
     */
    public Hand getPlayerHand() {
        return playerHand;
    }

    /**
     * Gets the index of the player
     *              Used for specifying which player is playing in each turn
     * @return the index of the player in the list of the players in game
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets the playable cards of the player's hand.
     * @param color the color which makes a card playable in player's hand
     *              Its either the current TopCard (middle card in the doc) or the color set by a previous B-Card
     * @param value the value which makes a card playable in player's hand
     *               Its the value of the current TopCard (middle card in the doc)
     * @return a hand which is consisted of all of the playable cards in the player's hand
     */
    public Hand getPlayableCards(String color, String value){
        Hand playableHand = new Hand();
        for (Card card : playerHand.getHandList()){
            if (color.equals(card.getColor()) || value.equals(card.getValue()) || card instanceof ActionCardB){
                playableHand.addCard(card);
            }
        }
        return playableHand;
    }

    /**
     * Gets all the 7-cards in the player's hand.
     *
     * @return a hand which is consisted all of the 7-cards in the player's hand
     */
    public Hand get7Cards(){
        Hand get7Cards = new Hand();
        for (Card card : playerHand.getHandList()){
            if (card.getValue().equals("7")){
                get7Cards.addCard(card);
            }
        }
        return get7Cards;
    }
}
