package net.cs2i.us_football.Entity;

/**
 * Created by mduchemin on 19/02/18.
 */

public class ElementList {
    //private String url_picture;
    private String mainText;
    private String text;

    public ElementList(String mainText, String text) {
        this.mainText = mainText;
        this.text = text;
    }

    public String getMainText() {
        return mainText;
    }

    public String getText() {
        return text;
    }
}
