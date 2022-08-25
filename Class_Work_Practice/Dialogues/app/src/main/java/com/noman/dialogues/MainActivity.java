package com.noman.dialogues;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> studentNames = new ArrayList<String>(
            Arrays.asList("Breakfast", "Lunch", "Dinner"));
    ArrayList<String> studentIDs = new ArrayList<String>(
            Arrays.asList("1", "2", "3"));

    ListView listView;

//    ImageButton updateBtn;
//    ImageButton deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.recordView);
//        updateBtn = (ImageButton) listView.getChildAt(R.id.updateBtn);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.dayView, daysList);
//        listView.setAdapter(arrayAdapter);
        SingleRecordAdapter singleRecordAdapter = new SingleRecordAdapter(getApplicationContext(), MainActivity.this, studentNames, studentIDs);
        listView.setAdapter(singleRecordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "chal gyaaa", Toast.LENGTH_SHORT).show();
            }
        });

//        Button btn = findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                deleteDialog();
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Confirm");
//                builder.setMessage("Are you sure you want to delete this?");
//
//                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
////                        studentNames.remove(i);
////                        studentIDs.remove(i);
////                        notifyDataSetChanged();
//                        dialogInterface.dismiss();
//                    }
//                });
//
//                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                });
//
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//            }
//        });
    }
}