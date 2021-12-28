package Based;

import java.util.Objects;

/**
 * The class for implementation of ActionCard-B.
 * It extends the class Card
 */
public class ActionCardB extends ActionCard{
    /**
     * Constructor for creating a new ActionCard-b.
     *
     * @param value the value of the ActionCard-B which is going to be B
     * @param color the color ActionCard-B
     * Its score is 12
     */
    public ActionCardB(String value, String color) {
        super(value, color, 12);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionCardB actionCardA = (ActionCardB) o;
        return getValue().equals(actionCardA.getValue()) && getColor().equals(actionCardA.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getColor());
    }
}
