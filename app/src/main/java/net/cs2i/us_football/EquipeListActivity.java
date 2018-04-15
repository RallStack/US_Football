package net.cs2i.us_football;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import net.cs2i.us_football.Entity.ElementList;
import net.cs2i.us_football.Entity.Equipe;
import net.cs2i.us_football.Entity.Player;
import net.cs2i.us_football.Table.PlayerTable;
import net.cs2i.us_football.Utils.ListAdapter;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Maxime on 17/03/2018.
 */

public class EquipeListActivity extends AppCompatActivity {

    ListView equipeList;

    net.cs2i.us_football.Entity.Equipe Equipe;

    String tag;

    PlayerTable playerTable;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe_list);

        playerTable = new PlayerTable(this);



        /*
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
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_player:
                final Dialog dialog = new Dialog(EquipeListActivity.this);
                dialog.setContentView(R.layout.dialog_add_player_to_team); //layout for dialog
                dialog.setTitle("Add a player to team");

                Spinner spinner_player = (Spinner) dialog.findViewById(R.id.spinner_player);

                View btnAdd = dialog.findViewById(R.id.btn_ok);
                View btnCancel = dialog.findViewById(R.id.btn_cancel);

                btnAdd.setOnClickListener(onConfirmListener(spinner_player, dialog));
                btnCancel.setOnClickListener(onCancelListener(dialog));

                fillPlayerSpinner(spinner_player);
                dialog.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private View.OnClickListener onConfirmListener(final Spinner spinner_player, final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();
            }
        };
    }

    private View.OnClickListener onCancelListener(final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        };
    }

    private void fillPlayerSpinner(Spinner sItems){
        List<String> playerList = new ArrayList<>();

        for ( Player player : playerTable.getPlayers()) {
            playerList.add(player.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, playerList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sItems.setAdapter(adapter);
    }

    /*
    private void addPlayer(){
        elementLists.add(new ElementList(players.getSelectedItem().toString(), ""));

        ListAdapter adapter = new ListAdapter(this, elementLists);
        equipeList.setAdapter(adapter);
    }
    */

/*
    private void validateTeam(){
        Equipe.addEquipeToXml(EquipeListActivity.this, elementLists, this.tag);

        finish();
    }
*/

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
