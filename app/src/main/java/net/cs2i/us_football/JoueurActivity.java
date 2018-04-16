package net.cs2i.us_football;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import net.cs2i.us_football.Entity.Player;
import net.cs2i.us_football.Table.PlayerTable;
import net.cs2i.us_football.Utils.RecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Locale;

public class JoueurActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<Player> playerList;
    private FloatingActionButton fab;
    private PlayerTable PlayerTable;

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

    private EditText name, birthday, tee_num, height, weight;
    private Spinner post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueurs);

        PlayerTable = new PlayerTable(this);

        playerList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyle_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        playerList.clear();
        playerList.addAll(PlayerTable.getPlayers());

        //setRecyclerViewData(); //adding data to array list
        adapter = new RecyclerAdapter(this, playerList);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(onAddingListener());
    }

    private View.OnClickListener onAddingListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(JoueurActivity.this);
                dialog.setContentView(R.layout.dialog_add_player); //layout for dialog
                dialog.setTitle("Add a new player");
                dialog.setCancelable(false); //none-dismiss when touching outside Dialog

                // set the custom dialog components - texts and image
                name = (EditText) dialog.findViewById(R.id.name);
                birthday = (EditText) dialog.findViewById(R.id.birthday);
                post = (Spinner) dialog.findViewById(R.id.post);
                tee_num = (EditText) dialog.findViewById(R.id.tee_num);
                height = (EditText) dialog.findViewById(R.id.height);
                weight = (EditText) dialog.findViewById(R.id.weight);

                View btnAdd = dialog.findViewById(R.id.btn_ok);
                View btnCancel = dialog.findViewById(R.id.btn_cancel);

                btnAdd.setOnClickListener(onConfirmListener(name, birthday, post, tee_num, height, weight, dialog));
                btnCancel.setOnClickListener(onCancelListener(dialog));

                birthday.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new DatePickerDialog(JoueurActivity.this,  date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                    }
                });

                dialog.show();
            }
        };
    }

    private View.OnClickListener onConfirmListener(final EditText name, final EditText birthday, final Spinner post, final EditText teeNumber, final EditText height, final EditText weight, final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = new Player(name.getText().toString().trim(), teeNumber.getText().toString().trim(), post.getSelectedItem().toString().trim());

                //adding new object to arraylist
                playerList.add(player);

                Hashtable dataTable = new Hashtable();
                dataTable.put("name", name.getText().toString());
                dataTable.put("birthday", birthday.getText().toString());
                dataTable.put("post", post.getSelectedItem().toString());
                dataTable.put("teeNumber", teeNumber.getText().toString());
                dataTable.put("height", height.getText().toString());
                dataTable.put("weight", weight.getText().toString());

                PlayerTable.addPlayerToXml(JoueurActivity.this, dataTable);

                //notify data set changed in RecyclerView adapter
                adapter.notifyDataSetChanged();

                //close dialog after all
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

    @Override
    public void onBackPressed() {
        PlayerTable.updatePlayerList(this, playerList);
        finish();
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        birthday.setText(sdf.format(myCalendar.getTime()));
    }
}