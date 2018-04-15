package net.cs2i.us_football;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView j, e, s, c, t, q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        //Joueur
        j=(CardView)this.findViewById(R.id.btn_goto_joueur);
        j.setOnClickListener(this);

        //Equipe
        e=(CardView)this.findViewById(R.id.btn_goto_equipe);
        e.setOnClickListener(this);

        //Strategie
        s=(CardView)this.findViewById(R.id.btn_goto_strategie);
        s.setOnClickListener(this);

        //Celebration
        c=(CardView)this.findViewById(R.id.btn_goto_celebration);
        c.setOnClickListener(this);

        //Joueur
        t=(CardView)this.findViewById(R.id.btn_goto_tournoi);
        t.setOnClickListener(this);

        q=(CardView)this.findViewById(R.id.btn_quit);
        q.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_goto_joueur :
                Intent bj = new Intent(this, JoueurActivity.class);
                this.startActivity(bj);
                break;

            case R.id.btn_goto_equipe :
                Intent be = new Intent(this, EquipeActivity.class);
                this.startActivity(be);
                break;

            case  R.id.btn_goto_strategie :
                Intent bs = new Intent(this, StrategieActivity.class);
                this.startActivity(bs);
                break;

            /*case R.id.btn_goto_tournoi :
                Intent bt = new Intent(this, TournoiActivity.class);
                this.startActivity(bt);
                break;*/

            case R.id.btn_quit :
                finish();
                break;
        }
    }
}
