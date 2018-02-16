package net.cs2i.us_football;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

        Button b;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            b=(Button)this.findViewById(R.id.btn_goto_joueur);
            b.setOnClickListener(this);
        }

        public void onClick(View v) {
            Intent i = new Intent(this, JoueurActivity.class);
            this.startActivity(i);
        }
    }
