package com.example.listacompra;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.productes) {
            Intent intent = new Intent(this, Productes.class);
            startActivity(intent);
        }
        if (id == R.id.producteNou) {
            Intent intent = new Intent(this, NewProduct.class);
            startActivity(intent);
        }
        if (id == R.id.carrito) {
            Intent intent = new Intent(this, Carrito.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}