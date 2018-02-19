package net.cs2i.us_football;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mduchemin on 19/02/18.
 */

public class ListAdapter extends ArrayAdapter<ElementList> {

    //tweets est la liste des models à afficher
    public ListAdapter(Context context, List<ElementList> elementLists) {
        super(context, 0, elementLists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_list,parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.main_text = (TextView) convertView.findViewById(R.id.main_text);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.picture = (ImageView) convertView.findViewById(R.id.picture);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        ElementList elementList = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.main_text.setText(elementList.getMainText());
        viewHolder.text.setText(elementList.getText());
        viewHolder.picture.setImageDrawable(new ColorDrawable(elementList.getColor()));

        return convertView;
    }

    private class TweetViewHolder{
        public TextView main_text;
        public TextView text;
        public ImageView picture;
    }
}
