package net.cs2i.us_football;

/**
 * Created by mduchemin on 19/02/18.
 */

public class ElementList {
    private String url_picture;
    private String mainText;
    private String text;

    public ElementList(String url_picture, String mainText, String text) {
        this.url_picture = url_picture;
        this.mainText = mainText;
        this.text = text;
    }

    public String getUrl_picture() {
        return url_picture;
    }

    public String getMainText() {
        return mainText;
    }

    public String getText() {
        return text;
    }
}
