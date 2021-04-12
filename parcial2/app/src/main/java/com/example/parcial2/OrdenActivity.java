package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.parcial2.Adapters.AdapterOrden;
import com.example.parcial2.model.Articulo;
import com.example.parcial2.model.Orden;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class OrdenActivity extends AppCompatActivity {
    ArrayList<Articulo> listArticulo;
    Articulo item;
    TextView tvnombre, tvcosto,tvsubtotal, tvcantidad, tvtotal;
    RecyclerView recycler;
    AdapterOrden adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);

        tvnombre = (TextView)findViewById(R.id.txtOrdenNombre);
        tvcantidad = (TextView) findViewById(R.id.txtOrdenCantidad);
        tvcosto = (TextView) findViewById(R.id.txtOrdenPrecio);
        tvsubtotal =(TextView) findViewById(R.id.txtOrdenSubtotal);
        tvtotal = (TextView)findViewById(R.id.txtOrdenTotal);

        recycler = (RecyclerView) findViewById(R.id.recyclercomida);

        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        listArticulo = new ArrayList<Articulo>();
        item = (Articulo) getIntent().getExtras().getSerializable("item");
        adapter = new AdapterOrden(listArticulo);
        recycler.setAdapter(adapter);
        listArticulo.add(item);
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void GuardarOrden(View view) {

        String nombre = tvnombre.getText().toString();
        Double precio = Double.parseDouble(tvcosto.getText().toString());
        int cantidad = Integer.parseInt(tvcantidad.getText().toString());
        Double subtotal = Double.parseDouble(tvtotal.getText().toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        Articulo artic = new Articulo();
        artic.setNombre(nombre);
        artic.setCantidad(cantidad);
        artic.setSubtotal(subtotal);
        artic.setPrecio(precio);
        Orden o = new Orden();
        o.setKey(UUID.randomUUID().toString());
        
        o.setTotal(subtotal);
        o.setFecha(dateFormat.format(date));
        o.setArticulos(artic);

        databaseReference.child("Orden").child(o.getKey()).setValue(o);

    }
}