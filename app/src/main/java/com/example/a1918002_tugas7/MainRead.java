package com.example.a1918002_tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyWorker db;
    private List<Negara> ListNegara = new ArrayList<Negara>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyWorker(this);
        adapter_off = new CustomListAdapter(this, ListNegara);
        mListView = (ListView) findViewById(R.id.list_Negara);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListNegara.clear();
        List<Negara> negara = db.ReadNegara();
        for (Negara tmh : negara) {
            Negara daftar = new Negara();
            daftar.set_id(tmh.get_id());
            daftar.set_nama(tmh.get_nama());
            daftar.set_wilayah(tmh.get_wilayah());
            ListNegara.add(daftar);
            if ((ListNegara.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Negara detailTmh = (Negara) o;
        String Sid = detailTmh.get_id();
        String Snama = detailTmh.get_nama();
        String Swilayah = detailTmh.get_wilayah();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iwilayah", Swilayah);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListNegara.clear();
        mListView.setAdapter(adapter_off);
        List<Negara> negara = db.ReadNegara();
        for (Negara tmh : negara) {
            Negara daftar = new Negara();
            daftar.set_id(tmh.get_id());
            daftar.set_nama(tmh.get_nama());
            daftar.set_wilayah(tmh.get_wilayah());
            ListNegara.add(daftar);
            if ((ListNegara.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}


