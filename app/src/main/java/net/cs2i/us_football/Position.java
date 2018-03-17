package net.cs2i.us_football;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mduchemin on 16/03/18.
 */

public class Position {
    private static final String filename = "positions.xml";
    private String id, name, shortcut;
    XmlHandler xmlHandler;
/*
    public Position(){
        xmlHandler = new XmlHandler();
    }

    private ArrayList getPosition(Context context) throws IOException, XmlPullParserException {
        XmlPullParser pullParser = xmlHandler.readXML(context, filename);

        ArrayList<Position> positions = new ArrayList<>();
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
                            case "firstname":
                                currentPlayer.name = pullParser.nextText();
                                break;
                            case "lastname":
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

    public List<ElementList> generateList(Context context) throws IOException, XmlPullParserException {
        ArrayList<Player> players = null;
        try{
            players = this.getPLayers(context);
        } catch (IOException e){

        }

        List<ElementList> elementLists = new ArrayList<>();

        for (Player player : players){
            elementLists.add(new ElementList(player.url_picture, player.surname + " " + player.name, player.post));
        }

        return elementLists;
    }*/
}
