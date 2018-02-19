package net.cs2i.us_football;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mduchemin on 19/02/18.
 */

public class JoueurActivity extends Activity{

    private ListView playerListView;
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

        List<ElementList> elementLists = genererList();

        ListAdapter adapter = new ListAdapter(JoueurActivity.this, elementLists);
        playerListView.setAdapter(adapter);
    }

    private List<ElementList> genererList(){
        List<ElementList> tweets = new ArrayList<>();
        tweets.add(new ElementList(Color.BLACK, "Florent", "Mon premier tweet !"));
        tweets.add(new ElementList(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        tweets.add(new ElementList(Color.GREEN, "Logan", "Que c'est beau..."));
        tweets.add(new ElementList(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tweets.add(new ElementList(Color.GRAY, "Willy", "On y est presque"));
        return tweets;
    }
}
