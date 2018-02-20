package net.cs2i.us_football;

/**
 * Created by Xydhroz on 20/02/2018.
 */

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewStrategieSpecialActivity extends Activity{

    private ListView playerStratListView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_strategies);

        playerStratListView = (ListView) findViewById(R.id.player_strat_list_view);

        List<ElementList> elementLists = null;
        try {
            elementLists = genererList();
        } catch (IOException e) {

        } catch (XmlPullParserException e) {

        }

        ListAdapter adapter = new ListAdapter(NewStrategieSpecialActivity.this, elementLists);
        playerStratListView.setAdapter(adapter);
    }

    private List<ElementList> genererList() throws IOException, XmlPullParserException {
        Parser parser = new Parser();

        ArrayList<Players> players = parser.processParsingPlayer(parser.parseXML(this, "players.xml"));

        List<ElementList> elementLists = new ArrayList<>();

        for (Players player : players){
            elementLists.add(new ElementList(Color.BLACK, player.surname + " " + player.name, player.post));
        }

//        elementLists.add(new ElementList(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
//        elementLists.add(new ElementList(Color.GREEN, "Logan", "Que c'est beau..."));
//        elementLists.add(new ElementList(Color.RED, "Mathieu", "Il est quelle heure ??"));
//        elementLists.add(new ElementList(Color.GRAY, "Willy", "On y est presque"));
//        elementLists.add(new ElementList(Color.GREEN, "Logan", "Que c'est beau..."));
//        elementLists.add(new ElementList(Color.RED, "Mathieu", "Il est quelle heure ??"));
//        elementLists.add(new ElementList(Color.GRAY, "Willy", "On y est presque"));

        return elementLists;
    }
}
