package com.noman.mobile_computing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private ImageView[] imageViews;
    private ImageView image;
    private RadioButton selectedButton;
    private RadioButton radioButton;
    private RadioGroup[] radioGroups;
    private int[] images;
    private String[][] options;
    private int[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public void gradeQuiz(View view) {

    }

    private void setQuiz() {
        for(int i=0;i<5;i++) {
            imageViews[i].setImageResource(images[i]);
        }

       image = findViewById(R.id.image1);
    }

    private void Initialization() {
         imageViews = new ImageView[] {
                 findViewById(R.id.image1),
                 findViewById(R.id.image2),
                 findViewById(R.id.image3),
                 findViewById(R.id.image4),
                 findViewById(R.id.image5)
         }
         images = new int[]{ R.drawable.c1, R.drawable.a4, R.drawable.b2, R.drawable.c4, R.drawable.a1 };
         optionsTexts = new String[][] {
                 {"D","B","C","A"},
                 {"D","B","C","A"},
                 {"D","B","C","A"},
                 {"D","B","C","A"},
                 {"A","B","C","D"}
         };
         answers = new int[] {
                 R.id.q1_option3,
                 R.id.q2_option1,
                 R.id.q3_option2,
                 R.id.q4_option3,
                 R.id.q5_option1
         };
         radioGroups = new RadioGroup[] {
                 findViewById(R.id.answer1),
                 findViewById(R.id.answer2),
                 findViewById(R.id.answer3),
                 findViewById(R.id.answer4),
                 findViewById(R.id.answer5)
         };
        }
    }
}