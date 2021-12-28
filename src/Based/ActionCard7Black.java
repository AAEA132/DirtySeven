package Based;

import java.util.Objects;

/**
 * The class for implementation of ActionCard-7-Black.
 * It extends the class Card
 */
public class ActionCard7Black extends ActionCard{
    /**
     * Constructor for creating a new ActionCard-7-Black.
     *
     * @param value the value of the ActionCard-7-Black which is going to be 7
     * @param color the color ActionCard-7-Black, its going to be black
     * Its score is 15
     */
    public ActionCard7Black(String value, String color) {
        super(value, color, 15);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionCard7Black actionCard7Black = (ActionCard7Black) o;
        return getValue().equals(actionCard7Black.getValue()) && getColor().equals(actionCard7Black.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getColor());
    }
}
