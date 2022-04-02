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
                "iPhone 12",
                "iPhone 13",
                "iPhone 11 Pro Max",
                "iPhone 12 mini",
                "iPhone 13 Pro Max",
                "iPhone 13 Pro",
                "iPhone 7",
                "iPhone SE",
                "iPhone 11"
        };

        String[] nombres2 = {
                "iPhone_11",
                "iPhone_13_Pro_Max",
                "iPhone_12",
                "iPhone_13",
                "iPhone_11_Pro_Max",
                "iPhone_12_mini",
                "iPhone_13_Pro_Max",
                "iPhone_13_Pro",
                "iPhone_7",
                "iPhone_SE",
                "iPhone_11"
        };

        String[] modelos = {
                "256Gb",
                "512Gb",
                "128Gb",
                "256Gb",
                "256Gb",
                "128Gb",
                "1Tb",
                "1Tb",
                "32Gb",
                "128Gb",
                "64Gb"
        };

        String[] descripcion = {
                "Graba videos 4K y captura retratos y paisajes espectaculares con el nuevo sistema de dos cámaras. Toma fotos increíbles en situaciones de poca luz con el modo Noche. Disfruta de colores reales en las fotos, videos y juegos con la pantalla Liquid Retina de 6.1 pulgadas. Aprovecha un rendimiento sin precedentes en los juegos, la realidad aumentada y la fotografía con el chip A13 Bionic. Haz mucho más sin necesidad de volver a cargar el teléfono gracias a una batería para todo el día. Y no te preocupes si se moja, el iPhone 11 tiene una resistencia al agua de hasta 30 minutos a una profundidad máxima de 2 metros.",
                "El nuevo iPhone 13 Pro Max Un sistema de cámaras mucho más poderoso. Una pantalla con respuesta inmediata en cada interacción. El chip de smartphone más rápido del mundo. Un diseño increíblemente resistente. Y un gran salto en duración de batería, el mayor avance en nuestro sistema de cámaras Pro hasta ahora. Un hardware de última generación que captura aún más detalles, un software superinteligente que brinda nuevas técnicas para tomar fotos y grabar videos, y un chip ultrarrápido que hace que todo esto sea posible. Se abre un mundo de posibilidades para tu creatividad.",
                "El chip A14 Bionic, el más rápido en un smartphone. Una pantalla OLED de borde a borde. Un nuevo frente de Ceramic Shield, cuatro veces más resistente a las caídas. Además, ahora el modo Noche viene en todas las cámaras. El iPhone 12 lo tiene todo. Y está disponible en dos tamaños perfectos.",
                "Llega iPhone 13 con una evolución considerable en materia de fotografía, rendimiento y duración de batería. Cuenta con pantalla Super Retina XDR de 6.1 pulgadas y doble cámara diagonal de 12 megapixeles con sensores gran angular, ultra gran angular y estabilización óptica de imagen por desplazamiento que capta 47% más luz; ahora tus fotos y videos lucirán más detalles sin importar las condiciones de iluminación y movimiento. Prueba los nuevos estilos fotográficos y genera contenido de la más alta calidad para tus redes sociales. Descubre todo lo que puedes lograr con el modo cine y comienza a producir como un profesional. ",
                "Toma fotos y graba videos espectaculares con las cámaras ultra gran angular, gran angular y teleobjetivo. Captura fotos increíbles en situaciones de poca luz gracias al modo Noche. Mira películas y programas en HDR en la pantalla Super Retina XDR de 6.5 pulgadas, la más brillante en un iPhone hasta ahora. Disfruta de una batería para todo el día y un nuevo nivel de resistencia al agua. Y con el chip A13 Bionic, tendrás un rendimiento sin precedentes en los juegos, la realidad aumentada y la fotografía. Es un iPhone tan poderoso que tuvimos que llamarlo Pro.",
                "iPhone 12 mini es perfecto si buscas un dispositivo ligero y delgado, con la mayor resistencia y el rendimiento de un procesador A14 Bionic. Su pantalla OLED Super Retina XDR de 5.4 pulgadas ofrece más resolución y color. Frente de Ceramic Shield, más resistente que el vidrio. Sistema de doble cámara trasera de 12 megapixeles: ultra gran angular y gran angular con modo noche para que logres las fotos y video que creías imposibles. Graba videos 4K HDR con Dolby Vision.",
                "El nuevo iPhone 13 Pro Max Un sistema de cámaras mucho más poderoso. Una pantalla con respuesta inmediata en cada interacción. El chip de smartphone más rápido del mundo. Un diseño increíblemente resistente. Y un gran salto en duración de batería, el mayor avance en nuestro sistema de cámaras Pro hasta ahora. Un hardware de última generación que captura aún más detalles, un software superinteligente que brinda nuevas técnicas para tomar fotos y grabar videos, y un chip ultrarrápido que hace que todo esto sea posible. Se abre un mundo de posibilidades para tu creatividad.",
                "El nuevo iPhone 13 Pro sus estilos son tan inteligentes que resaltan o apagan los colores de las fotos sin alterar el tono natural de la piel, Los Estilos Fotográficos te permiten darles un look más personal a tus fotos. A diferencia de los filtros, los estilos aplican ajustes de forma selectiva a cada zona de la imagen, sin alterar los tonos de piel, Elige Colorido para que tus fotos se vean más brillantes y vívidas, Contraste Intenso para aplicar sombras más oscuras y colores más profundos, y Cálido o Frío para acentuar los subtonos dorados o azules.",
                "iPhone 7, el mejor de su clase. Nuevos y más avanzados sistemas de cámara. Mejora el rendimiento y la duración de batería. Carcasa que resiste salpicaduras. Único sonido envolvente con bocinas estéreo. La pantalla más brillante y con mayor cantidad de colores. Máxima potencia en un diseño increíble. ",
                "El Apple iPhone SE es el nuevo smartphone de cuatro pulgadas que reemplaza al iPhone 5S. Mientras que conserva casi idéntico diseño exterior, el hardware interno ha sido actualizado a la altura del iPhone 6s, incluyendo un procesador A9, NFC, cámara de 12 megapixels con captura de video 4K, y corre iOS 9.3.",
                "Graba videos 4K y captura retratos y paisajes espectaculares con el nuevo sistema de dos cámaras. Toma fotos increíbles en situaciones de poca luz con el modo Noche. Disfruta de colores reales en las fotos, videos y juegos con la pantalla Liquid Retina de 6.1 pulgadas. Aprovecha un rendimiento sin precedentes en los juegos, la realidad aumentada y la fotografía con el chip A13 Bionic. Haz mucho más sin necesidad de volver a cargar el teléfono gracias a una batería para todo el día. Y no te preocupes si se moja, el iPhone 11 tiene una resistencia al agua de hasta 30 minutos a una profundidad máxima de 2 metros."
        };
        Integer[] idimagenes = {
                R.drawable.iphone11,
                R.drawable.iphone13,
                R.drawable.iphone12,
                R.drawable.iphone13normalito,
                R.drawable.iphone11promax,
                R.drawable.iphone12mini,
                R.drawable.iphone13promax1tb,
                R.drawable.iphone13pro,
                R.drawable.iphone7,
                R.drawable.iphponese,
                R.drawable.iphpojnkdhisf
        };
        String[] precio = {
                String.valueOf(17499),
                String.valueOf(28999),
                String.valueOf(17999),
                String.valueOf(20999),
                String.valueOf(30499),
                String.valueOf(16499),
                String.valueOf(41999),
                String.valueOf(38999),
                String.valueOf(7199),
                String.valueOf(10799),
                String.valueOf(12999)
        };
        AdapterList2 adaptador = new AdapterList2(this, nombres, nombres2, modelos, descripcion, idimagenes, precio);

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
                        visorDetalles.putExtra("MOD", modelos[i]);
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