package com.example.admin.quizapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Score_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_);

        TextView tvPercentange= (TextView) findViewById(R.id.tvPercentange);
        TextView txtScore = (TextView) findViewById(R.id.tvScore);
        TextView txtHighScore = (TextView) findViewById(R.id.tvHighScore);
        TextView tvLTime = (TextView) findViewById(R.id.tvLeftTime);


        ShoesActivity.CHECK=true;
        Fabric_Activity.CHECK= true;
        MakeUp.CHECK=true;

        // receive the score from last activity by Intent

        Intent i = new Intent();
       Bundle b = this.getIntent().getExtras();
        int score = b.getInt("score");
        int timeleft = b.getInt("count");
        String src = i.getStringExtra(MakeUp.TIME_up);



        double highNo=5;
        double num= score/highNo;
        double perc= num*100;

        // display current score

        txtScore.setText(src);
        tvPercentange.setText("Score in Percentang"+perc);

        // use Shared preferences to save the best score
        int differnt =timeleft;
         tvLTime.setText("Time Left 00:"+ differnt);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore",0);
        if(highscore>= score) {
            txtHighScore.setText("High score: " + highscore);
            if(score<3) {
//                iv_mod.setImageResource(R.drawable.trans_sad);
//                ((TransitionDrawable) iv_mod.getDrawable()).startTransition(300);
            }
            else {

//                iv_mod.setImageResource(R.drawable.trans_happy);
//                ((TransitionDrawable) iv_mod.getDrawable()).startTransition(300);
            }
        }
        else
        {
            txtHighScore.setText("New highscore: "+score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score);
            editor.commit();
        }

        ImageButton btnBack =(ImageButton)findViewById(R.id.btnBack);
        ImageButton btnTry =(ImageButton)findViewById(R.id.btnTry);


        if( MainActivity.ACTIVITY =="sheo") {
            btnTry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShoesActivity.CHECK=false;
                    Intent i = new Intent(Score_Activity.this, ShoesActivity.class);// retry btn to return to category
                    startActivity(i);
                }
            });
        }else if( MainActivity.ACTIVITY =="fabric") {
            btnTry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fabric_Activity.CHECK= false;
                    Intent i = new Intent(Score_Activity.this, Fabric_Activity.class);// retry btn to return to category
                    startActivity(i);
                }
            });
        }else if( MainActivity.ACTIVITY =="make") {
            btnTry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MakeUp.CHECK=false;

                    Intent i = new Intent(Score_Activity.this, MakeUp.class);// retry btn to return to category
                    startActivity(i);
                }
            });
        }
                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Fabric_Activity.CHECK= false;
                        Intent i = new Intent(Score_Activity.this,MainActivity.class);// retry btn to return to MainActivty
                        startActivity(i);



                    }
                });

        }

//    public void onClick(View view) {
//        Intent intent = new Intent(Score_Activity.this, MainActivity.class);
//        startActivity(intent);
 }


