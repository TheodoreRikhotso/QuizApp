package com.example.admin.quizapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


 Toolbar toolbar;

public static  String ACTIVITY = "h";
 Button btnF,btnShoe,btnMakeup;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            toolbar =(Toolbar)findViewById(R.id.toobar);
            toolbar.setTitle("Fashion Quiz");
            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.setVisibility(View.VISIBLE);

            //getSupportActionBar().setDisplayShowTitleEnabled(false);


            btnF = (Button)findViewById(R.id.btnFabric);
            btnShoe = (Button)findViewById(R.id.btnShoe);
            btnMakeup = (Button)findViewById(R.id.btnMakeup);


            btnF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(MainActivity.this,Fabric_Activity.class);
                    startActivity(i);
                }
            });

            btnMakeup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(MainActivity.this,MakeUp.class);
                    startActivity(i);
                }
            });

            btnShoe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(MainActivity.this,ShoesActivity.class);
                    startActivity(i);
                }
            });


        }









}
