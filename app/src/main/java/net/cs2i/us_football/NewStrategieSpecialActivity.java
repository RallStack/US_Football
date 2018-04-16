package net.cs2i.us_football;

/**
 * Created by Xydhroz on 20/02/2018.
 */

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

public class NewStrategieSpecialActivity extends Activity{

    private ListView playerStratListView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_strategies);
     }
}
