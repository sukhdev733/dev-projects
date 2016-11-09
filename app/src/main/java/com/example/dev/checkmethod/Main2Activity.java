package com.example.dev.checkmethod;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // Thread t=MainActivity.thread;


        SharedPreferences spOne=getSharedPreferences("VALUE", MODE_PRIVATE);
        SharedPreferences.Editor edit=spOne.edit();
        String once="a";
        edit.putString("ONE", once);
        edit.commit();
////

    }

    boolean doubleBackPressed=false;

    @Override
    public void onBackPressed() {
        if(doubleBackPressed){
            super.onBackPressed();
            return;
        }
        this.doubleBackPressed=true;

        Toast.makeText(this, "Please click Back button again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                doubleBackPressed=false;

            }
        }, 2000);
       // this.finish();
    }
}
