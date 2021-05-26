package com.example.listacompra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;



public class AdaptadorProductes extends BaseAdapter {
    Context context;
    ArrayList <Producte> compra = new ArrayList<>();

    public AdaptadorProductes(Context context, ArrayList<Producte> compra) {
        this.context = context;
        this.compra = compra;
    }


    @Override
    public int getCount() {
        return compra.size();
    }

    @Override
    public Object getItem(int position) {
        return compra.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.listview_row, null);
        Producte item = (Producte) getItem(position);

        ImageView imgProduct = (ImageView) convertView.findViewById(R.id.producte_avatar);
        Glide.with(context).load(item.getFoto()).into(imgProduct);

        TextView nameProduct = (TextView) convertView.findViewById(R.id.producte_nom);
        nameProduct.setText(item.getNomProducte());

        return convertView;

    }
}