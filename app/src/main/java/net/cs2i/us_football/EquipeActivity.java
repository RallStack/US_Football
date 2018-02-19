package net.cs2i.us_football;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by thomas on 19/02/2018.
 */

public class EquipeActivity extends Activity {

    ListView teamListView;
    private String[] nomEquipe = new String[]{
            "New England Patrot", "Buffalo Bills", "Miami Dolphins", "N.Y. Jets",
            "Pittsburgh Steelers", "Baltimore Ravens", "Cincinnati Bengals", "Cleveland Browns",
            "Kansas City Chiefs", "Los Angeles Chargers", "Oakland Raiders", "Denver Broncos",
            "Jacksonville Jaguars", "Tennessee Titans", "Indianapolis Colts", "Houston Texans"
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipes);

        teamListView = (ListView) findViewById(R.id.team_list_view);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(EquipeActivity.this, android.R.layout.simple_list_item_1, nomEquipe);
        teamListView.setAdapter(adapter);
    }
}
