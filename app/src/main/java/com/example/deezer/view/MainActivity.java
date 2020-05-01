package com.example.deezer.view;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deezer.R;
import com.example.deezer.control.MainController;

public class MainActivity extends AppCompatActivity {

    private TextView nombreLista1TV;
    private TextView nombreLista2TV;
    private TextView nombreLista3TV;
    private TextView nombreLista4TV;
    private TextView creadorLista1TV;
    private TextView creadorLista2TV;
    private TextView creadorLista3TV;
    private TextView creadorLista4TV;
    private TextView numLista1TV;
    private TextView numLista2TV;
    private TextView numLista3TV;
    private TextView numLista4TV;
    private ImageView imagenLista1;
    private ImageView imagenLista2;
    private ImageView imagenLista3;
    private ImageView imagenLista4;
    private EditText buscarListaET;
    private ImageButton buscarListaBT;

    private MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreLista1TV = findViewById(R.id.nombreLista1TV);
        nombreLista2TV = findViewById(R.id.nombreLista2TV);
        nombreLista3TV = findViewById(R.id.nombreLista3TV);
        nombreLista4TV = findViewById(R.id.nombreLista4TV);
        creadorLista1TV = findViewById(R.id.creadorLista1TV);
        creadorLista2TV = findViewById(R.id.creadorLista2TV);
        creadorLista3TV = findViewById(R.id.creadorLista3TV);
        creadorLista4TV = findViewById(R.id.creadorLista4TV);
        numLista1TV = findViewById(R.id.numLista1TV);
        numLista2TV = findViewById(R.id.numLista2TV);
        numLista3TV = findViewById(R.id.numLista3TV);
        numLista4TV = findViewById(R.id.numLista4TV);
        imagenLista1 = findViewById(R.id.imagenLista1);
        imagenLista2 = findViewById(R.id.imagenLista2);
        imagenLista3 = findViewById(R.id.imagenLista3);
        imagenLista4 = findViewById(R.id.imagenLista4);
        buscarListaET = findViewById(R.id.buscarListaET);
        buscarListaBT = findViewById(R.id.buscarListaBT);

        controller = new MainController(this);
    }

    public TextView getNombreLista1TV() {
        return nombreLista1TV;
    }

    public TextView getNombreLista2TV() {
        return nombreLista2TV;
    }

    public TextView getNombreLista3TV() {
        return nombreLista3TV;
    }

    public TextView getNombreLista4TV() {
        return nombreLista4TV;
    }

    public TextView getCreadorLista1TV() {
        return creadorLista1TV;
    }

    public TextView getCreadorLista2TV() {
        return creadorLista2TV;
    }

    public TextView getCreadorLista3TV() {
        return creadorLista3TV;
    }

    public TextView getCreadorLista4TV() {
        return creadorLista4TV;
    }

    public TextView getNumLista1TV() {
        return numLista1TV;
    }

    public TextView getNumLista2TV() {
        return numLista2TV;
    }

    public TextView getNumLista3TV() {
        return numLista3TV;
    }

    public TextView getNumLista4TV() {
        return numLista4TV;
    }

    public ImageView getImagenLista1() {
        return imagenLista1;
    }

    public ImageView getImagenLista2() {
        return imagenLista2;
    }

    public ImageView getImagenLista3() {
        return imagenLista3;
    }

    public ImageView getImagenLista4() {
        return imagenLista4;
    }

    public EditText getBuscarListaET() {
        return buscarListaET;
    }

    public ImageButton getBuscarListaBT() {
        return buscarListaBT;
    }
}
