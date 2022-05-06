package com.noman.mc01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view) {
        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.poundsValue);

        int kgs = Integer.parseInt(editText.getText().toString());
        textView.setText(String.format("%.2f", kgs*2.20)); // Double.toString(kgs*2.20)
    }
}