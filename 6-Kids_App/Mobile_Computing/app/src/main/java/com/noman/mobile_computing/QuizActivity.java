package com.noman.mobile_computing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private ImageView[] imageViews;
    private ImageView image;
    private TextView scoreBox;
    private TextView[] questions;
    private String[] questionsTexts;
    private Button submitBtn;
    private RadioButton selectedButton;
    private RadioButton rightButton;
    private RadioButton radioButton;
    private RadioGroup[] radioGroups;
    private int[] images;
    private String[][] optionsTexts;
    private RadioButton[][] options;
    private int[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Initialization();
        setQuiz();
    }


    private void setQuiz() {
        for (int i = 0; i < 5; i++) {
            questions[i].setText(questionsTexts[i]);
            imageViews[i].setImageResource(images[i]);
            for (int j = 0; j < 4; j++) {
                options[i][j].setText(optionsTexts[i][j]);
            }
        }
    }

    private void Initialization() {
         imageViews = new ImageView[] {
                 findViewById(R.id.image1),
                 findViewById(R.id.image2),
                 findViewById(R.id.image3),
                 findViewById(R.id.image4),
                 findViewById(R.id.image5)
         };
         images = new int[]{ R.drawable.c1, R.drawable.a4, R.drawable.b2, R.drawable.c4, R.drawable.a1 };
         questions = new TextView[] {
                 findViewById(R.id.question1),
                 findViewById(R.id.question2),
                 findViewById(R.id.question3),
                 findViewById(R.id.question4),
                 findViewById(R.id.question5)
         };
         questionsTexts = new String[] {
                 "Q1: The name of the following object starts with:",
                 "Q2: The name of the following object starts with:",
                 "Q3: The name of the following object starts with:",
                 "Q4: The name of the following object starts with:",
                 "Q5: The name of the following object starts with:"
         };
         options = new RadioButton[][] {
                 {findViewById(R.id.q1_option1), findViewById(R.id.q1_option2), findViewById(R.id.q1_option3), findViewById(R.id.q1_option4)},
                 {findViewById(R.id.q2_option1), findViewById(R.id.q2_option2), findViewById(R.id.q2_option3), findViewById(R.id.q2_option4)},
                 {findViewById(R.id.q3_option1), findViewById(R.id.q3_option2), findViewById(R.id.q3_option3), findViewById(R.id.q3_option4)},
                 {findViewById(R.id.q4_option1), findViewById(R.id.q4_option2), findViewById(R.id.q4_option3), findViewById(R.id.q4_option4)},
                 {findViewById(R.id.q5_option1), findViewById(R.id.q5_option2), findViewById(R.id.q5_option3), findViewById(R.id.q5_option4)},
         };
         optionsTexts = new String[][] {
                 {"D","B","C","A"},
                 {"D","B","C","A"},
                 {"D","B","C","A"},
                 {"D","B","C","A"},
                 {"D","B","C","A"}         };
         answers = new int[] {
                 R.id.q1_option3,
                 R.id.q2_option4,
                 R.id.q3_option2,
                 R.id.q4_option3,
                 R.id.q5_option4
         };
         radioGroups = new RadioGroup[] {
                 findViewById(R.id.answer1),
                 findViewById(R.id.answer2),
                 findViewById(R.id.answer3),
                 findViewById(R.id.answer4),
                 findViewById(R.id.answer5)
         };
        }

        @SuppressLint("ResourceAsColor")
        public void gradeQuiz(View view) {
            int score = 0;
            for (int i = 0; i < 5; i++) {
                if(radioGroups[i].getCheckedRadioButtonId() == answers[i]) {
                    score++;
                }
//                one other approach
//                if(radioGroups[i].getCheckedRadioButtonId() == -1) {
//                    radioButton = findViewById(answers[i]);
//                    radioButton.setBackgroundColor(R.color.purple_700);
//                } else if(radioGroups[i].getCheckedRadioButtonId() == answers[i]) {
//                    radioButton = findViewById(answers[i]);
//                    radioButton.setBackgroundColor(R.color.red);
//                } else if(radioGroups[i].getCheckedRadioButtonId() != answers[i]) {
//                    radioButton = findViewById(answers[i]);
//                    radioButton.setBackgroundColor(R.color.red);
//                    radioButton = findViewById(radioGroups[i].getCheckedRadioButtonId());
//                    radioButton.setBackgroundColor(R.color.red);
//                }
            }
            scoreBox = findViewById(R.id.scoreBox);
            scoreBox.setText("Your Score: " + Integer.toString(score));
            submitBtn = findViewById(R.id.submitBtn);
            submitBtn.setEnabled(false);
            }

}