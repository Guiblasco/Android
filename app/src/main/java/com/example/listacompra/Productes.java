package com.example.listacompra;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Productes extends MainMenu {
        ListView lv1;
        List<Producte> llistaProductes;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_view);

            llistaProductes =new ArrayList<>();
            Bundle b = this.getIntent().getExtras();
            if(b!=null)   llistaProductes = b.getParcelable("products");

            Log.d ("AAA", "Productes class. Num. productes = " + llistaProductes.size() );

            lv1 = (ListView) findViewById(R.id.lv1);

            for( int i = 0; i < llistaProductes.size(); i++) {
                Log.d ("AAA", "Productes noms = " + llistaProductes.get(i).getNomProducte());
            }

            Log.d ("AAA", "Productes class fi" );


           // lv1.setAdapter(new CustomArrayAdapter(getApplicationContext(), llistaProductes));
        }

    }


