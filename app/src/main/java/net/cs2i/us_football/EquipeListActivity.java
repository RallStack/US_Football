package net.cs2i.us_football;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import net.cs2i.us_football.Entity.Equipe;
import net.cs2i.us_football.Entity.Player;
import net.cs2i.us_football.Utils.ListAdapter;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 17/03/2018.
 */

public class EquipeListActivity extends Activity implements View.OnClickListener {

    Button ajouterJoueur, validerEquipe;
    ListView equipeList;
    Spinner players;

    net.cs2i.us_football.Entity.Equipe Equipe;
    net.cs2i.us_football.Entity.Player Player;
    List<String> playerList;
    List<ElementList> elementLists;

    String tag;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe_list);

        playerList = new ArrayList<String>();
        elementLists = new ArrayList<>();
        Equipe = new Equipe();
        Player = new Player();

        ajouterJoueur = findViewById(R.id.btn_valider_equipe);
        validerEquipe = findViewById(R.id.btn_valider_equipe);
        equipeList = findViewById(R.id.equipe_list_view);
        players = findViewById(R.id.spinner_player);

        ajouterJoueur=(Button)this.findViewById(R.id.btn_ajouter_joueur);
        ajouterJoueur.setOnClickListener(this);

        validerEquipe=(Button)this.findViewById(R.id.btn_valider_equipe);
        validerEquipe.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        if(b != null)
            this.tag = b.getString("tag");

        Equipe.createEquipeFile(this);

        diplayEquipe();
        showPlayer();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ajouter_joueur:
                addPlayer();
                break;
            case R.id.btn_valider_equipe:
                validateTeam();
                break;
        }
    }

    private void showPlayer(){
        List<Player> players = null;

        try {
            players = Player.getPLayers(this);

            for ( Player player : players) {
                this.playerList.add(player.getName() + " " + player.getSurname());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, playerList);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner sItems = (Spinner) findViewById(R.id.spinner_player);
            sItems.setAdapter(adapter);
        }
        catch (XmlPullParserException e) { }
        catch (IOException e) { }
    }

    private void addPlayer(){
        elementLists.add(new ElementList(players.getSelectedItem().toString(), ""));

        ListAdapter adapter = new ListAdapter(this, elementLists);
        equipeList.setAdapter(adapter);
    }

    private void validateTeam(){
        Equipe.addEquipeToXml(EquipeListActivity.this, elementLists, this.tag);

        finish();
    }

    private void diplayEquipe(){
        List<ElementList> elementLists = null;

        try {
            elementLists = Equipe.generateList(this, this.tag);
            ListAdapter adapter = new ListAdapter(this, elementLists);
            equipeList.setAdapter(adapter);
        }
        catch (XmlPullParserException e) { }
        catch (IOException e) { }
    }
}
