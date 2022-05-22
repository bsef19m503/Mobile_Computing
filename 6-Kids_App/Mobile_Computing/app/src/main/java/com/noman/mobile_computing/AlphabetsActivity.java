package com.noman.mobile_computing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlphabetsActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);

    }
    public void goToDetails(View view) {
        btn = (Button) view;
        String alphabet = btn.getText().toString();
        Intent intent = new Intent(this, LessonActivity.class);
        intent.putExtra("alphabet", alphabet);
        startActivity(intent);
    }

}