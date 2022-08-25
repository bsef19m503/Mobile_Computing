package com.noman.customizedlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> daysList = new ArrayList<String>(
            Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
    int pics[] = {R.drawable.calender, R.drawable.calender, R.drawable.calender, R.drawable.calender, R.drawable.calender, R.drawable.calender, R.drawable.calender};
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.daysListView);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.dayView, daysList);
//        listView.setAdapter(arrayAdapter);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), daysList, pics);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You clicked " + daysList.get(i) + ".", Toast.LENGTH_SHORT).show();
            }
        });

    }
}