package net.cs2i.us_football;

import android.app.Activity;
import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mduchemin on 19/02/18.
 */

public class Player {

    private String name, surname, birthdate, url_picture, height, weight, post, tee_num, state;

    /**
     * Get players list from XML file
     * @param activity
     * @return ArrayList<Player>
     * @throws IOException
     * @throws XmlPullParserException
     */

    private ArrayList getPLayers(Activity activity) throws IOException, XmlPullParserException {
        XmlHandler xmlHandler = new XmlHandler();
        XmlPullParser pullParser = xmlHandler.readXML(activity, "players.xml");

        ArrayList<Player> players = new ArrayList<>();
        int eventType = pullParser.getEventType();
        Player currentPlayer = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String eltName = null;

            switch(eventType){
                case XmlPullParser.START_TAG:
                    eltName = pullParser.getName();

                    if ("player".equals(eltName)){
                        currentPlayer = new Player();
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

    public void addPlayerToXml(Context context, String data){
        XmlHandler xmlHandler = new XmlHandler();
        xmlHandler.writeXML(context, data, "players.xml");
    }

    public List<ElementList> genererList(Activity activity) throws IOException, XmlPullParserException {
        ArrayList<Player> players = null;
        try{
            players = this.getPLayers(activity);
        } catch (IOException e){

        }

        List<ElementList> elementLists = new ArrayList<>();

        for (Player player : players){
            elementLists.add(new ElementList(player.url_picture, player.surname + " " + player.name, player.post));
        }

        return elementLists;
    }
}
