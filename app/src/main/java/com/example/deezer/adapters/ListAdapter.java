package com.example.deezer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.deezer.R;
import com.example.deezer.model.Data;
import com.example.deezer.view.MainActivity;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements View.OnClickListener {

    private MainActivity activity;
    private ArrayList<Data> datosLista;
    private View.OnClickListener listener;
    private TextView nombreLista;
    private TextView creadorLista;
    private TextView numCanciones;


    public ListAdapter(MainActivity activity){

        this.activity = activity;
        datosLista = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {

        if(listener!=null){
            listener.onClick(v);
        }

    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        public View view;

        public ViewHolder(View v){
            super(v);
            view = v;

        }




    }


    public ListAdapter(ArrayList<Data> datos){
        datosLista = datos;


    }


    public ArrayList<Data> getDatosLista() {

        return datosLista;
    }

    public void setDatosLista(ArrayList<Data> datosLista) {

        this.datosLista = datosLista;
        notifyDataSetChanged();
    }


    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_holder, parent, false);
        view.setOnClickListener(this);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        nombreLista = holder.view.findViewById(R.id.creadorListaTV);
        creadorLista = holder.view.findViewById(R.id.nombreListaTV);
        numCanciones = holder.view.findViewById(R.id.numCancionesTV);
        Glide.with(holder.view.getContext()).load(datosLista.get(position).getPicture_big()).centerCrop().into((ImageView)holder.itemView.findViewById(R.id.imagenLista));

        nombreLista.setText(datosLista.get(position).getTitle());
        creadorLista.setText(datosLista.get(position).getUser().getName());
        numCanciones.setText(""+datosLista.get(position).getNb_tracks()+" Canciones");




    }

    public void setOnClickListener (View.OnClickListener listener){
        this.listener = listener;

    }



    @Override
    public int getItemCount() {

        return datosLista.size();
    }



}
