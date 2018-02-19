package net.cs2i.us_football;

/**
 * Created by mduchemin on 19/02/18.
 */

public class ElementList {
    private int color;
    private String mainText;
    private String text;

    public ElementList(int color, String mainText, String text) {
        this.color = color;
        this.mainText = mainText;
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public String getMainText() {
        return mainText;
    }

    public String getText() {
        return text;
    }
}
