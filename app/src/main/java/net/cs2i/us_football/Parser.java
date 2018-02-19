package net.cs2i.us_football;

import android.app.Activity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by mduchemin on 19/02/18.
 */

public class Parser {

    public void parseXML(Activity activity){
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = activity.getAssets().open("player.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            processParsing(parser);

        } catch(XmlPullParserException e){

        } catch(IOException e) {

        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<Players> players = new ArrayList<>();
        int eventType = parser.getEventType();
        Players currentPlayer = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String eltName = null;

            switch (eventType){
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();

                    if ("player".equals(eltName)){
                        currentPlayer = new Players();
                    } else if (){
                        if ("name".equals(eltName)){
                            currentPlayer.name = parser.nextText();
                        }
                    }
                    break;
            }

            eventType = parser.next();
        }

        printPlayer(players);
    }

    private void printPlayer(ArrayList<Players> players) {
        StringBuilder builder =  new StringBuilder();

        for (Players player : players) {
            builder.append(player.name).append("\n");
        }
    }
}