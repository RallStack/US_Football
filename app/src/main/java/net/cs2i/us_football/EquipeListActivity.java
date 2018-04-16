package net.cs2i.us_football;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import net.cs2i.us_football.Entity.Player;
import net.cs2i.us_football.Table.EquipeTable;
import net.cs2i.us_football.Table.PlayerTable;
import net.cs2i.us_football.Utils.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 17/03/2018.
 */

public class EquipeListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<Player> playerList;
    private FloatingActionButton fab;
    private EquipeTable equipeTable;
    private PlayerTable playerTable;

    String tag;

    ListView equipeList;

    net.cs2i.us_football.Entity.Equipe Equipe;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe_list);

        Intent intent = getIntent();

        tag = intent.getStringExtra("tag");

        equipeTable = new EquipeTable(this, tag);
        playerTable = new PlayerTable(this);

        playerList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyle_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        playerList.clear();
        playerList.addAll(equipeTable.getEquipe());

        //setRecyclerViewData(); //adding data to array list
        adapter = new RecyclerAdapter(this, playerList);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(onAddingListener());
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
                playerList.add(new Player(spinner_player.getSelectedItem().toString().trim()));

                adapter = new RecyclerAdapter(EquipeListActivity.this, playerList);
                recyclerView.setAdapter(adapter);

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
        List<String> spinnerPlayerList = new ArrayList<>();

        for ( Player player : playerTable.getPlayers()) {
            spinnerPlayerList.add(player.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerPlayerList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sItems.setAdapter(adapter);
    }

    private View.OnClickListener onAddingListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equipeTable.addEquipeToXml(EquipeListActivity.this, playerList);
                finish();
            }
        };
    }
}
