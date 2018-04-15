package net.cs2i.us_football.Entity;

import android.content.Context;

import net.cs2i.us_football.Utils.XmlHandler;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mduchemin on 19/02/18.
 */

public class Equipe {

    private static final String filename = "equipes.xml";
    String name, post;
    XmlHandler xmlHandler;

    public Equipe(){
        xmlHandler = new XmlHandler();
    }
}
