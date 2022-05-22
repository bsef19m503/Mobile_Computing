package com.noman.mobile_computing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLessons(View view) {
        Intent intent = new Intent(this, AlphabetsActivity.class);
        startActivity(intent);
    }
    public void goToQuiz(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
    public void goToRepo(View view) {
        String link = "https://github.com/bsef19m503/Mobile_Computing";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }


}