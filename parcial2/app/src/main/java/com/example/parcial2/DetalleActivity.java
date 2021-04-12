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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity {
    TextView tvnombre,tvdescripcion,tvprecio, tvcantidad;
    ImageView imagendetalle;
    private Comida c;
    ArrayList<Articulo> articulos;
    Articulo itemOrden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        tvnombre = (TextView) findViewById(R.id.txtdetallenombre);
        tvdescripcion = (TextView) findViewById(R.id.txtdetalledescripcion);
        tvprecio = (TextView) findViewById(R.id.txtdetalleprecio);
        imagendetalle = (ImageView)findViewById(R.id.imagendetalle);
        tvcantidad = (TextView) findViewById(R.id.txtdetallecantidad);

        c = (Comida) getIntent().getExtras().getSerializable("item");
        tvnombre.setText(c.getNombre());
        tvdescripcion.setText(c.getDescripcion());
        tvprecio.setText("$ "+String.valueOf(c.getPrecio()));
        Glide.with(this).load(c.getUrl()).into(imagendetalle);

        articulos = new ArrayList<Articulo>();
    }

    public void GuardarItem(View view) {
        itemOrden = new Articulo();
        itemOrden.setNombre(c.getNombre());
        itemOrden.setCantidad(Integer.parseInt(tvcantidad.getText().toString()));
        itemOrden.setPrecio(c.getPrecio());
        Double subs = Integer.parseInt(tvcantidad.getText().toString())*c.getPrecio();
        itemOrden.setSubtotal(subs);
        //articulos.add(itemOrden);
        Toast.makeText(DetalleActivity.this,"Producto agregado",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getBaseContext(),OrdenActivity.class);
        intent.putExtra("item",itemOrden);
        startActivity(intent);
    }
}