package com.example.a1918002_tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyWorker db;
    private String Sid, Snama, Swilayah;
    private EditText Enama, Ewilayah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyWorker(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Swilayah = i.getStringExtra("Iwilayah");
        Enama = (EditText) findViewById(R.id.updel_negara);
        Ewilayah = (EditText) findViewById(R.id.updel_wilayah);
        Enama.setText(Snama);
        Ewilayah.setText(Swilayah);
        Button btnUpdate = (Button) findViewById(R.id.btn_ubah);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Swilayah = String.valueOf(Ewilayah.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama tumbuhan", Toast.LENGTH_SHORT).show();
                } else if (Swilayah.equals("")){
                    Ewilayah.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga tumbuhan", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateTumbuhan(new Negara(Sid, Snama, Swilayah));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_hapus);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {db.DeleteTumbuhan(new Negara(Sid, Snama, Swilayah));
                Toast.makeText(MainUpdel.this, "Data telah tumbuhan dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

