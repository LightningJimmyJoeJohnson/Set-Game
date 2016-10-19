import java.awt.*;

/**
 * Created by meyerhallot on 10/10/16.
 */
public class Card {
    private String color;
    private String shape;
    private String shading;
    private String quantity;

    public void makeCard(String props){ //properties of this card
        System.out.println(props);
        String[] propsSplit = props.split(",");
        color = propsSplit[0];
        shape = propsSplit[1];
        shading = propsSplit[2];
        quantity = propsSplit[3];
    }

    public String getColor() {
        return color;
    }

    public String getShape() {
        return shape;
    }

    public String getShading() {
        return shading;
    }

    public String getQuantity() {
        return quantity;
    }




}
