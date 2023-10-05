package com.example.spdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtMsg;
    TextView txtMsg;
    Button btnSave, btnClear, btnShow;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMsg = findViewById(R.id.edtMsg);
        txtMsg = findViewById(R.id.txtMsg);
        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);
        btnShow = findViewById(R.id.btnShow);

        SharedPreferences preferences = getSharedPreferences("kishan",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("msg", edtMsg.getText().toString());
                editor.apply();

                Toast.makeText(MainActivity.this, "save data", Toast.LENGTH_SHORT).show();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("kishan",MODE_PRIVATE);
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity.this, "clear data", Toast.LENGTH_SHORT).show();

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("kishan",MODE_PRIVATE);
                 String ss = preferences.getString("msg","");
                 if(ss.isEmpty()){
                     txtMsg.setText("First Save Your Data");
                 }else{

                     txtMsg.setText(ss.toString());
                 }

            }
        });


    }
}