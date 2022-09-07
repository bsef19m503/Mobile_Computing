package com.noman.mobile_computing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class AlphabetsActivity extends AppCompatActivity {

    private Button btn;
    private String[] alphabets = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);

        ListView listView = findViewById(R.id.alphabets_listview);
        ArrayAdapter alphabetsArrayAdapter = new ArrayAdapter(this, R.layout.alphabets_listview, R.id.lessonBtn, alphabets);
        listView.setAdapter(alphabetsArrayAdapter);
    }
    public void goToDetails(View view) {
        btn = (Button) view;
        String alphabet = btn.getText().toString();
        Intent intent = new Intent(this, LessonActivity.class);
        intent.putExtra("alphabet", alphabet);
        startActivity(intent);
    }

}