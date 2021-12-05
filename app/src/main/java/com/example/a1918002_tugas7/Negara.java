package com.example.a1918002_tugas7;

public class Negara {
    private String id, nama, wilayah;
    public Negara (String id, String nama, String wilayah) {
        this.id = id;
        this.nama = nama;
        this.wilayah = wilayah;
    }
    public Negara() {
    }
    public String get_id() {
        return id;
    }
    public void set_id(String _id) {
        this.id = _id;
    }
    public String get_nama() {
        return nama;
    }
    public void set_nama(String _nama) {
        this.nama = _nama;
    }
    public String get_wilayah() {
        return wilayah;
    }
    public void set_wilayah(String wilayah) {
        this.wilayah = wilayah;
    }
}
