package com.example.deezer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.deezer.R;
import com.example.deezer.adapters.SongAdapter;
import com.example.deezer.control.SongController;
import com.example.deezer.model.Song;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView songsTable;
    private SongAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView imageListSongs;
    private TextView nameListSong;
    private TextView descriptionSong;
    private TextView numListSongs;
    private SongController songController;
    private ArrayList<Song> songs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        imageListSongs = findViewById(R.id.imageListSongs);
        nameListSong = findViewById(R.id.nameListSongTV);
        descriptionSong = findViewById(R.id.descriptionSongTV);
        numListSongs = findViewById(R.id.numListSongsTV);
        songsTable = (RecyclerView) findViewById(R.id.recyclerViewSongs);
        songsTable.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        songsTable.setLayoutManager(layoutManager);
        adapter = new SongAdapter(this);
        songsTable.setAdapter(adapter);
        songController = new SongController(this);
        adapter.setOnclickListener(songController);


    }

    public RecyclerView getSongsTable() {
        return songsTable;
    }

    public SongAdapter getAdapter() {
        return adapter;
    }

    public ImageView getImageListSongs() {
        return imageListSongs;
    }

    public TextView getNameListSong() {
        return nameListSong;
    }

    public TextView getDescriptionSong() {
        return descriptionSong;
    }

    public TextView getNumListSongs() {
        return numListSongs;
    }
}
