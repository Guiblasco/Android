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

public class Productes extends MainActivity {
    AdaptadorProductes adapta;
    ArrayList <Producte> llista;
    ListView lv1;
    DatabaseReference myref;
    FirebaseDatabase  database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);


        database = FirebaseDatabase.getInstance();

        myref = database.getReference("Productes");
        llista =  new ArrayList<>();
        lv1 = findViewById(R.id.lv1);

        carregarLista();


    }

    private void carregarLista() {
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){

                    for (DataSnapshot producteSnapshot : snapshot.getChildren()) {

                        String nom = producteSnapshot.child("nom").getValue().toString();
                        String quan = producteSnapshot.child("quantitat").getValue().toString();
                        String url = producteSnapshot.child("foto").getValue().toString();
                        int quantitat = Integer.parseInt(quan);
                        Producte producte = new Producte(nom,url, quantitat);
                        Log.e("producte","nom" + producte.nom);
                        llista.add(producte);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        adapta();




    }
    public void adapta(){

        adapta = new AdaptadorProductes(this,llista);
        lv1.setAdapter(adapta);
    }

}
