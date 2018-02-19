package net.cs2i.us_football;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomas on 19/02/2018.
 */

public class EquipeActivity extends Activity {

    ListView teamListView;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipes);

        teamListView = (ListView) findViewById(R.id.team_list_view);

        List<ElementList> elementLists = genererList();

        ListAdapter adapter = new ListAdapter(EquipeActivity.this, elementLists);
        teamListView.setAdapter(adapter);
    }

    private List<ElementList> genererList(){
        List<ElementList> tweets = new ArrayList<>();
        tweets.add(new ElementList(Color.BLACK, "New England Patriots", ""));
        tweets.add(new ElementList(Color.BLUE, "Buffalo Bills", ""));
        tweets.add(new ElementList(Color.GREEN, "Miami Dolphins", ""));
        tweets.add(new ElementList(Color.RED, "N.Y. Jets", ""));
        tweets.add(new ElementList(Color.GRAY, "Pittsburgh Steelers", ""));
        tweets.add(new ElementList(Color.CYAN, "Baltimore Ravens", ""));
        tweets.add(new ElementList(Color.DKGRAY, "Cincinnati Bengals", ""));
        tweets.add(new ElementList(Color.MAGENTA, "Cleveland Browns", ""));
        tweets.add(new ElementList(Color.YELLOW, "Kansas City Chiefs", ""));
        tweets.add(new ElementList(Color.BLACK, "Los Angeles Chargers", ""));
        tweets.add(new ElementList(Color.GRAY, "Oakland Raiders", ""));
        tweets.add(new ElementList(Color.BLUE, "Denver Broncos", ""));
        return tweets;
    }
}
