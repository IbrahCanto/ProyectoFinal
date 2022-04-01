package com.example.proyectofinal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
        import android.os.Bundle;
        import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;

        import androidx.appcompat.app.AppCompatActivity;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.HashMap;

public class Lista1 extends AppCompatActivity {


    private ProgressDialog dialog;
    ListView listView;
    private static  String url="https://proyectofinalica.000webhostapp.com/?lista2={%22user%22:%22ICA%22,%22password%22:%221234%22}";
    ArrayList<HashMap<String,String>> array1=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista1);
        listView=findViewById(R.id.listview);
        new DoWork().execute();
    }
    private class DoWork extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(Lista1.this);
            dialog.setMessage("Please wait...");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if(dialog.isShowing()){
                dialog.dismiss();
            }

            ListAdapter adapter=new SimpleAdapter(Lista1.this,array1,
                    R.layout.list_item,new String[]{"Nombre","Cal1","Cal2","Cal3","Promedio"},new int[]{
                    R.id.name,R.id.email,R.id.mobile,R.id.gender,R.id.address
            });

            listView.setAdapter(adapter);

        }

        @Override
        protected Void doInBackground(Void... voids) {

            httphandler httpHandler=new httphandler();
            String json=httpHandler.Call(url);
            try{
                JSONObject jsonObject=new JSONObject(json);
                JSONArray array=jsonObject.getJSONArray("Datos");
                for(int i=0;i<array.length();i++){
                    JSONObject c=array.getJSONObject(i);
                    String name=c.getString("Nombre");
                    String email=c.getString("Cal1");
                    String address=c.getString("Cal2");
                    String gender=c.getString("Cal3");
                    String prom=c.getString("Promedio");

                    //JSONObject phone=c.getJSONObject("phone");
                    //String mobile=phone.getString("mobile");

                    HashMap<String,String> list=new HashMap<>();
                    list.put("Nombre",name);
                    list.put("Cal1",email);
                    list.put("Cal2",address);
                    //list.put("phone",mobile);
                    list.put("Cal3",gender);
                    list.put("Promedio",prom);


                    array1.add(list);

                }

            }catch (JSONException e){
                Log.e("Error", "Json parsing error: " + e.getMessage());
            }
            return null;

        }
    }

    public void PizzaBoton (View view){
        Intent botonpizza = new Intent(this, Menu.class);
        startActivity(botonpizza);
    }
}