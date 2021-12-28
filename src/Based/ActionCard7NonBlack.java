package Based;

import java.util.Objects;

/**
 * The class for implementation of ActionCard-7-NonBlack.
 * It extends the class Card
 */
public class ActionCard7NonBlack extends ActionCard{
    /**
     * Constructor for creating a new ActionCard-7-NonBlack.
     *
     * @param value the value of the ActionCard-7-NonBlack which is going to be 7
     * @param color the color ActionCard-7-NonBlack, its either blue or red or green
     * Its score is 10
     */
    public ActionCard7NonBlack(String value, String color) {
        super(value, color, 10);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionCard7NonBlack actionCard7NonBlack = (ActionCard7NonBlack) o;
        return getValue().equals(actionCard7NonBlack.getValue()) && getColor().equals(actionCard7NonBlack.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getColor());
    }
}
