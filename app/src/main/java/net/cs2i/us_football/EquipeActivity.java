package net.cs2i.us_football;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by thomas on 19/02/2018.
 */

public class EquipeActivity extends Activity implements View.OnClickListener {

    CardView a, d, s;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipes);
        //Attaque
        a=(CardView)this.findViewById(R.id.btn_goto_attaque);
        a.setOnClickListener(this);

        //Defense
        d=(CardView)this.findViewById(R.id.btn_goto_defense);
        d.setOnClickListener(this);

        //Spécial
        s=(CardView)this.findViewById(R.id.btn_goto_special);
        s.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_goto_attaque:
                Intent ba = new Intent(this, EquipeListActivity.class);
                this.startActivity(ba);
                break;

            case R.id.btn_goto_defense:
                Intent bd = new Intent(this, EquipeListActivity.class);
                this.startActivity(bd);
                break;

            case R.id.btn_goto_special:
                Intent bsp = new Intent(this, EquipeListActivity.class);
                this.startActivity(bsp);
                break;
        }
    }
}
