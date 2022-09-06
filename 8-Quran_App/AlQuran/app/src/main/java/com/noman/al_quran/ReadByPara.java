package com.noman.al_quran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ReadByPara extends AppCompatActivity {

    int[] ParaList = new int[30];
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_by_para);
        for(int i=0;i<30;i++) {
            ParaList[i] = i+1;
        }

        listView = findViewById(R.id.paralist_listview);
        ReadByParaAdapter readByParaAdapter = new ReadByParaAdapter(getApplicationContext(), ReadByPara.this, ParaList);

        listView.setAdapter(readByParaAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ReadByPara.this, "Clicked " + (i+1) + "th", Toast.LENGTH_SHORT).show();
                Intent intent =  new Intent(ReadByPara.this, ReadPara.class);
                intent.putExtra("ParaID", i+1);
                startActivity(intent);
            }
        });

    }
}