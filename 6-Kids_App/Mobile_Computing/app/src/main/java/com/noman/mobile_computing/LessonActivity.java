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


        images = new int[][] {
            {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4},
            {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4},
            {R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4},
            {R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4}
        };
        names = new String[][] {
                {"Apple", "Airplane", "Alligator", "Aunt-Man"},
                {"Bat", "Ball", "Balloon", "Bear"},
                {"Cat", "Cake", "Car", "Crow"},
                {"Duck", "Dog", "Dear", "Dinosaur"}
        };

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