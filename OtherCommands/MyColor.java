package OtherCommands;
import java.awt.Color;

/**
 * A class to get the Color value from a string color name
 */
public class MyColor {
    private static Color color;

    public MyColor(){
        color = Color.WHITE;
    }
    /**
     * Get the color from a string name
     *
     * @param col name of the color
     * @return White if no color is given, otherwise the Color object
     */
    static Color getColor(String col) {
        if ("black".equals(col.toLowerCase())) {
            color = Color.BLACK;
        } else if ("blue".equals(col.toLowerCase())) {
            color = Color.BLUE;
        } else if ("cyan".equals(col.toLowerCase())) {
            color = Color.CYAN;
        } else if ("darkgray".equals(col.toLowerCase())) {
            color = Color.DARK_GRAY;
        } else if ("gray".equals(col.toLowerCase())) {
            color = Color.GRAY;
        } else if ("green".equals(col.toLowerCase())) {
            color = Color.GREEN;
        } else if ("yellow".equals(col.toLowerCase())) {
            color = Color.YELLOW;
        } else if ("lightgray".equals(col.toLowerCase())) {
            color = Color.LIGHT_GRAY;
        } else if ("magneta".equals(col.toLowerCase())) {
            color = Color.MAGENTA;
        } else if ("orange".equals(col.toLowerCase())) {
            color = Color.ORANGE;
        } else if ("pink".equals(col.toLowerCase())) {
            color = Color.PINK;
        } else if ("red".equals(col.toLowerCase())) {
            color = Color.RED;
        } else if ("white".equals(col.toLowerCase())) {
            color = Color.WHITE;
        }
        return color;
    }
}