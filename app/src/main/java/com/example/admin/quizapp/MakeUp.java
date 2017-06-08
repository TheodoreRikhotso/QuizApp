package com.example.admin.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.CalendarContract;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MakeUp extends AppCompatActivity {
    private QuestionLibraryThree ql = new QuestionLibraryThree();

    private TextView tvQuestion,tvScoreView;  //current question to answer
    private Button btnChoice1,btnChoice2,btnChoice3,btnChoice4;

    private volatile boolean running = true;

    private String answer;  // correct answer for question in mQuestionView
    private int score = 0;  // current total score
    private int mQuestionNumber = 0; // current question number

    Button a;
    Toolbar toolbar;
    TextView tvTimer;
    int count =20;

    int countProgress = 20;
    ProgressBar pbShoe;

    public  static String TIME_up = "TIME";
    public  static int TIME_UP = 0;

    public static boolean CHECK = false;
    Thread t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_up);

        toolbar =(Toolbar)findViewById(R.id.toobar);
        toolbar.setTitle("Fashion Quiz");
        toolbar.setBackgroundColor(Color.parseColor("#cc8800"));
        setSupportActionBar(toolbar);
        tvTimer =(TextView)findViewById(R.id.tvTimaer);
        pbShoe =(ProgressBar) findViewById(R.id.pbMakeup);
        pbShoe.setBackgroundColor(Color.parseColor("#cc8800"));


        MainActivity.ACTIVITY ="make";




        t = new Thread(){
            @Override
            public void run(){
                while (!isInterrupted()) {
                    if (count >11) {

                        try {
                            Thread.sleep(1000);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    count--;


                                    tvTimer.setText(String.valueOf(getDurationString(count)));
                                    ////tvTimer.setTextColor(Color.GREEN);



                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else   if (count <11 && count !=0) {

                        try {
                            Thread.sleep(1000);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    count--;


                                    tvTimer.setText(String.valueOf(getDurationString(count)));
                                    tvTimer.setTextColor(Color.RED);



                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }if(count == 1)
                    {
                        if( CHECK==false) {
                            running = false;
                            //stopIndicator = null;

                            Intent intent = new Intent(MakeUp.this, Score_Activity.class);
                            String time = "Time Up";
                            intent.putExtra("time",TIME_up);

                            startActivity(intent);

                        }

                    }

                }
            }
        };
        t.start();

        tvScoreView = (TextView)findViewById(R.id.tv3coreView);
        tvQuestion = (TextView)findViewById(R.id.tv3Question);
        btnChoice1 = (Button)findViewById(R.id.btn3Choice1);
        btnChoice2 = (Button)findViewById(R.id.btn3Choice2);
        btnChoice3 = (Button)findViewById(R.id.btn3Choice3);
        btnChoice4 = (Button)findViewById(R.id.btn3Choice4);


        updateQuestion();

        updateScore(score);

    }

    private void updateQuestion(){

        if(mQuestionNumber<ql.getLength() ){

            tvQuestion.setText(ql.getQuestion(mQuestionNumber));
            btnChoice1.setText(ql.getChoice(mQuestionNumber, 1));
            btnChoice2.setText(ql.getChoice(mQuestionNumber, 2));
            btnChoice3.setText(ql.getChoice(mQuestionNumber, 3));
            btnChoice4.setText(ql.getChoice(mQuestionNumber,4));
            answer = ql.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {

            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(MakeUp.this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(MakeUp.this);
            }
            builder.setTitle("Done with Quiz")
                    .setMessage("Do you to go to Score bord?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent  intent = new Intent(MakeUp.this, Score_Activity.class);
                            Bundle b = new Bundle();

                            TIME_UP= count;
                            count=100000000;
                            b.putInt("score", score); // pass the current score to the second screen
                            b.putInt("count",count);
                            intent.putExtras(b);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent  intent = new Intent(MakeUp.this, MainActivity.class);
                            count=10000000;
                            startActivity(intent);
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }


    private void updateScore(int point) {
        tvScoreView.setText("" + score+"/"+ql.getLength());
    }

    public void on3Click(View view) {

        a = (Button) view;


        if (a.getText() == answer){
            score = score + 1;
           // a.setBackgroundColor(Color.GREEN);
            new CountDownTimer(500, 100) {

                @Override
                public void onTick(long arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onFinish() {
                    //a.setBackgroundColor(Color.LTGRAY);
                }
            }.start();
            pbShoe.setProgress(countProgress);
            countProgress= countProgress+20;
        }else {


            //a.setBackgroundColor(Color.RED);
            new CountDownTimer(500, 100) {

                @Override
                public void onTick(long arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onFinish() {
                   // a.setBackgroundColor(Color.LTGRAY);
                }
            }.start();

            pbShoe.setProgress(countProgress);
            countProgress= countProgress+20;
            ///a.setBackgroundColor(Color.RED);

        }
        updateScore(score);

        updateQuestion();

    }
    private String getDurationString(int seconds) {

        ///int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;

        return  twoDigitString(minutes) + " : " + twoDigitString(seconds);
    }

    private String twoDigitString(int number) {

        if (number == 0) {
            return "00";
        }

        if (number / 10 == 0) {
            return "0" + number;
        }

        return String.valueOf(number);
    }

}
