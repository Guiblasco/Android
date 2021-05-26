package com.example.listacompra;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MainMenu {

    FirebaseDatabase database;
    DatabaseReference myRef ;
    static List<Producte> llistaProductes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Carreguem la llista de productes al principi
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Productes");

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Productes");

        Log.d ("AAA", "database.getReference");
        llistaProductes =  new ArrayList<>();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("AAA", "onDataChange");

                for (DataSnapshot producteSnapshot : snapshot.getChildren()) {
                    String nom = producteSnapshot.child("nom").getValue().toString();
                    String quan = producteSnapshot.child("quantitat").getValue().toString();
                    String url = producteSnapshot.child("foto").getValue().toString();
                    int quantitat = Integer.parseInt(quan);

                    Log.d("AAA", "Nom = " + nom);
                    Producte producte = new Producte(nom, url, quantitat);
                    llistaProductes.add(producte);
                }


                for(Producte producte : llistaProductes) {
                    Log.d ("AAA", "MainActivity noms = " + producte.getNomProducte());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void OnclickProductes(View view){

        Log.d ("AAA", "Num. productes = " + llistaProductes.size());
        Intent i = new Intent(this, Productes.class);

        Bundle b = new Bundle();
        b.putParcelableArrayList("products",(ArrayList<? extends Parcelable>) llistaProductes);
        i.putExtras(b);
        // startActivity(i);
    }
    public void OnclickNewProduct(View view){
        Intent i = new Intent(this, NewProduct.class);
        startActivity(i);
    }
    public void OnclickCarrito(View view){
        Intent i = new Intent(this,Carrito.class);
        startActivity(i);
    }
}