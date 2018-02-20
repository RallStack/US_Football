package net.cs2i.us_football;

import android.app.Activity;
import android.content.Context;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mduchemin on 19/02/18.
 */

public class Players{

    private String name, surname, birthdate, url_picture, height, weight, post, tee_num, state;

    private ArrayList getPLayers(Activity activity) throws IOException, XmlPullParserException {
        Parser parser = new Parser();
        XmlPullParser pullParser = parser.parseXML(activity, "players.xml");

        ArrayList<Players> players = new ArrayList<>();
        int eventType = pullParser.getEventType();
        Players currentPlayer = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String eltName = null;

            switch(eventType){
                case XmlPullParser.START_TAG:
                    eltName = pullParser.getName();

                    if ("player".equals(eltName)){
                        currentPlayer = new Players();
                        players.add(currentPlayer);
                    } else if (currentPlayer != null){
                        switch (eltName) {
                            case "name":
                                currentPlayer.name = pullParser.nextText();
                                break;
                            case "surname":
                                currentPlayer.surname = pullParser.nextText();
                                break;
                            case "birthdate":
                                currentPlayer.birthdate = pullParser.nextText();
                                break;
                            case "url_picture":
                                currentPlayer.url_picture = pullParser.nextText();
                                break;
                            case "height":
                                currentPlayer.height = pullParser.nextText();
                                break;
                            case "weight":
                                currentPlayer.weight = pullParser.nextText();
                                break;
                            case "post":
                                currentPlayer.post = pullParser.nextText();
                                break;
                            case "tee_num":
                                currentPlayer.tee_num = pullParser.nextText();
                                break;
                            case "state":
                                currentPlayer.state = pullParser.nextText();
                                break;
                        }
                    }
                    break;
            }

            eventType = pullParser.next();
        }

        return players;
    }

    private void CreateXml(Activity activity, String file){

        FileOutputStream fos = null;
        try {
            fos = activity.openFileOutput(file, Context.MODE_APPEND);

            XmlSerializer serializer = Xml.newSerializer();

            serializer.setOutput(fos, "UTF-8");
            serializer.startDocument(null, Boolean.valueOf(true));
            serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

            serializer.startTag(null, "root");

            for(int j = 0 ; j < 3 ; j++)
            {
                serializer.startTag(null, "record");
                serializer.text("test");
                serializer.endTag(null, "record");
            }
            serializer.endDocument();

            serializer.flush();

            fos.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public List<ElementList> genererList(Activity activity) throws IOException, XmlPullParserException {
        ArrayList<Players> players = null;
        try{
            players = this.getPLayers(activity);
        } catch (IOException e){

        }

        List<ElementList> elementLists = new ArrayList<>();

        for (Players player : players){
            elementLists.add(new ElementList(player.url_picture, player.surname + " " + player.name, player.post));
        }

        return elementLists;
    }
}
