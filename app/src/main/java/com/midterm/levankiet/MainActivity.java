package com.midterm.levankiet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView btnBack, btnMove;
    private Button btnTrue, btnFalse, btnSubmit;
    private TextView tv_ques;
    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    private MyViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new ViewModelProvider(this).get(MyViewModel.class);

        btnMove = (ImageView)findViewById(R.id.btn_move);
        btnBack = (ImageView)findViewById(R.id.btn_back);
        tv_ques = (TextView)findViewById(R.id.tv_ques);
        btnTrue = (Button)findViewById(R.id.btn_true);
        btnFalse = (Button)findViewById(R.id.btn_false);

        btnMove.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                updateQuestion();
                return false;
            }
        });

        btnBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                returnQuestion();
                return false;
            }
        });

        btnTrue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

               btnTrue.setBackgroundColor(Color.rgb(54, 69, 79));

                if(mAnswer == true) {
                    mScore++;
                    updateScore(mScore);

                    //perform check before you update the question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        MainActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        MainActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });




        //Logic for false button
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnTrue.setBackgroundColor(Color.rgb(54, 69, 79));

                if(mAnswer == false) {
                    mScore++;
                    updateScore(mScore);

                    //perform check before you update the question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        MainActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(MainActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        MainActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }

        });
        /*btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
*/

    }


    private void updateQuestion() {

        tv_ques.setText(QuizBook.questions[mQuestionNumber]);
        mAnswer = QuizBook.answers[mQuestionNumber];
        mQuestionNumber++;
        btnTrue.setBackgroundColor(Color.rgb( 128, 0, 128));
    }
    private void returnQuestion() {
        tv_ques.setText(QuizBook.questions[mQuestionNumber]);
        mAnswer = QuizBook.answers[mQuestionNumber];
        mQuestionNumber--;
    }


    private void updateScore(int point) {

    }
/*
    public void clickExit(View view) {
        askToClose();
    }*/


   /* @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose (){
        AlertDialog.Builder builder = new AlertDialog.Builder(ResultActivity.this);
        builder.setMessage("Are you sure you want to quit?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();*/
}

