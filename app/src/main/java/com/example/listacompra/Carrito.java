package com.example.listacompra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Carrito extends MainMenu {
    public class ProducteCarrito {
        String nom;
        String unitats;

        public ProducteCarrito(String nom, String unitats) {
            this.nom = nom;
            this.unitats = unitats;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
    }
}
//puds



