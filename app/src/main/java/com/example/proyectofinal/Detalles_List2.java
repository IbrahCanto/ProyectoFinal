package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalles_List2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_list2);

        TextView nombre = (TextView)  findViewById(R.id.tbnombre);
        TextView descripcion = (TextView)  findViewById(R.id.tbdescripcion);
        TextView precio = (TextView)  findViewById(R.id.tbprecio);

        ImageView image = (ImageView)  findViewById(R.id.tbimage);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();


        if(b!=null) {
           // String image2 = getIntent().getStringExtra("IMG");
           // Bitmap bitmap = BitmapFactory.decodeFile(image2);
           //image.setImageDrawable(bitmap);

           image.setImageResource(b.getInt("IMG"));
            nombre.setText(b.getString("TIT"));
            descripcion.setText(b.getString("DET"));
            precio.setText(b.getString("PRE"));

        }




    }
    public void PepsiBoton (View view){
        Intent botonpizza = new Intent(this, InsertarElemento.class);
        startActivity(botonpizza);
    }
}