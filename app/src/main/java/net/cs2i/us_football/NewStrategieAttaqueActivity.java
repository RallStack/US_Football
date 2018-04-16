package net.cs2i.us_football;

/**
 * Created by Xydhroz on 20/02/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class NewStrategieAttaqueActivity extends Activity implements View.OnClickListener{


    Button effacer;
    Button ajouter;

    net.cs2i.us_football.Entity.Strategie Strategie;

    String tag;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_strategies);

        ajouter = (Button) findViewById(R.id.btn_add_new_strat);
        ajouter.setOnClickListener(this);
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