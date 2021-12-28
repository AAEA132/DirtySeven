package Based;

import java.util.Objects;


/**
 * The class for implementation of ActionCard-2.
 * It extends the class Card
 */
public class ActionCard2 extends ActionCard{
    /**
     * Constructor for creating a new ActionCard-2.
     *
     * @param value the value of the ActionCard-2 which is going to be 2
     * @param color the color ActionCard-2
     * Its score is 2
     */
    public ActionCard2(String value, String color) {
        super(value, color, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionCard2 actionCard2 = (ActionCard2) o;
        return getValue().equals(actionCard2.getValue()) && getColor().equals(actionCard2.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getColor());
    }
}
