package com.example.proyectofinal;
        import android.util.Log;
        import java.io.BufferedInputStream;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;

public class httphandler {
    public String Call(String url){
        String response=null;
        try{
            URL url1=new URL(url);
            HttpURLConnection a=(HttpURLConnection)url1.openConnection();
            a.setRequestMethod("GET");
            InputStream in=new BufferedInputStream(a.getInputStream());
            response=convertStreamToString(in);
        }catch (IOException e){
            Log.e("Error","is "+e.getMessage());
        }
        return response;
    }

    private String convertStreamToString(InputStream in) {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(in));
        StringBuffer stringBuffer=new StringBuffer();
        String lines;
        try{
            while((lines=bufferedReader.readLine())!=null){
                stringBuffer.append(lines).append('\n');

            }
        }catch (IOException e){
            Log.e("Error","is "+e.getMessage());
        }

        return stringBuffer.toString();
    }
}