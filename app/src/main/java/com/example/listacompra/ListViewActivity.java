package com.example.listacompra;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends MainMenu {

    // La ListViww que mostra els productes
    private ListView listViewProductes;

    List<Producte> llistaProductes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        listViewProductes =  findViewById(android.R.id.list);

        for(Producte producte : MainActivity.llistaProductes) {
            Log.d ("AAA", "ListViewActivity noms = " + producte.getNomProducte());
        }

        listViewProductes.setAdapter(new CustomArrayAdapter(this, MainActivity.llistaProductes));

    }
}