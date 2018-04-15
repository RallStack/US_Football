package net.cs2i.us_football.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import net.cs2i.us_football.Entity.Player;
import net.cs2i.us_football.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Player> players;
    private Activity activity;

    public RecyclerAdapter(Activity activity, List<Player> players) {
        this.players = players;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        //inflate your layout and pass it to view holder
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.player_list_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, final int position) {

        //setting data to view holder elements
        viewHolder.name.setText(players.get(position).getName());
        viewHolder.post.setText(players.get(position).getPost());

        //set on click listener for each element
        viewHolder.container.setOnClickListener(onClickListener(position));

        viewHolder.del.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Player theRemovedItem = players.get(position);

                players.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    private void setDataToView(TextView name, TextView job, ImageView genderIcon, int position) {
        name.setText(players.get(position).getName());
        job.setText(players.get(position).getPost());
    }

    @Override
    public int getItemCount() {
        return (null != players ? players.size() : 0);
    }

    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.player_list_item);
                dialog.setTitle("Position " + position);
                dialog.setCancelable(true); // dismiss when touching outside Dialog

                // set the custom dialog components - texts and image
                TextView name = (TextView) dialog.findViewById(R.id.name);
                TextView post = (TextView) dialog.findViewById(R.id.post);
                ImageView icon = (ImageView) dialog.findViewById(R.id.image);

                setDataToView(name, post, icon, position);

                dialog.show();
            }
        };
    }

    /**
     * View holder to display each RecylerView item
     */
    protected class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name;
        private TextView post;
        private ImageButton del;
        private View container;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image);
            name = (TextView) view.findViewById(R.id.name);
            post = (TextView) view.findViewById(R.id.post);
            del = (ImageButton) view.findViewById(R.id.list_delete);
            container = view.findViewById(R.id.card_view);
        }
    }
}