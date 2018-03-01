package net.cs2i.us_football;

import android.app.Activity;
import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by mduchemin on 19/02/18.
 */

public class XmlHandler {

    public XmlPullParser readXML(Activity activity, String file) {
        XmlPullParserFactory parserFactory;
        XmlPullParser parser = null;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            parser = parserFactory.newPullParser();
            FileInputStream is = activity.openFileInput(file);
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);
            //is.close(); ça plante si on décommente !!!

        } catch (XmlPullParserException e) {} catch (IOException e) {}

        return parser;
    }

    public void writeXML(Context context, String xml, String file){
        try {
            FileOutputStream fOut = context.openFileOutput(file, context.MODE_PRIVATE);

            fOut.write(xml.getBytes());
            fOut.close();
        } catch (IOException e) {}
    }
}