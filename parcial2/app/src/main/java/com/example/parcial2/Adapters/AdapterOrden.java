package com.example.parcial2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.R;
import com.example.parcial2.model.Articulo;

import java.util.ArrayList;
import java.util.List;

public class AdapterOrden extends RecyclerView.Adapter<AdapterOrden.ViewHolderOrden>{
    ArrayList<Articulo> listArticulo;
    public AdapterOrden(ArrayList<Articulo> listArticulo){this.listArticulo = listArticulo;}

    @Override
    public void onBindViewHolder(@NonNull ViewHolderOrden holder, int position) {
        holder.asignarDatos(listArticulo.get(position));
    }

    @NonNull
    @Override
    public ViewHolderOrden onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_lista,null,false);
        return new ViewHolderOrden(view);
    }

    @Override
    public int getItemCount() {
        return listArticulo.size();
    }

    public class ViewHolderOrden extends RecyclerView.ViewHolder{
        TextView nombre, precio,subtotal,cantidad;

        public ViewHolderOrden(View itemView){
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.txtOrdenNombre);
            precio = (TextView) itemView.findViewById(R.id.txtOrdenPrecio);
            cantidad = (TextView) itemView.findViewById(R.id.txtOrdenCantidad);
            subtotal = (TextView) itemView.findViewById(R.id.txtOrdenSubtotal);
        }

        public void asignarDatos(Articulo a){
            nombre.setText(a.getNombre());
            precio.setText(String.valueOf(a.getPrecio()));
            cantidad.setText(String.valueOf(a.getCantidad()));
            subtotal.setText(String.valueOf(a.getSubtotal()));
        }
    }
}
