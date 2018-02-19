package net.cs2i.us_football;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by mduchemin on 19/02/18.
 */

public class JoueurActivity extends Activity{

    ListView playerListView;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueurs);

        playerListView = (ListView) findViewById(R.id.player_list_view);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(JoueurActivity.this, android.R.layout.simple_list_item_1, prenoms);
        playerListView.setAdapter(adapter);
    }
}
