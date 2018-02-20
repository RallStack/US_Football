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

public class SpecialActivity extends Activity {

    ListView specialListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specials);

        specialListView = (ListView) findViewById(R.id.special_list_view);

        List<ElementList> elementLists = genererList();

        ListAdapter adapter = new ListAdapter(SpecialActivity.this, elementLists);
        specialListView.setAdapter(adapter);
    }

    private List<ElementList> genererList(){
        List<ElementList> tweets = new ArrayList<>();
        tweets.add(new ElementList(Color.BLACK, "Magnum", "60 Yards minimum"));
        tweets.add(new ElementList(Color.BLUE, "Flow Bomb", "Flow va loin et vite"));
        tweets.add(new ElementList(Color.GREEN, "Tank Max", "Max prend la balle et cours"));
        tweets.add(new ElementList(Color.RED, "Fourberie de Thomas", "Thomas sort une technique de fourbe"));
        tweets.add(new ElementList(Color.GRAY, "Texas Ranger", "Auto Win"));
        return tweets;
    }
}
