package com.dkl.auser.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView);

    new Thread(){


        @Override
        public void run() {
            super.run();

            URL url = null;
            try {
                url = new URL("http://www.google.com.tw");

                    HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.connect();
                InputStream is = con.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);

                BufferedReader br = new BufferedReader(isr);
                String str = br.readLine();
                br.close();
                isr.close();
                is.close();
                Log.d("MyNET", str);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }.start();
    }
public void clicktext(View v){
    new Thread(){
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(2000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("Okay!!!");
                    }
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }.start();

    }






}
