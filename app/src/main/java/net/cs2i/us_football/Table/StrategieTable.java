package net.cs2i.us_football.Table;

import android.content.Context;

import net.cs2i.us_football.Entity.Player;
import net.cs2i.us_football.Entity.Strategie;
import net.cs2i.us_football.Utils.XmlHandler;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas on 15/04/2018.
 */

public class StrategieTable {

    private List<Strategie> strategies;
    private XmlHandler xmlHandler;
    private String tag;

    private static final String filename = "strategie.xml";

    /* ------------- Constructor ------------- */

    public StrategieTable(Context context, String tag){
        this.tag = tag;

        xmlHandler = new XmlHandler();
        strategies = new ArrayList<Strategie>();

        ArrayList<String> options = new ArrayList<String>();
        options.add("strategie-attaque");
        options.add("strategie-defense");
        options.add("strategie-special");

        xmlHandler.CreateXmlFile(context, filename, options);

        try {
            getAllStrategie(context);
        } catch (IOException e) { e.printStackTrace(); } catch (XmlPullParserException e) { e.printStackTrace(); }
    }

    /* ------------- Public function ------------- */

    public void addStrategieToXml(Context context, List<Strategie> newListStrategies){
        String data =
                "<strategie-offensive>";

        for (Strategie strategie : newListStrategies) {
            data +=
                    "<strategie>" +
                        "<name>"+ strategie.getName() +"</name>" +
                        "<image>"+ strategie.getName() +"</image>" +
                    "</strategie>";
        }

        data += "<strategie-offensive>";

        xmlHandler.writeXML(context, data, filename, "strategie-offensive");

    }

    /* ------------- Private function ------------- */

    private void getAllStrategie(Context context) throws IOException, XmlPullParserException {
        XmlPullParser pullParser = xmlHandler.readXML(context, filename);

        int eventType = pullParser.getEventType();
        Strategie currentStrategie = null;

        boolean getStrategie = false;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String eltName = null;

            switch(eventType){
                case XmlPullParser.START_TAG:
                    eltName = pullParser.getName();

                    if (eltName.matches("strategie-.*")){
                        if (("strategie-offensive").equals(eltName)){
                            getStrategie = true;
                        } else{
                            getStrategie = false;
                        }
                    }

                    if (getStrategie){
                        if ("strategie".equals(eltName)){
                            currentStrategie = new Strategie();
                            strategies.add(currentStrategie);
                        } else if (currentStrategie != null){
                            switch (eltName) {
                                case "name":
                                    currentStrategie.setName(pullParser.nextText());
                                    break;
                                case "image":
                                    currentStrategie.setImage(pullParser.nextText());
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

    public List<Strategie> getStrategie() {
        return strategies;
    }

    public void setStrategies(List<Strategie> strategies) {
        this.strategies = strategies;
    }
}
