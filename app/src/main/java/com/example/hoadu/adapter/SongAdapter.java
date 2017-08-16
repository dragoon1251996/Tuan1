package com.example.hoadu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoadu.enity.Song;
import com.example.hoadu.interfaceadapter.SongInterFace;
import com.example.hoadu.tuan1.R;

import java.util.List;

/**
 * Created by hoadu on 19/04/2017.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>{
    private List<Song> list;
    private Context context;
    private LayoutInflater inflater;
    private SongInterFace songInterFace;

    public SongAdapter(Context context, List<Song> list,SongInterFace songInterFace) {
        this.context = context;
        this.list = list;
        this.songInterFace=songInterFace;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //set view
        View view=inflater.inflate(R.layout.item_song,parent,false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        //set data
        Song song=list.get(position);
        holder.tvCode.setText(song.getmCode());
        holder.tvArtist.setText(song.getmArtist());
        holder.tvLyric.setText(song.getmLyric());
        holder.tvTitle.setText(song.getmTitle());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCode;
        private TextView tvTitle;
        private TextView tvLyric;
        private TextView tvArtist;

        public SongViewHolder(View itemView) {
            super(itemView);
            //anh xa

            tvCode = (TextView) itemView.findViewById(R.id.tv_code);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvLyric = (TextView) itemView.findViewById(R.id.tv_lyric);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Song song = list.get(getAdapterPosition());
                    songInterFace.tenBai(song.getmTitle());
                }
            });
        }
    }
}

