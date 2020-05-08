package com.example.deezer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezer.R;

public class SongActivity extends AppCompatActivity {

    private ImageView imageSong;
    private TextView nameSongTV;
    private TextView artistNameTV;
    private TextView albumSongTV;
    private TextView timeSongTV;
    private Button listenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        imageSong = findViewById(R.id.imageSongTV);
        nameSongTV = findViewById(R.id.nameSongTV);
        artistNameTV = findViewById(R.id.artistNameTV);
        albumSongTV = findViewById(R.id.albumSongTV);
        timeSongTV = findViewById(R.id.timeSongTV);
        listenBtn = findViewById(R.id.listenBTN);

        if(getIntent().hasExtra("id")){



        }
    }
}
