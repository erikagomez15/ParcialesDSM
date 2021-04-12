package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial2.model.Comida;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    EditText edtnombre, edtprecio,edtdescripcion;

FirebaseDatabase firebasedatabase;
DatabaseReference databasereference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnombre = findViewById(R.id.editTextnombre);
        edtdescripcion = findViewById(R.id.editTextdescripcion);
        edtprecio = findViewById(R.id.editTextprecio);

        inicializarFirebase();
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebasedatabase = FirebaseDatabase.getInstance();
        databasereference = firebasedatabase.getReference();
    }

    public void Guardar(View v){
        String nombre = edtnombre.getText().toString();
        String descripcion = edtdescripcion.getText().toString();
        Double precio = Double.parseDouble(edtprecio.getText().toString());

        Comida c = new Comida();
        c.setKey(UUID.randomUUID().toString());
        c.setNombre(nombre);
        c.setDescripcion(descripcion);
        c.setPrecio(precio);
        c.setUrl("");

        databasereference.child("Bebida").child(c.getKey()).setValue(c);
        Toast.makeText(this,"Agregado",Toast.LENGTH_LONG).show();
    }
}