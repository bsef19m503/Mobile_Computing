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

    ArrayList<String> studentNames = new ArrayList<String>(
            Arrays.asList("Umar", "Ali", "Usman"));
    ArrayList<String> studentIDs = new ArrayList<String>(
            Arrays.asList("1", "2", "3"));
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
//      ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.dayView, daysList);
        SingleRecordAdapter singleRecordAdapter = new SingleRecordAdapter(getApplicationContext(), MainActivity.this, studentNames, studentIDs, studentsList);
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
                Date date = new Date();
                studentIDs.add((idInput.getText().toString()));
                studentNames.add((nameInput.getText().toString()));
                StudentModel studentModel = new StudentModel("", idInput.getText().toString(), nameInput.getText().toString(), "" + date.getTime());
                Toast.makeText(MainActivity.this, studentModel.getReg_no()+" | "+studentModel.getName()+" | "+studentModel.getCreated_at(), Toast.LENGTH_SHORT).show();
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