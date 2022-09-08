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
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    ArrayList<StudentModel> studentsList;
    ListView listView;

    Button addBtn;
    Button viewAllBtn;

    EditText idInput;
    EditText nameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(MainActivity.this);
        studentsList = databaseHelper.getALLStudents();

        listView = findViewById(R.id.recordView);
        SingleRecordAdapter singleRecordAdapter = new SingleRecordAdapter(getApplicationContext(), MainActivity.this, studentsList);

        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idInput = findViewById(R.id.idInput);
                nameInput = findViewById(R.id.nameInput);
                if(idInput.getText().length() == 0 | nameInput.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "ID and Name fields can't be empty.", Toast.LENGTH_SHORT).show();
                    return;
                } else if(!databaseHelper.isIDAvailable(Integer.parseInt(idInput.getText().toString()))) {
                    Toast.makeText(MainActivity.this, "ID already exists. Try another one.", Toast.LENGTH_SHORT).show();
                    return;
                }
//                else {
//                    Log.d("AAAAA", databaseHelper.isIDAvailable(Integer.parseInt(idInput.getText().toString())));
//                }
                Date date = new Date();
                StudentModel studentModel = new StudentModel("", idInput.getText().toString(), nameInput.getText().toString(), "" + date.getTime());
                databaseHelper.addStudent(studentModel);

                singleRecordAdapter.refresh();
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