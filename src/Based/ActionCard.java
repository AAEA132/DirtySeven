package Based;

/**
 * The abstract class for implementation of ActionCards.
 * It extends the class Card
 */
public abstract class ActionCard extends Card{

    /**
     * Constructor for creating a new ActionCard.
     * @param value the value of the ActionCard
     * @param color the color of the ActionCard
     * @param score the score of the ActionCard
     */
    public ActionCard(String value, String color, int score) {
        super(value, color, score);
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}
