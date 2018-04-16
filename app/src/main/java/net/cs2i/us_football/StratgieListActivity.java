package net.cs2i.us_football;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.cs2i.us_football.Entity.Strategie;
import net.cs2i.us_football.Table.StrategieTable;
import net.cs2i.us_football.Utils.RecyclerAdapterStrat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mduchemin on 16/04/18.
 */

public class StratgieListActivity extends AppCompatActivity {

    StrategieTable strategieTable;
    List<Strategie> strategieList;
    private RecyclerView recyclerView;
    private RecyclerAdapterStrat adapter;
    private FloatingActionButton fab;

    String tag;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategie_list);

        Intent intent = getIntent();

        tag = intent.getStringExtra("tag");

        strategieTable = new StrategieTable(this, tag);

        strategieList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyle_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        strategieList.clear();
        strategieList.addAll(strategieTable.getStrategie());

        //setRecyclerViewData(); //adding data to array list
        adapter = new RecyclerAdapterStrat(this, strategieList);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(onAddingListener());
    }

    private View.OnClickListener onAddingListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tag = StratgieListActivity.this.tag;

                if (tag.equals("attaque")){
                    Intent bj = new Intent(StratgieListActivity.this, NewStrategieAttaqueActivity.class);
                    StratgieListActivity.this.startActivity(bj);
                } else if (tag.equals("defense")){
                    Intent bj = new Intent(StratgieListActivity.this, NewStrategieDefenseActivity.class);
                    StratgieListActivity.this.startActivity(bj);
                } else if (tag.equals("special")){
                    Intent bj = new Intent(StratgieListActivity.this, NewStrategieSpecialActivity.class);
                    StratgieListActivity.this.startActivity(bj);
                }
            }
        };
    }
}
