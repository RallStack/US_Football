package net.cs2i.us_football;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mduchemin on 19/02/18.
 */

public class JoueurActivity extends Activity implements View.OnClickListener{

    Button j;
    private ListView playerListView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueurs);

        //Joueur
        j=(Button)this.findViewById(R.id.btn_ajouter_joueur);
        j.setOnClickListener(this);

        playerListView = (ListView) findViewById(R.id.player_list_view);

        List<ElementList> elementLists = genererList();

        ListAdapter adapter = new ListAdapter(JoueurActivity.this, elementLists);
        playerListView.setAdapter(adapter);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ajouter_joueur:
                Intent bj = new Intent(this, JoueurEditionActivity.class);
                this.startActivity(bj);
                break;
        }
    }




    private List<ElementList> genererList(){
        List<ElementList> tweets = new ArrayList<>();
        tweets.add(new ElementList(Color.BLACK, "Florent", "Mon premier tweet !"));
        tweets.add(new ElementList(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        tweets.add(new ElementList(Color.GREEN, "Logan", "Que c'est beau..."));
        tweets.add(new ElementList(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tweets.add(new ElementList(Color.GRAY, "Willy", "On y est presque"));
        tweets.add(new ElementList(Color.GREEN, "Logan", "Que c'est beau..."));
        tweets.add(new ElementList(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tweets.add(new ElementList(Color.GRAY, "Willy", "On y est presque"));
        return tweets;
    }
}
