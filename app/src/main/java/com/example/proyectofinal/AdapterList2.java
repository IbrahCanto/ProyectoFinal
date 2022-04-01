package com.example.proyectofinal;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdapterList2 extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] nombres;
    private final String[] nombres2;
    private final String[] descripcion;
    private final Integer[] id_images;
    private final String[] precio;


    public AdapterList2(Activity context, String[] nombres, String[] nombres2, String[] descripcion, Integer[] id_images, String[] precio) {
        super(context, R.layout.item,nombres);
        this.context = context;
        this.nombres = nombres;
        this.nombres2 = nombres2;
        this.descripcion = descripcion;
        this.id_images = id_images;
        this.precio = precio;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.item,  null);

        TextView _nombre = (TextView) itemView.findViewById(R.id.nombre);
        TextView _descripcion = (TextView) itemView.findViewById(R.id.descripcion);
        ImageView _imagen = (ImageView) itemView.findViewById(R.id.imagen);
        TextView _precio = (TextView) itemView.findViewById(R.id.precio);



        _nombre.setText(nombres[position]);
        _descripcion.setText(descripcion[position]);
        _imagen.setImageResource(id_images[position]);
        _precio.setText(precio[position]);


        return itemView;



        //return super.getView(position, convertView, parent);
    }
}