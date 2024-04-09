package com.midterm.levankiet;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultActivity extends AppCompatActivity{
    TextView mFinalScore;
     private ListView lvQues;
     private ArrayList<String> arrayList;
     private ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        mFinalScore = (TextView)findViewById(R.id.grade);
        lvQues = (ListView)findViewById(R.id.lv_ques);
        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        lvQues.setAdapter(arrayAdapter);

        arrayList.add(Arrays.toString((QuizBook.questions)));
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");
        mFinalScore.setText("Score:" + score + " / " + QuizBook.questions.length);


        };
}
