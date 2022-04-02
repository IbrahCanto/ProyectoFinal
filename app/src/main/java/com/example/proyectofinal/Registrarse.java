package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonObjectRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONObject;

import java.util.Date;

public class Registrarse extends AppCompatActivity {
    EditText nombre,cal1,cal2,cal3,prom;
    Button registrar,next,verimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        nombre = (EditText) findViewById(R.id.ed_name_ins);
        cal1 = (EditText) findViewById(R.id.ed_cal1_ins);
        cal2 = (EditText) findViewById(R.id.ed_cal2_ins);
        cal3 = (EditText) findViewById(R.id.ed_cal3_ins);
        prom = (EditText) findViewById(R.id.ed_prom_ins);
        registrar = (Button) findViewById(R.id.registrar);
        verimage = (Button)findViewById(R.id.verimagen);
        next = (Button) findViewById(R.id.nxt);



        TextView dateView = (TextView)findViewById(R.id.datumprikazi);
        setDate(dateView);

        TextView hourView = (TextView)findViewById(R.id.datumprikaz2i);
        setHour(hourView);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registrarse.this,MainActivity.class);
                startActivity(intent);
            }
        });


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InsertarAlumno(nombre.getText().toString(), cal1.getText().toString(),cal2.getText().toString(),dateView.getText().toString(),hourView.getText().toString());

            }
        });

    }


    public void setDate (TextView view){

        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MMMM.yyyy");//formating according to my need
        String date = formatter.format(today);
        view.setText(date);
    }

    public void setHour (TextView view){

        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm.a");//formating according to my need
        String date = formatter.format(today);
        view.setText(date);
    }


    private void InsertarAlumno(String name_i, String cal_i, String cal2_i, String cal3_i, String promedio_i) {
        RequestQueue queque = Volley.newRequestQueue(this);
        String url= "https://proyectofinalica.000webhostapp.com/index.php?insertLogin={\"Nombre\":\""+name_i+"\",\"Contraseña\":\""+cal_i+"\",\"ID\":\""+cal2_i+"\",\"Fecha\":\""+cal3_i+"\",\"Hora\":\""+promedio_i+"\"}";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(response.optString("Status").equals("success")){
                    Toast.makeText(getApplicationContext()," "+response.optString("Mensaje"),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Registrarse.this,MainActivity.class);
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