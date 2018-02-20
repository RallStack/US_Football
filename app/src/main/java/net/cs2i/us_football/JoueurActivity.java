package net.cs2i.us_football;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

/**
 * Created by mduchemin on 19/02/18.
 */

public class JoueurActivity extends Activity{

    private ListView playerListView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueurs);

        playerListView = (ListView) findViewById(R.id.player_list_view);
        Players player = new Players();

        List<ElementList> elementLists = null;

        try {
            elementLists = player.genererList(this);
        } catch (IOException e) {

        } catch (XmlPullParserException e) {

        }

        ListAdapter adapter = new ListAdapter(this, elementLists);
        playerListView.setAdapter(adapter);

        //player.CreateXml(this, "test.xml");
    }
}
