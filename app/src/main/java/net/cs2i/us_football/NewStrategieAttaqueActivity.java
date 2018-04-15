package net.cs2i.us_football;

/**
 * Created by Xydhroz on 20/02/2018.
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import net.cs2i.us_football.Entity.Player;
import net.cs2i.us_football.Entity.Strategie;
import net.cs2i.us_football.Table.EquipeTable;
import net.cs2i.us_football.Table.PlayerTable;
import net.cs2i.us_football.Table.StrategieTable;
import net.cs2i.us_football.Utils.RecyclerAdapter;
import net.cs2i.us_football.Utils.VueTerrainStrategie;

import java.util.ArrayList;

public class NewStrategieAttaqueActivity extends Activity implements View.OnClickListener{

//    private ListView playerStratListView;
//
//    private RecyclerView recyclerView;
//    private RecyclerAdapter adapter;
//    private ArrayList<Strategie> strategieList;
//    private FloatingActionButton fab;
//    private StrategieTable StrategieTable;


    Button effacer;
    Button ajouter;
    //ListView strategieList;

    net.cs2i.us_football.Entity.Strategie Strategie;

    String tag;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_strategies);

        ajouter = (Button) findViewById(R.id.btn_add_new_strat);
        ajouter.setOnClickListener(this);


    //    effacer = (Button) findViewById(R.id.btn_clear);
    //    effacer.setOnClickListener(this);




    //    StrategieTable = new StrategieTable(this);
//
    //    strategieList = new ArrayList<>();
//
    //    recyclerView = (RecyclerView) findViewById(R.id.recyle_view);
    //    fab = (FloatingActionButton) findViewById(R.id.fab);
//
    //    recyclerView.setHasFixedSize(true);
//
    //    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    //    recyclerView.setLayoutManager(layoutManager);
//
    //    strategieList.clear();
    //    strategieList.addAll(StrategieTable.getStrategie());
//
    //    //setRecyclerViewData(); //adding data to array list
    ////    adapter = new RecyclerAdapter(this, strategieList);
    //    recyclerView.setAdapter(adapter);
//
    //    fab.setOnClickListener(onAddingListener());
    }

    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_add_new_strat :
                Intent bj = new Intent(this, StrategieActivity.class);
                this.startActivity(bj);
                break;
        }
    }




}
