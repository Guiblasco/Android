package com.example.listacompra;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Date;

public class NewProduct extends MainMenu {
    ImageView foto;
    ImageButton openCamera;
    Button pujarProducte;
    Uri uri_img;
    EditText nomProducte;

    private static final int REQUEST_PERMISSION_CAMERA = 100;
    private static final int REQUEST_IMAGE_CAMERA = 101;
    private static final int CODE_GALLERY = 90;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);
        foto = findViewById(R.id.producteNou);
        nomProducte = findViewById(R.id.newNomInput);
        pujarProducte = findViewById(R.id.altaProducte);
        pujarProducte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnclickAlta();
            }
        });
        openCamera = findViewById(R.id.fotoProducte);
        openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                    if(ActivityCompat.checkSelfPermission(NewProduct.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                        OnClickfoto();
                    }else{
                        ActivityCompat.requestPermissions(NewProduct.this,new String[]{Manifest.permission.CAMERA},REQUEST_PERMISSION_CAMERA);
                    }

                }else{
                    OnClickfoto();
                }
            }
        });
    }





    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permision, @NonNull int [] grantResult){
        if(requestCode == REQUEST_PERMISSION_CAMERA){
            if(permision.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED){
                OnClickfoto();
            }else{
                Toast.makeText(this,"Debes darle permisos a la camara",Toast.LENGTH_SHORT).show();
            }

        }
        super.onRequestPermissionsResult(requestCode,permision,grantResult);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {





               if(requestCode == REQUEST_IMAGE_CAMERA && resultCode == RESULT_OK){
                   uri_img = data.getData();
                   try {
                       Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                       foto.setImageBitmap(bitmap);

                   }catch (Exception e){

                   }
                   }


        super.onActivityResult(requestCode, resultCode, data);
    }

    public void OnClickfoto() {
        //obrir la camera i mostrarla en el image view
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(cameraIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(cameraIntent,REQUEST_IMAGE_CAMERA);
        }
    }

    public void OnclickAlta() {
        //donar de alta producte en firebase
        Producte producteNou = new Producte();
        producteNou.setNomProducte(nomProducte.getText().toString());
        producteNou.setQuantitat(0);



        FirebaseDatabase databaseProducte = FirebaseDatabase.getInstance();
        DatabaseReference referenceProducte = databaseProducte.getReference("Productes");
        referenceProducte.push().setValue(producteNou);


    }
}