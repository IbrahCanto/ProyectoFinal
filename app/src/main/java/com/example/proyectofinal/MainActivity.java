package com.example.proyectofinal;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonObjectRequest;
        import com.android.volley.toolbox.Volley;
        import com.google.android.material.button.MaterialButton;

        import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent botonpizza = new Intent(this, Menu.class);


        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("ICA") && password.getText().toString().equals("12345")){
                    //correct
                    startActivity(botonpizza);
                    Toast.makeText(MainActivity.this,"Bienvenid@",Toast.LENGTH_SHORT).show();
                }else
                    //incorrect
                    Toast.makeText(MainActivity.this,"Falló el acceso",Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void PizzaBoton (View view){
        Intent botonpizza = new Intent(this, Catalogo.class);
        startActivity(botonpizza);
    }

    public void registerBoton (View view){
        Intent botonregister = new Intent(this, Registrarse.class);
        startActivity(botonregister);
    }



    @Override public void onBackPressed() { }


}