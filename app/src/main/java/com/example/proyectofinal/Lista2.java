package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
import android.view.View;
        import android.widget.AdapterView;
import android.widget.ListView;

public class Lista2 extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista2);
        listView = (ListView) findViewById(R.id.planetas);

        String[] nombres = {
                "iPhone 11",
                "iPhone 13 Pro Max",
                "Mercurio",
                "Venus",
                "Tierra",
                "Marte",
                "Jupiter",
                "Saturno",
                "Urano",
                "Neptuno",
                "Plutón"
        };

        String[] nombres2 = {
                "iPhone_11",
                "iPhone_13_Pro_Max",
                "Mercurio",
                "Venus",
                "Tierra",
                "Marte",
                "Jupiter",
                "Saturno",
                "Urano",
                "Neptuno",
                "Plutón"
        };

        String[] descripcion = {
                "Graba videos 4K y captura retratos y paisajes espectaculares con el nuevo sistema de dos cámaras. Toma fotos increíbles en situaciones de poca luz con el modo Noche. Disfruta de colores reales en las fotos, videos y juegos con la pantalla Liquid Retina de 6.1 pulgadas. Aprovecha un rendimiento sin precedentes en los juegos, la realidad aumentada y la fotografía con el chip A13 Bionic. Haz mucho más sin necesidad de volver a cargar el teléfono gracias a una batería para todo el día. Y no te preocupes si se moja, el iPhone 11 tiene una resistencia al agua de hasta 30 minutos a una profundidad máxima de 2 metros.",
                "El nuevo iPhone 13 Pro Max Un sistema de cámaras mucho más poderoso. Una pantalla con respuesta inmediata en cada interacción. El chip de smartphone más rápido del mundo. Un diseño increíblemente resistente. Y un gran salto en duración de batería, el mayor avance en nuestro sistema de cámaras Pro hasta ahora. Un hardware de última generación que captura aún más detalles, un software superinteligente que brinda nuevas técnicas para tomar fotos y grabar videos, y un chip ultrarrápido que hace que todo esto sea posible. Se abre un mundo de posibilidades para tu creatividad.",
                "Es un planeta 1",
                "Es un planeta 2",
                "Es un planeta 3",
                "Es un planeta 4",
                "Es un planeta 5",
                "Es un planeta 6",
                "Es un planeta 7",
                "Es un planeta 8",
                "Es un planeta 9"
        };
        Integer[] idimagenes = {
                R.drawable.iphone11,
                R.drawable.iphone13,
                R.drawable.planetagenerico,
                R.drawable.planetagenerico,
                R.drawable.planetagenerico,
                R.drawable.planetagenerico,
                R.drawable.planetagenerico,
                R.drawable.planetagenerico,
                R.drawable.planetagenerico,
                R.drawable.planetagenerico,
                R.drawable.planetagenerico
        };
        String[] precio = {
                String.valueOf(12999),
                String.valueOf(28999),
                "Edineros",
                "Esdinerosneta 2",
                "Edinerosa 3",
                "Es udineros",
                "Es un dineros 5",
                "Esdineros 6",
                "Edinerosa 7",
                "Edinerosta 8",
                "Edinerosa 9"
        };
        AdapterList2 adaptador = new AdapterList2(this, nombres, nombres2, descripcion, idimagenes, precio);

        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent visorDetalles = new Intent(view.getContext(), InsertarElemento.class);
                        visorDetalles.putExtra("IMG", idimagenes[i]);
                        visorDetalles.putExtra("TIT", nombres[i]);
                        visorDetalles.putExtra("TIT2", nombres2[i]);
                        visorDetalles.putExtra("DET", descripcion[i]);
                        visorDetalles.putExtra("PRE", precio[i]);



                        startActivity(visorDetalles);

                    }




                });
                //Toast.makeText(getApplicationContext(),"Seleccionaste : "+nombres[i],Toast.LENGTH_LONG).show();


                //Intent intent = new Intent(getApplicationContext(), Tierra.class);
                //startActivity(intent);
                //startActivity(intent);
            }
        });

    }
}