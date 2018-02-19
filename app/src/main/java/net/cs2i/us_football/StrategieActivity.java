package net.cs2i.us_football;

/**Created by Xydhroz on 19/02/2018*/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StrategieActivity extends Activity implements View.OnClickListener{

    Button a;
    Button d;
    Button s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategies);

        //Attaque
        a=(Button)this.findViewById(R.id.btn_goto_attaque);
        a.setOnClickListener(this);

        //Defense
        d=(Button)this.findViewById(R.id.btn_goto_defense);
        d.setOnClickListener(this);

        //Spécial
        s=(Button)this.findViewById(R.id.btn_goto_special);
        s.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_goto_attaque:
                Intent ba = new Intent(this, AttaqueActivity.class);
                this.startActivity(ba);
                break;

            /**case R.id.btn_goto_defense:
                Intent be = new Intent(this, EquipeActivity.class);
                this.startActivity(be);
                break;

            case R.id.btn_goto_special:
                Intent bs = new Intent(this, StrategieActivity.class);
                this.startActivity(bs);
                break;*/
        }
    }
}
