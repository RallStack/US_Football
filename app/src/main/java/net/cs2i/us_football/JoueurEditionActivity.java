package net.cs2i.us_football;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import net.cs2i.us_football.Table.PlayerTable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Locale;

/**
 * Created by thomas on 20/02/2018.
 */

public class JoueurEditionActivity extends Activity implements View.OnClickListener{

    private EditText firstname, lastname, birthday, height, weight, teeNumber, state;
    Spinner post;
    private Button btnAdd;

    private Calendar myCalendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };

    private PlayerTable Player;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueur_edition);

        initializeInput();

        Player = new PlayerTable(this);

        btnAdd=(Button)this.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);

        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(JoueurEditionActivity.this,  date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                submitForm();
                break;
        }
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        birthday.setText(sdf.format(myCalendar.getTime()));
    }

    public void submitForm(){
        Hashtable dataTable = new Hashtable();
        dataTable.put("firstname", firstname.getText().toString());
        dataTable.put("lastname", lastname.getText().toString());
        dataTable.put("birthday", birthday.getText().toString());
        dataTable.put("height", height.getText().toString());
        dataTable.put("weight", weight.getText().toString());
        dataTable.put("post", post.getSelectedItem().toString());
        dataTable.put("teeNumber", teeNumber.getText().toString());
        dataTable.put("state", state.getText().toString());

        Player.addPlayerToXml(JoueurEditionActivity.this, dataTable);

        finish();
    }

    public void initializeInput(){
        firstname = (EditText)this.findViewById(R.id.add_player_firstname);
        lastname = (EditText)this.findViewById(R.id.add_player_lastname);
        birthday = (EditText)this.findViewById(R.id.add_player_birthdate);
        height = (EditText)this.findViewById(R.id.add_player_height);
        weight = (EditText)this.findViewById(R.id.add_player_weight);
        post = (Spinner) findViewById(R.id.add_player_post);
        teeNumber = (EditText)this.findViewById(R.id.add_player_tee);
        state = (EditText)this.findViewById(R.id.add_player_state);
    }
}
