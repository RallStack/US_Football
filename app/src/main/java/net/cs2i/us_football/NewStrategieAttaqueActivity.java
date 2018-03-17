package net.cs2i.us_football;

/**
 * Created by Xydhroz on 20/02/2018.
 */

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
//import com.skholingua.android.dragndrop_relativelayout.R;


import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewStrategieAttaqueActivity extends Activity{

    private ListView playerStratListView;

// nouveau
    private ImageView img;
    private ViewGroup rootLayout;
    private int _xDelta;
    private int _yDelta;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_strategies);

        playerStratListView = (ListView) findViewById(R.id.player_strat_list_view);

        List<ElementList> elementLists = null;
        try {
            elementLists = genererList();
        } catch (IOException e) {

        } catch (XmlPullParserException e) {

        }

        ListAdapter adapter = new ListAdapter(NewStrategieAttaqueActivity.this, elementLists);
        playerStratListView.setAdapter(adapter);

// nouveau
        rootLayout = (ViewGroup) findViewById(R.id.view_root);
        img = (ImageView) rootLayout.findViewById(R.id.imageView);

//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150,150);
//        img.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams = img.getLayoutParams();
//        layoutParams.height = 150;
//        layoutParams.width = 150;
        img.setLayoutParams(layoutParams);
        img.setOnTouchListener(new NewStrategieAttaqueActivity.ChoiceTouchListener());
    }

    private List<ElementList> genererList() throws IOException, XmlPullParserException {
        XmlHandler parser = new XmlHandler();


        //ArrayList<Player> players = parser.processParsingPlayer(parser.parseXML(this, "players.xml"));

        List<ElementList> elementLists = new ArrayList<>();

       // for (Player player : players){
        //    elementLists.add(new ElementList(Color.BLACK, player.surname + " " + player.name, player.post));
        //}

//        elementLists.add(new ElementList(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
//        elementLists.add(new ElementList(Color.GREEN, "Logan", "Que c'est beau..."));
//        elementLists.add(new ElementList(Color.RED, "Mathieu", "Il est quelle heure ??"));
//        elementLists.add(new ElementList(Color.GRAY, "Willy", "On y est presque"));
//        elementLists.add(new ElementList(Color.GREEN, "Logan", "Que c'est beau..."));
//        elementLists.add(new ElementList(Color.RED, "Mathieu", "Il est quelle heure ??"));
//        elementLists.add(new ElementList(Color.GRAY, "Willy", "On y est presque"));

        return elementLists;
    }


    private final class ChoiceTouchListener implements OnTouchListener {
        public boolean onTouch(View view, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    _xDelta = X - lParams.leftMargin;
                    _yDelta = Y - lParams.topMargin;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
//                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
//                    layoutParams.leftMargin = X - _xDelta;
//                    layoutParams.topMargin = Y - _yDelta;
//                    layoutParams.rightMargin = -250;
//                    layoutParams.bottomMargin = -250;
//                    view.setLayoutParams(layoutParams);
                    break;
            }
            rootLayout.invalidate();
            return true;
        }
    }

    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

}
