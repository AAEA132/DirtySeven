package Based;

import java.util.Objects;
/**
 * The class for implementation of Card.
 * It is used to be the founding class for cards which other subclasses of cards will extend it and inheritance its properties
 */
public class Card {
    private String value;
    private String color;
    private int score;

    /**
     * Constructor for creating a new Card.
     * @param value the value of the card (2 to 10, A, B, C, D)
     * @param color the color of the card (red, blue, green, black)
     * @param score the score of the card
     */
    public Card(String value, String color, int score) {
        this.value = value;
        this.color = color;
        this.score = score;
    }

    /**
     * Gets the value of the card.
     *
     * @return the value of the card
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the card.
     *
     * @param value the value of the card
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the color of the card.
     *
     * @return the color of the card
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the card.
     *
     * @param color the color of the card
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the score of the card.
     *
     * @return the score of the card
     */
    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return getValue().equals(card.getValue()) && getColor().equals(card.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getColor());
    }
}
