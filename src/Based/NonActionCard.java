package Based;

/**
 * The class for implementation of Non action cards.
 */
public class NonActionCard extends Card{
    /**
     * Constructor for creating a new NonActionCard.
     *
     * @param value the value of the NonActionCard
     * @param color the color of the NonActionCard
     * @param score the score of the NonActionCard
     *              Which is the same as the value for cards with a value from {3, 4, 5, 6, 9}
     */
    public NonActionCard(String value, String color, int score ) {
        super(value,color,score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonActionCard nonActionCard = (NonActionCard) o;
        return getValue().equals(nonActionCard.getValue()) && getColor().equals(nonActionCard.getColor());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
