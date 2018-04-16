package net.cs2i.us_football.Entity;

import net.cs2i.us_football.Utils.XmlHandler;

/**
 * Created by thomas on 15/04/2018.
 */

public class Strategie {
    private static final String filename = "strategie.xml";
    String name, image;
    XmlHandler xmlHandler;

    public Strategie(){
        xmlHandler = new XmlHandler();
    }

    /* ------------- Getters and Setters ------------- */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
