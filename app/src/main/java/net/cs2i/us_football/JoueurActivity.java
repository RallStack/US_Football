package net.cs2i.us_football;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
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
        Player player = new Player();

        List<ElementList> elementLists = null;

        try {
            elementLists = player.genererList(this);
        } catch (IOException e) {

        } catch (XmlPullParserException e) {

        }

        ListAdapter adapter = new ListAdapter(this, elementLists);
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
}
