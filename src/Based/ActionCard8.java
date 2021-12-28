package Based;

import java.util.Objects;

/**
 * The class for implementation of ActionCard-8.
 * It extends the class Card
 */
public class ActionCard8 extends ActionCard{
    /**
     * Constructor for creating a new ActionCard-8.
     *
     * @param value the value of the ActionCard-8 which is going to be 8
     * @param color the color ActionCard-8
     * Its score is 8
     */
    public ActionCard8(String value, String color) {
        super(value, color, 8);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionCard8 actionCard8 = (ActionCard8) o;
        return getValue().equals(actionCard8.getValue()) && getColor().equals(actionCard8.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getColor());
    }
}
