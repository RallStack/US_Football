package net.cs2i.us_football;

import android.app.Activity;
import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by mduchemin on 19/02/18.
 */

public class Player{

    private static final String filename = "players.xml";
    private String name, surname, birthdate, url_picture, height, weight, post, tee_num, state;
    XmlHandler xmlHandler;

    public Player(){
        xmlHandler = new XmlHandler();
    }

    public void createPlayerFile(Context context){
        xmlHandler.CreateXmlFile(context, filename, new ArrayList<String>());
    }

    public ArrayList getPLayers(Context context) throws IOException, XmlPullParserException {
        XmlPullParser pullParser = xmlHandler.readXML(context, filename);

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

    public void addPlayerToXml(Context context, Hashtable dataTable){
        String data =
                "<player>" +
                "<firstname>"+ dataTable.get("firstname") +"</firstname>" +
                "<lastname>"+ dataTable.get("lastname") +"</lastname>" +
                "<birthdate>"+ dataTable.get("birthday") +"</birthdate>" +
                "<url_picture></url_picture>" +
                "<height>"+ dataTable.get("height") +"</height>" +
                "<weight>"+ dataTable.get("weight") +"</weight>" +
                "<post>"+ dataTable.get("post") +"</post>" +
                "<tee_num>"+ dataTable.get("teeNumber") +"</tee_num>" +
                "<state>"+ dataTable.get("state") +"</state>" +
                "</player>";


        xmlHandler.writeXML(context, data, filename, "");
    }

    public List<ElementList> generateList(Context context) throws IOException, XmlPullParserException {
        ArrayList<Player> players = null;
        try{
            players = this.getPLayers(context);
        } catch (IOException e){

        }

        List<ElementList> elementLists = new ArrayList<>();

        for (Player player : players){
            elementLists.add(new ElementList(player.surname + " " + player.name, player.post));
        }

        return elementLists;
    }



    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getPost(){
        return this.post;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setPost(String post){
        this.post = post;
    }
}