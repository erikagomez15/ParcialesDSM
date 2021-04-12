package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.parcial2.model.Articulo;
import com.example.parcial2.model.Bebida;
import com.example.parcial2.model.Comida;

import java.util.ArrayList;

public class DetalleBebidaActivity extends AppCompatActivity {
    TextView tvnombre,tvdescripcion,tvprecio, tvcantidad;
    ImageView imagendetalle;
    private Bebida b;
    ArrayList<Articulo> articulos;
    Articulo itemOrden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_bebida);

        tvnombre = (TextView) findViewById(R.id.txtdetallenombreb);
        tvdescripcion = (TextView) findViewById(R.id.txtdetalledescripcionb);
        tvprecio = (TextView) findViewById(R.id.txtdetallepreciob);
        imagendetalle = (ImageView)findViewById(R.id.imagendetalleb);
        tvcantidad = (TextView) findViewById(R.id.txtdetallecantidadb);

        b = (Bebida) getIntent().getExtras().getSerializable("itemb");
        tvnombre.setText(b.getNombre());
        tvdescripcion.setText(b.getDescripcion());
        tvprecio.setText("$ "+String.valueOf(b.getPrecio()));
        Glide.with(this).load(b.getUrl()).into(imagendetalle);

        articulos = new ArrayList<Articulo>();
    }

    public void guardaritembebida(View view){
        itemOrden = new Articulo();
        itemOrden.setNombre(b.getNombre());
        itemOrden.setPrecio(b.getPrecio());
        itemOrden.setCantidad(Integer.parseInt(tvcantidad.getText().toString()));
        Double subtotal = Integer.parseInt(tvcantidad.getText().toString())*b.getPrecio();
        itemOrden.setSubtotal(subtotal);
        articulos.add(itemOrden);
        Toast.makeText(DetalleBebidaActivity.this,"Producto agregado",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getBaseContext(),OrdenActivity.class);
        intent.putExtra("item",itemOrden);
        startActivity(intent);
    }
}