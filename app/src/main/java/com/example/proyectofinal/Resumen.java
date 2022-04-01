package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Resumen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
    }

    public void PizzaBoton (View view){
        Intent botonpizza = new Intent(this, Lista1.class);
        startActivity(botonpizza);
    }

    @Override public void onBackPressed() { }

}