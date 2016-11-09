package com.example.dev.checkmethod;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static Thread thread;
    private TextView mybox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybox=(TextView)findViewById(R.id.box);
        SharedPreferences sharedPreferences=getSharedPreferences("VALUE",MODE_PRIVATE);
        String box=sharedPreferences.getString("ONE","").toString();
        if(box!=""){
            Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);
            this.finish();
        }
        else{
            thread=new Thread(){
                @Override
                public void run(){
                    try {
                        sleep(6000);
                        Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                        startActivity(intent);
                        // Toast.makeText(getApplicationContext(), "Running Thread...", Toast.LENGTH_LONG).show();
                    } catch (InterruptedException e) {
                        Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();
                    }

                }
            };
            thread.start();
        }
        //Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
    }


}
