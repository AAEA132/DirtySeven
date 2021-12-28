package Based;

import java.util.Objects;

/**
 * The class for implementation of ActionCard-10.
 * It extends the class Card
 */
public class ActionCard10 extends ActionCard{
    /**
     * Constructor for creating a new ActionCard-10.
     *
     * @param value the value of the ActionCard-10 which is going to be 10
     * @param color the color ActionCard-10
     * Its score is 10
     */
    public ActionCard10(String value, String color) {
        super(value, color, 10);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionCard10 actionCard10 = (ActionCard10) o;
        return getValue().equals(actionCard10.getValue()) && getColor().equals(actionCard10.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getColor());
    }
}
