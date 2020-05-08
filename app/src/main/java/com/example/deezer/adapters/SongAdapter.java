package com.example.deezer.adapters;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.deezer.R;
import com.example.deezer.model.Song;
import com.example.deezer.view.ListActivity;
import com.example.deezer.view.SongActivity;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<Song> songs;
    private ListActivity listActivity;
    private View.OnClickListener listener;
    private TextView nameListSong;
    private TextView artistListSong;
    private TextView releaseSong;

    public SongAdapter(ListActivity listActivity){

        this.listActivity = listActivity;
        songs = new ArrayList<>();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public View view;
        public ViewHolder(View v){
            super(v);
            view = v;
        }

    }



    @NonNull
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_song__row, parent, false);
        view.setOnClickListener(this);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {

        nameListSong = holder.view.findViewById(R.id.nameSongTV);
        artistListSong = holder.view.findViewById(R.id.artistSongTV);
        releaseSong = holder.view.findViewById(R.id.releaseSongTV);

        Glide.with(holder.view.getContext()).load(songs.get(position).getAlbum().getCover_big()).centerCrop().into((ImageView)holder.view.findViewById(R.id.imageSong));

        nameListSong.setText(songs.get(position).getTitle());
        artistListSong.setText(songs.get(position).getArtist().getName());
        releaseSong.setText("Fecha de publicación: " +songs.get(position).getRelease_date());


    }

    @Override
    public int getItemCount() {
        return songs.size();
    }



    @Override
    public void onClick(View v) {

        if(listener!=null){

            listener.onClick(v);

        }

    }

    public SongAdapter(ArrayList<Song> song){
        songs = song;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
        notifyDataSetChanged();
    }

    public void setOnclickListener(View.OnClickListener listener){

        this.listener = listener;

    }

    public void addSong(Song song){
        songs.add(song);


    }




}
