package net.cs2i.us_football;

/**
 * Created by Xydhroz on 20/02/2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class DefenseActivity extends Activity implements View.OnClickListener{

    ListView defenseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button d;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defenses);

        //Defense
        d=(Button)this.findViewById(R.id.btn_add_defense);
        d.setOnClickListener(this);

        defenseListView = (ListView) findViewById(R.id.defense_list_view);

     //   List<ElementList> elementLists = genererList();

       // ListAdapter adapter = new ListAdapter(DefenseActivity.this, elementLists);
        //defenseListView.setAdapter(adapter);
    }

    public void onClick(View v) {
        Intent bd = new Intent(this, NewStrategieDefenseActivity.class);
        this.startActivity(bd);
    }

    //private List<ElementList> genererList(){
    //    List<ElementList> tweets = new ArrayList<>();
    //    tweets.add(new ElementList(Color.BLACK, "Mur", "Explicite"));
    //    tweets.add(new ElementList(Color.BLUE, "Dome", "Aussi explicite"));
    //    tweets.add(new ElementList(Color.GREEN, "Tank Max", "Max prend la balle et cours"));
    //    tweets.add(new ElementList(Color.GRAY, "Texas Ranger", "Auto Win"));
     //   return tweets;
    //}
}
