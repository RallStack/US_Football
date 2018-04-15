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

public class EquipeTable {

    private List<Player> players;
    private XmlHandler xmlHandler;
    private String tag;

    private static final String filename = "equipes.xml";

    /* ------------- Constructor ------------- */

    public EquipeTable(Context context, String tag){
        this.tag = tag;

        xmlHandler = new XmlHandler();
        players = new ArrayList<Player>();

        ArrayList<String> options = new ArrayList<String>();
        options.add("equipe-attaque");
        options.add("equipe-defense");
        options.add("equipe-special");

        xmlHandler.CreateXmlFile(context, filename, options);

        try {
            getAllEquipes(context);
        } catch (IOException e) { e.printStackTrace(); } catch (XmlPullParserException e) { e.printStackTrace(); }
    }

    /* ------------- Public function ------------- */

    public void addEquipeToXml(Context context, List<Player> newListPlayers){
            String data =
                    "<equipe-"+tag+">";

            for (Player player : newListPlayers) {
                data +=
                        "<player>" +
                                "<name>"+ player.getName() +"</name>" +
                                "</player>";
            }

            data += "</equipe-"+tag+">";

            xmlHandler.writeXML(context, data, filename, "equipe-"+tag);

    }

    /* ------------- Private function ------------- */

    private void getAllEquipes(Context context) throws IOException, XmlPullParserException {
        XmlPullParser pullParser = xmlHandler.readXML(context, filename);

        int eventType = pullParser.getEventType();
        Player currentPlayer = null;

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
                            currentPlayer = new Player();
                            players.add(currentPlayer);
                        } else if (currentPlayer != null){
                            switch (eltName) {
                                case "name":
                                    currentPlayer.setName(pullParser.nextText());
                                    break;
                            }
                        }
                    }
                    break;
            }

            eventType = pullParser.next();
        }
    }

    /* ------------- Getters and Setters ------------- */

    public List<Player> getEquipe() {
        return players;
    }

    public void setEquipe(List<Player> players) {
        this.players = players;
    }
}
