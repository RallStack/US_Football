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

    public ArrayList processParsingPlayer(XmlPullParser parser) throws IOException, XmlPullParserException {
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
                        players.add(currentPlayer);
                    } else if (currentPlayer != null){
                        switch (eltName) {
                            case "name":
                                currentPlayer.name = parser.nextText();
                                break;
                            case "surname":
                                currentPlayer.surname = parser.nextText();
                                break;
                            case "birthdate":
                                currentPlayer.birthdate = parser.nextText();
                                break;
                            case "url_picture":
                                currentPlayer.url_picture = parser.nextText();
                                break;
                            case "height":
                                currentPlayer.height = parser.nextText();
                                break;
                            case "weight":
                                currentPlayer.weight = parser.nextText();
                                break;
                            case "post":
                                currentPlayer.post = parser.nextText();
                                break;
                            case "tee_num":
                                currentPlayer.tee_num = parser.nextText();
                                break;
                            case "state":
                                currentPlayer.state = parser.nextText();
                                break;
                        }
                    }
                    break;
            }

            eventType = parser.next();
        }

        return players;
    }
}