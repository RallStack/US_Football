package net.cs2i.us_football;

/**
 * Created by Xydhroz on 19/02/2018.
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

import java.util.ArrayList;
import java.util.List;

public class AttaqueActivity extends Activity implements View.OnClickListener{

    ListView attaqueListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button a;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attaques);

        //Attaque
        //a=(Button)this.findViewById(R.id.btn_add_attaque);
        //a.setOnClickListener(this);

        attaqueListView = (ListView) findViewById(R.id.attaque_list_view);

        //List<ElementList> elementLists = genererList();

        //ListAdapter adapter = new ListAdapter(AttaqueActivity.this, elementLists);
        //attaqueListView.setAdapter(adapter);
    }

    public void onClick(View v) {
        Intent bj = new Intent(this, NewStrategieAttaqueActivity.class);
        this.startActivity(bj);
    }

    //private List<ElementList> genererList(){
        /*List<ElementList> tweets = new ArrayList<>();
        tweets.add(new ElementList(Color.BLACK, "Baguette", "Technique bien française"));
        tweets.add(new ElementList(Color.BLUE, "Flow Bomb", "Flow va loin et vite"));
        tweets.add(new ElementList(Color.GREEN, "Tank Max", "Max prend la balle et cours"));
        tweets.add(new ElementList(Color.RED, "Fourberie de Thomas", "Thomas sort une technique de fourbe"));
        tweets.add(new ElementList(Color.GRAY, "Texas Ranger", "Auto Win"));
        return tweets;*/
        //return null;
    //}
}