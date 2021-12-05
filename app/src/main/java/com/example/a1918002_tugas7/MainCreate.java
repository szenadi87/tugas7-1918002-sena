package com.example.a1918002_tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyWorker db;
    private EditText Enama, Ewilayah;
    private String Snama, Swilayah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyWorker(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ewilayah = (EditText) findViewById(R.id.create_wilayah);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Swilayah = String.valueOf(Ewilayah.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama negara", Toast.LENGTH_SHORT).show();
                }
                else if (Swilayah.equals("")) {
                    Ewilayah.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi wilayah negara", Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Ewilayah.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateTumbuhan(new Negara(null, Snama, Swilayah));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        }
        );
    }
}


