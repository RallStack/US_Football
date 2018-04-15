package net.cs2i.us_football;

/**
 * Created by Xydhroz on 20/02/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class NewStrategieSpecialActivity extends Activity implements View.OnClickListener{

    private ListView playerStratListView;
    Button ajouter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_strategies);

        ajouter = (Button) findViewById(R.id.btn_add_new_strat);
        ajouter.setOnClickListener(this);

    //    playerStratListView = (ListView) findViewById(R.id.player_strat_list_view);
        }


    public void onClick(View v) {
        switch (v.getId()){
            //case R.id.btn_clear :
            //    VueTerrainStrategie.clear();
            //    break;


            case R.id.btn_add_new_strat :
                Intent bj = new Intent(this, StrategieActivity.class);
                this.startActivity(bj);
                break;
        }
    }
}
