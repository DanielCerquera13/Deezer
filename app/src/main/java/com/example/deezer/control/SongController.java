package com.example.deezer.control;

import android.content.Intent;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.deezer.model.Data;
import com.example.deezer.model.Deezer;
import com.example.deezer.model.Song;
import com.example.deezer.util.Constants;
import com.example.deezer.util.HTTPSWebUtilDomi;
import com.example.deezer.view.ListActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

public class SongController  implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener {

    private ListActivity listActivity;
    private HTTPSWebUtilDomi utilDomi;
    private Song song;
    private Data songContainer;
    private Deezer playlist;




    public SongController(ListActivity listActivity){

        this.listActivity = listActivity;
        utilDomi = new HTTPSWebUtilDomi();
        utilDomi.setListener(this);

        songContainer = (Data) listActivity.getIntent().getExtras().get("PlayList");
        playlist = (Deezer) listActivity.getIntent().getExtras().get("Song");




        listActivity.getNameListSong().setText(songContainer.getTitle());
        Glide.with(listActivity).load(songContainer.getPicture_big()).centerCrop().into(listActivity.getImageListSongs());
        listActivity.getDescriptionSong().setText(songContainer.getDescription());
        listActivity.getNumListSongs().setText(""+songContainer.getNb_tracks()+" Canciones");

        System.out.println(playlist.getData()[0].getTitle()+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");


        for(int i =0; i<playlist.getData().length; i++){


            int contador = i;
            new Thread(()->{


                utilDomi.GETrequest(Constants.LIST_CALLBACK, "https://api.deezer.com/track/"+playlist.getData()[contador].getId());

          }).start();

        }


    }


    @Override
    public void onClick(View v) {





    }

    @Override
    public void onResponse(int callbackID, String response) {

        switch(callbackID){

            case Constants.LIST_CALLBACK:

                Gson gson = new Gson();
                Song song = gson.fromJson(response, Song.class);



                listActivity.runOnUiThread(()->{

                    listActivity.getAdapter().addSong(song);
                    listActivity.getAdapter().notifyDataSetChanged();

                });

                break;

        }


    }
}
