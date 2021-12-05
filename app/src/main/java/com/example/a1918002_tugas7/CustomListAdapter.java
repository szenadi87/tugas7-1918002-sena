package com.example.a1918002_tugas7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Negara> Negara;
    public CustomListAdapter(Activity activity, List<Negara> Negara) {
        this.activity = activity;
        this.Negara = Negara;
    }
    @Override
    public int getCount() {
        return Negara.size();
    }
    @Override
    public Object getItem(int location) {
        return Negara.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView kelas = (TextView)
                convertView.findViewById(R.id.text_wilayah);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Negara t = Negara.get(position);
        nama.setText("Nama Negara : "+ t.get_nama());
        kelas.setText("Wilayah : "+ t.get_wilayah());
        return convertView;
    }
}

