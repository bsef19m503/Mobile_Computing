package com.noman.dialogues;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> studentNames = new ArrayList<String>(
            Arrays.asList("Umar", "Ali", "Usman"));
    ArrayList<String> studentIDs = new ArrayList<String>(
            Arrays.asList("1", "2", "3"));

    ListView listView;

    Button addBtn;
    Button viewAllBtn;

    EditText idInput;
    EditText nameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.recordView);
//      ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.dayView, daysList);
        SingleRecordAdapter singleRecordAdapter = new SingleRecordAdapter(getApplicationContext(), MainActivity.this, studentNames, studentIDs);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "list item clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idInput = findViewById(R.id.idInput);
                nameInput = findViewById(R.id.nameInput);
                studentIDs.add((idInput.getText().toString()));
                studentNames.add((nameInput.getText().toString()));
                singleRecordAdapter.notifyDataSetChanged();
                idInput.setText("");
                nameInput.setText("");
            }
        });

        viewAllBtn = findViewById(R.id.viewAllBtn);
        viewAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(singleRecordAdapter);

            }
        });




    }
}