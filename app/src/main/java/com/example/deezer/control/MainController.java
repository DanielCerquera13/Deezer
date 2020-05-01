package com.example.deezer.control;

import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;

import com.example.deezer.R;
import com.example.deezer.model.Deezer;
import com.example.deezer.util.Constants;
import com.example.deezer.util.HTTPSWebUtilDomi;
import com.example.deezer.view.MainActivity;
import com.google.gson.Gson;

public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener{

    private MainActivity activity;
    private HTTPSWebUtilDomi utilDomi;

    public MainController(MainActivity activity){
        this.activity = activity;
        this.activity.getBuscarListaBT().setOnClickListener(this);
        utilDomi = new HTTPSWebUtilDomi();
        utilDomi.setListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.buscarListaBT:
                String nombre = activity.getBuscarListaET().getText().toString();

                new Thread(
                        ()->{
                            utilDomi.GETrequest(Constants.SEARCH_CALLBACK , "https://api.deezer.com/search/playlist?q="+nombre);
                        }
                ).start();


                break;

        }
    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID){
            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();
                Deezer deezer = gson.fromJson(response, Deezer.class);
                activity.runOnUiThread(
                        ()->{


                            activity.getNombreLista1TV().setText(deezer.getData()[0].getTitle());
                            //activity.getNombreLista2TV().setText(deezer.getData()[1].getTitle());
                            //activity.getNombreLista3TV().setText(deezer.getData()[2].getTitle());
                            //activity.getNombreLista4TV().setText(deezer.getData()[3].getTitle());

                        }

                );
                break;
        }
    }
}
