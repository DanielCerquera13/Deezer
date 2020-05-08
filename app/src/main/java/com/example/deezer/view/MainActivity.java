package com.example.deezer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.deezer.R;
import com.example.deezer.adapters.ListAdapter;
import com.example.deezer.control.MainController;
import com.example.deezer.model.Data;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private EditText buscarListaET;
    private ImageButton buscarListaBT;
    private MainController controller;
    private ArrayList<Data> datos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos = new ArrayList<Data>();


        buscarListaET = findViewById(R.id.buscarListaET);
        buscarListaBT = findViewById(R.id.buscarListaBT);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ListAdapter(this);
        recyclerView.setAdapter(adapter);
        controller = new MainController(this);
        adapter.setOnClickListener(controller);


    }




    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public EditText getBuscarListaET() {
        return buscarListaET;
    }

    public ImageButton getBuscarListaBT() {
        return buscarListaBT;
    }

    public ListAdapter getAdapter() {
        return adapter;
    }
}
