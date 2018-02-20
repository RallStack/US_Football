package net.cs2i.us_football;

import android.app.Activity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by mduchemin on 19/02/18.
 */

public class Parser {

    public XmlPullParser parseXML(Activity activity, String file){
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = activity.getAssets().open(file);
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            return parser;

        } catch(XmlPullParserException e){

        } catch(IOException e) {

        }

        return null;
    }
}