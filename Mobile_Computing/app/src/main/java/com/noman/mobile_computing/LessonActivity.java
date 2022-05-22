package com.noman.mobile_computing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LessonActivity extends AppCompatActivity {

    private int[] imageViews;
    private ImageView imageView;
    private int[] textViews;
    private TextView textView;

    private int[][] images;
    private String[][] names;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        imageViews = new int[]{ R.id.imageView1, R.id.imageView2, R.id.imageView3, R.id.imageView4 };
        textViews = new int[]{ R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4 };


        images = new int[26][4];
        names = new String[26][4];
        images[0][0] = R.drawable.a1;
        images[0][1] = R.drawable.a2;
        images[0][2] = R.drawable.a3;
        images[0][3] = R.drawable.a4;
        names[0][0] = "Apple";
        names[0][1] = "Airplane";
        names[0][2] = "Alligator";
        names[0][3] = "Aunt-Ant";

        if(getIntent() != null && getIntent().hasExtra("alphabet")) {
            index = getIntent().getStringExtra("alphabet").charAt(0) - 65;
            for(int i=0;i<4;i++) {
               imageView = findViewById(imageViews[i]);
               imageView.setImageResource(images[index][i]);
               textView = findViewById(textViews[i]);
               textView.setText(names[index][i]);
            }
        }
    }
}