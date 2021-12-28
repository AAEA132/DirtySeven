package Based;

import java.util.Objects;

/**
 * The class for implementation of ActionCard-A.
 * It extends the class Card
 */
public class ActionCardA extends ActionCard{
    /**
     * Constructor for creating a new ActionCard-A.
     *
     * @param value the value of the ActionCard-A which is going to be A
     * @param color the color ActionCard-A
     * Its score is 11
     */
    public ActionCardA(String value, String color) {
        super(value, color, 11);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionCardA actionCardA = (ActionCardA) o;
        return getValue().equals(actionCardA.getValue()) && getColor().equals(actionCardA.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getColor());
    }
}
