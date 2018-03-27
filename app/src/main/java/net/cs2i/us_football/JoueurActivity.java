package net.cs2i.us_football;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.cs2i.us_football.Entity.ItemPlayer;
import net.cs2i.us_football.Utils.PlayerListAdapter;
import net.cs2i.us_football.Utils.RecyclerItemTouchHelper;
import net.cs2i.us_football.Utils.VolleyApplication;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class JoueurActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<ItemPlayer> cartList;
    private PlayerListAdapter mAdapter;

    // url to fetch menu json
    private static final String URL = "https://api.androidhive.info/json/menu.json";

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

        prepareCart();
    }

    private void prepareCart() {
        JsonArrayRequest request = new JsonArrayRequest(URL,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    if (response == null) {
                        Toast.makeText(getApplicationContext(), "Couldn't fetch the menu! Pleas try again.", Toast.LENGTH_LONG).show();
                        return;
                    }

                    List<ItemPlayer> items = new Gson().fromJson(response.toString(), new TypeToken<List<ItemPlayer>>() {
                    }.getType());

                    // adding items to cart list
                    cartList.clear();
                    cartList.addAll(items);

                    // refreshing recycler view
                    mAdapter.notifyDataSetChanged();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // error in getting json
                    Log.d(TAG, "Error: " + error.getMessage());
                    Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        VolleyApplication.getInstance().addToRequestQueue(request);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof PlayerListAdapter.MyViewHolder) {
            // get the removed item name to display it in snack bar
            String name = cartList.get(viewHolder.getAdapterPosition()).getName();

            // backup of removed item for undo purpose
            final ItemPlayer deletedItem = cartList.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            mAdapter.removeItem(viewHolder.getAdapterPosition());
        }
    }
}












/*import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import net.cs2i.us_football.Entity.Player;
import net.cs2i.us_football.Utils.ListAdapter;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;*/

/**
 * Created by mduchemin on 19/02/18.
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