package com.example.deezer.control;

import android.content.Intent;
import android.view.View;

import com.example.deezer.R;
import com.example.deezer.model.Data;
import com.example.deezer.model.Deezer;
import com.example.deezer.util.Constants;
import com.example.deezer.util.HTTPSWebUtilDomi;
import com.example.deezer.view.ListActivity;
import com.example.deezer.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener {

    private MainActivity activity;
    private HTTPSWebUtilDomi utilDomi;
    private Data playListSeleccionado;



    public MainController(MainActivity activity) {
        this.activity = activity;
        activity.getBuscarListaBT().setOnClickListener(this);
        utilDomi = new HTTPSWebUtilDomi();
        utilDomi.setListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buscarListaBT:
                String nombre = activity.getBuscarListaET().getText().toString();


                new Thread(()->{

                    utilDomi.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/search/playlist?q="+nombre);


                }).start();

                break;



                default:

                    new Thread(()->{

                        utilDomi.GETrequest(Constants.SONG_CALLBACK, "https://api.deezer.com/playlist/"+activity.getAdapter().getDatosLista().get(activity.getRecyclerView().getChildAdapterPosition(v)).getId());
                        utilDomi.GETrequest(Constants.LIST_CALLBACK, activity.getAdapter().getDatosLista().get(activity.getRecyclerView().getChildAdapterPosition(v)).getTracklist());

                    }).start();






                    break;








        }

    }

    @Override
    public void onResponse(int callbackID, String response) {

        switch(callbackID){

            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();
                Deezer deezer = gson.fromJson(response, Deezer.class);

                ArrayList<Data> listaDatos = new ArrayList<>();
                Collections.addAll(listaDatos, deezer.getData());

                activity.runOnUiThread(()->{

                    activity.getAdapter().setDatosLista(listaDatos);
                    activity.getAdapter().notifyDataSetChanged();

                });

                break;


             case Constants.SONG_CALLBACK:
                    Gson segundoGson = new Gson();
                    playListSeleccionado = segundoGson.fromJson(response,Data.class);


                    break;




             case Constants.LIST_CALLBACK:
                 Gson tercerGson = new Gson();
                 Deezer otroDeezer = tercerGson.fromJson(response, Deezer.class);


                 Intent i = new Intent(activity, ListActivity.class);
                 i.putExtra("PlayList", playListSeleccionado);
                 i.putExtra("Song", otroDeezer );
                 activity.startActivity(i);

                 break;











        }



    }
}
