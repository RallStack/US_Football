package net.cs2i.us_football;

/**
 * Created by Xydhroz on 20/02/2018.
 */

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewStrategieAttaqueActivity extends Activity{

    private ListView playerStratListView;
    private Player player;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_strategies);

        playerStratListView = (ListView) findViewById(R.id.player_strat_list_view);
        player = new Player();

        player.createPlayerFile(this);

        diplayPlayer();
    }

    private void diplayPlayer(){
        List<ElementList> elementLists = null;

        try {
            elementLists = player.generateList(this);
            ListAdapter adapter = new ListAdapter(this, elementLists);
            playerStratListView.setAdapter(adapter);
        }
        catch (XmlPullParserException e) { }
        catch (IOException e) { }
    }
}
