package tomerbu.edu.songdbhelper.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import tomerbu.edu.songdbhelper.R;
import tomerbu.edu.songdbhelper.db.SongDAO;
import tomerbu.edu.songdbhelper.models.Song;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>{

    private final LayoutInflater inflater;
    private ArrayList<Song> songs;
    private Context context;

    public SongAdapter(Context context) {
        this.context = context;
        SongDAO dao = new SongDAO(context);
        songs = dao.query();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.song_item, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        Song s = songs.get(position);

        holder.tvTitle.setText(s.getTitle());
        holder.tvArtist.setText(s.getArtist());
        holder.tvDuration.setText(s.getDuration());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvDuration;
        TextView tvArtist;
        ImageView ivArt;
        RelativeLayout layout;


        public SongViewHolder(View v) {
            super(v);

            tvArtist = (TextView) v.findViewById(R.id.tvArtist);
            tvTitle = (TextView) v.findViewById(R.id.tvSongTitle);
            tvDuration = (TextView) v.findViewById(R.id.tvDuration);

            ivArt = (ImageView) v.findViewById(R.id.imageView);
            layout = (RelativeLayout) v.findViewById(R.id.layout);
        }
    }
}
