package net.cs2i.us_football.Table;

import android.content.Context;

import net.cs2i.us_football.Entity.Player;
import net.cs2i.us_football.Utils.XmlHandler;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by mduchemin on 02/04/18.
 */

public class PlayerTable {
   private List<Player> players;
   private XmlHandler xmlHandler;

   private static final String filename = "players.xml";

   /* ------------- Constructor ------------- */

   public PlayerTable(Context context){
       xmlHandler = new XmlHandler();
       players = new ArrayList<Player>();

       xmlHandler.CreateXmlFile(context, filename, new ArrayList<String>());

       try {
           getAllPLayers(context);
       } catch (IOException e) { e.printStackTrace(); } catch (XmlPullParserException e) { e.printStackTrace(); }
   }

    /* ------------- Public function ------------- */

    public void addPlayerToXml(Context context, Hashtable dataTable){

        if (checkTeeNumber(dataTable.get("teeNumber").toString())){
            String data =
                    "<player>" +
                        "<name>"+ dataTable.get("name") +"</name>" +
                        "<birthdate>"+ dataTable.get("birthday") +"</birthdate>" +
                        "<height>"+ dataTable.get("height") +"</height>" +
                        "<weight>"+ dataTable.get("weight") +"</weight>" +
                        "<post>"+ dataTable.get("post") +"</post>" +
                        "<tee_num>"+ dataTable.get("teeNumber") +"</tee_num>" +
                    "</player>";

            xmlHandler.writeXML(context, data, filename, "");
        } else {

        }
    }

    public void updatePlayerList(Context context, List<Player> newListPlayers){
        String data = "<players>";

        for (Player player : newListPlayers) {
            data +=
                    "<player>" +
                            "<name>"+ player.getName() +"</name>" +
                            "<birthdate>"+ player.getBirthdate() +"</birthdate>" +
                            "<height>"+ player.getHeight() +"</height>" +
                            "<weight>"+ player.getWeight() +"</weight>" +
                            "<post>"+ player.getPost() +"</post>" +
                            "<tee_num>"+ player.getTee_num() +"</tee_num>" +
                    "</player>";
        }

        data += "</players>";

        xmlHandler.writeXML(context, data, filename, "players");
    }

    /* ------------- Private function ------------- */

    private void getAllPLayers(Context context) throws IOException, XmlPullParserException {
        XmlPullParser pullParser = xmlHandler.readXML(context, filename);

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
                                currentPlayer.setName(pullParser.nextText());
                                break;
                            case "birthdate":
                                currentPlayer.setBirthdate(pullParser.nextText());
                                break;
                            case "height":
                                currentPlayer.setHeight(pullParser.nextText());
                                break;
                            case "weight":
                                currentPlayer.setWeight(pullParser.nextText());
                                break;
                            case "post":
                                currentPlayer.setPost(pullParser.nextText());
                                break;
                            case "tee_num":
                                currentPlayer.setTee_num(pullParser.nextText());
                                break;
                        }
                    }
                    break;
            }

            eventType = pullParser.next();
        }
    }

    private boolean checkTeeNumber(String teeNumber){
        for ( Player player : players) {
            if (player.getTee_num() == teeNumber){
                return false;
            }
        }
        return true;
    }

    /* ------------- Getters and Setters ------------- */

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}