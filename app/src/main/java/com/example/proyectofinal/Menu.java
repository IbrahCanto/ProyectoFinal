package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void PizzaBoton (View view){
        Intent botonpizza = new Intent(this, Lista1.class);
        startActivity(botonpizza);
    }

    public void PepsiBoton (View view){
        Intent botonpizza = new Intent(this, Catalogo.class);
        startActivity(botonpizza);
    }

    public void GatitoBoton (View view){
        Intent gatitoBoton = new Intent(this, MainActivity.class);
        startActivity(gatitoBoton);
    }

    @Override public void onBackPressed() { }

}