package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class InsertarElemento extends AppCompatActivity {
    EditText nombre,cal1,cal2,cal3,prom;
    Button registrar,next,verimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_elemento);
        nombre = (EditText) findViewById(R.id.ed_name_ins);
        cal2 = (EditText) findViewById(R.id.ed_cal2_ins);
        cal3 = (EditText) findViewById(R.id.ed_cal3_ins);
        prom = (EditText) findViewById(R.id.ed_prom_ins);
        registrar = (Button) findViewById(R.id.registrar);
        next = (Button) findViewById(R.id.nxt);


        TextView nombre = (TextView)  findViewById(R.id.tbnombre);
        TextView nombre2 = (TextView)  findViewById(R.id.tbnombre2);
        TextView descripcion = (TextView)  findViewById(R.id.tbdescripcion);
        ImageView image = (ImageView)  findViewById(R.id.tbimage);
        TextView precio = (TextView)  findViewById(R.id.tbprecio);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();


        if(b!=null) {
            image.setImageResource(b.getInt("IMG"));
            nombre.setText(b.getString("TIT"));
            nombre2.setText(b.getString("TIT2"));
            descripcion.setText(b.getString("DET"));
            precio.setText(b.getString("PRE"));

        }


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertarElemento.this,MainActivity.class);
                startActivity(intent);
            }
        });


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InsertarAlumno(nombre2.getText().toString(), precio.getText().toString(),cal2.getText().toString(),cal3.getText().toString(),prom.getText().toString());
                //Intent intent = new Intent(InsertarElemento.this,Resumen.class);
                //startActivity(intent);

            }
        });


    }

    private void InsertarAlumno(String name_i, String cal_i, String cal2_i, String cal3_i, String promedio_i) {
        RequestQueue queque = Volley.newRequestQueue(this);
        String url= "https://proyectofinalica.000webhostapp.com/index.php?insert={\"Nombre\":\""+name_i+"\",\"Cal1\":\""+cal_i+"\",\"Cal2\":\""+cal2_i+"\",\"Cal3\":\""+cal3_i+"\",\"Promedio\":\""+promedio_i+"\"}";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(response.optString("Status").equals("success")){
                    Toast.makeText(getApplicationContext()," "+response.optString("Mensaje"),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(InsertarElemento.this,Resumen.class);
                    startActivity(intent);
                }else
                    Toast.makeText(getApplicationContext(),"Server:"+response.optString("Mensaje"),Toast.LENGTH_LONG).show();
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error no se pudo establecer la comunicacion", Toast.LENGTH_LONG).show();
            }
        });

        queque.add(jsonObjectRequest);
    }


}