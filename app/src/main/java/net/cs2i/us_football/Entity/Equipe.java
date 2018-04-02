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

    public void createEquipeFile(Context context){
        ArrayList<String> options = new ArrayList<String>();
        options.add("equipe-attaque");
        options.add("equipe-defense");
        options.add("equipe-special");

        xmlHandler.CreateXmlFile(context, filename, options);
    }

    private ArrayList getList(Context context, String tag) throws IOException, XmlPullParserException {
        XmlPullParser pullParser = xmlHandler.readXML(context, filename);

        ArrayList<Equipe> equipe = new ArrayList<>();

        int eventType = pullParser.getEventType();
        Equipe currentPlayer = null;

        boolean getPlayer = false;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String eltName = null;

            switch(eventType){
                case XmlPullParser.START_TAG:
                    eltName = pullParser.getName();

                    if (eltName.matches("equipe-.*")){
                        if (("equipe-"+tag).equals(eltName)){
                            getPlayer = true;
                        } else{
                            getPlayer = false;
                        }
                    }

                    if (getPlayer){
                        if ("player".equals(eltName)){
                            currentPlayer = new Equipe();
                            equipe.add(currentPlayer);
                        } else if (currentPlayer != null){
                            switch (eltName) {
                                case "name":
                                    currentPlayer.name = pullParser.nextText();
                                    break;
                            }
                        }
                    }
                    break;
            }

            eventType = pullParser.next();
        }

        return equipe;
    }

    public void addEquipeToXml(Context context, List<ElementList> players, String type){
        String data =
                "<equipe-"+type+">";

        for (ElementList player : players) {
            data +=
            "<player>" +
            "<name>"+ player.getMainText() +"</name>" +
            "</player>";
        }

        data += "</equipe-"+type+">";

        xmlHandler.writeXML(context, data, filename, "equipe-"+type);
    }

    public List<ElementList> generateList(Context context, String tag) throws IOException, XmlPullParserException {
        ArrayList<Equipe> equipes = null;
        try{
            equipes = this.getList(context, tag);
        } catch (IOException e){

        }

        List<ElementList> elementLists = new ArrayList<>();

        for (Equipe equipe : equipes){
            elementLists.add(new ElementList( equipe.name, ""));
        }

        return elementLists;
    }
}
