package net.cs2i.us_football;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import net.cs2i.us_football.Entity.Player;
import net.cs2i.us_football.Utils.RecyclerAdapter;

import java.util.ArrayList;

public class JoueurActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<Player> playerList;
    private FloatingActionButton fab;
    private boolean gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueurs);
        playerList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyle_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setRecyclerViewData(); //adding data to array list
        adapter = new RecyclerAdapter(this, playerList);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(onAddingListener());
    }

    private void setRecyclerViewData() {
        playerList.add(new Player("Phan Thanh", "01", "QB"));
        playerList.add(new Player("Nguyen Tuan", "01", "QB"));
        playerList.add(new Player("Tran Van Minh", "01", "QB"));
        playerList.add(new Player("Pham Mai Anh", "01", "QB"));
        playerList.add(new Player("Nguyen Quynh Trang", "01", "QB"));
        playerList.add(new Player("Hoang Dinh Cuong", "01", "QB"));
        playerList.add(new Player("Tran Cong Bach", "01", "QB"));
        playerList.add(new Player("Vu Van Duong", "01", "QB"));
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
                EditText name = (EditText) dialog.findViewById(R.id.name);
                Spinner post = (Spinner) dialog.findViewById(R.id.post);
                EditText tee_num = (EditText) dialog.findViewById(R.id.tee_num);
                View btnAdd = dialog.findViewById(R.id.btn_ok);
                View btnCancel = dialog.findViewById(R.id.btn_cancel);

                //set spinner adapter

                btnAdd.setOnClickListener(onConfirmListener(name, tee_num, post, dialog));
                btnCancel.setOnClickListener(onCancelListener(dialog));

                dialog.show();
            }
        };
    }

    private AdapterView.OnItemSelectedListener onItemSelectedListener() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                if (position == 0) {
                    gender = true;
                } else {
                    gender = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView parent) {

            }
        };
    }

    private View.OnClickListener onConfirmListener(final EditText name, final EditText teeNumber, final Spinner post, final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = new Player(name.getText().toString().trim(), teeNumber.getText().toString().trim(), post.getSelectedItem().toString().trim());

                //adding new object to arraylist
                playerList.add(player);

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
}


/*
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import net.cs2i.us_football.Entity.Player;
import net.cs2i.us_football.Table.PlayerTable;
import net.cs2i.us_football.Utils.PlayerListAdapter;
import net.cs2i.us_football.Utils.RecyclerItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class JoueurActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<Player> cartList;
    private PlayerListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueurs);

        recyclerView = findViewById(R.id.recycler_view);

        cartList = new ArrayList<>();
        mAdapter = new PlayerListAdapter(this, cartList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

        PlayerTable Player = new PlayerTable(this);

        cartList.clear();
        cartList.addAll(Player.getPlayers());

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof PlayerListAdapter.MyViewHolder) {
            // get the removed item name to display it in snack bar
            String name = cartList.get(viewHolder.getAdapterPosition()).getFirstName();

            // backup of removed item for undo purpose
            final Player deletedItem = cartList.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            mAdapter.removeItem(viewHolder.getAdapterPosition());
        }
    }
}
*/

/*public class JoueurActivity extends Activity implements View.OnClickListener{

    Button j;
    private ListView playerListView;
    private Player player;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueurs);

        j=(Button)this.findViewById(R.id.btn_ajouter_joueur);
        j.setOnClickListener(this);

        //playerListView = (ListView) findViewById(R.id.player_list_view);
        player = new Player();

        player.createPlayerFile(this);

        diplayPlayer();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ajouter_joueur:
                Intent bj = new Intent(this, JoueurEditionActivity.class);
                this.startActivity(bj);
                break;
        }
    }

    private void diplayPlayer(){
        List<ElementList> elementLists = null;

        try {
            elementLists = player.generateList(this);
            ListAdapter adapter = new ListAdapter(this, elementLists);
            playerListView.setAdapter(adapter);
        }
        catch (XmlPullParserException e) { }
        catch (IOException e) { }
    }
}*/