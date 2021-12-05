package com.example.a1918002_tugas7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyWorker extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_bendera";
    private static final String tb_negara = "tb_negara";
    private static final String tb_negara_id = "id";
    private static final String tb_negara_nama = "nama";
    private static final String tb_negara_wilayah = "wilayah";
    private static final String CREATE_TABLE_NEGARA = "CREATE TABLE "
            + tb_negara +"("
            + tb_negara_id + " INTEGER PRIMARY KEY ,"
            + tb_negara_nama + " TEXT ,"
            + tb_negara_wilayah + " TEXT " + ")";
    public MyWorker(Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    public MyWorker(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NEGARA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateTumbuhan(Negara data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_negara_id, data.get_id());
        values.put(tb_negara_nama, data.get_nama());
        values.put(tb_negara_wilayah, data.get_wilayah());
        db.insert(tb_negara, null, values);
        db.close();
    }
    public List<Negara> ReadNegara() {
        List<Negara> listMhs = new ArrayList<Negara>();
        String selectQuery = "SELECT * FROM " + tb_negara;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Negara data = new Negara();
                data.set_id(((Cursor) cursor).getString(0));
                data.set_nama(cursor.getString(1));
                data.set_wilayah(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateTumbuhan (Negara data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_negara_nama, data.get_nama());
        values.put(tb_negara_wilayah, data.get_wilayah());
        return db.update(tb_negara, values, tb_negara_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteTumbuhan(Negara data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_negara,tb_negara_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
