package com.example.parcial2.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.parcial2.DetalleActivity;
import com.example.parcial2.DetalleBebidaActivity;
import com.example.parcial2.R;
import com.example.parcial2.model.Bebida;

import java.util.ArrayList;
import java.util.Deque;

public class AdapterBebida extends RecyclerView.Adapter<AdapterBebida.ViewHolderBebida> {
    ArrayList<Bebida> listBebida;
    public AdapterBebida(ArrayList<Bebida> listBebida){this.listBebida = listBebida;}

    @Override
    public ViewHolderBebida onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productos,null,false);
        return new ViewHolderBebida(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderBebida holder, int position){
        holder.asignarDatos(listBebida.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetalleBebidaActivity.class);
                intent.putExtra("itemb",listBebida.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return listBebida.size();
    }

    public class ViewHolderBebida extends RecyclerView.ViewHolder{
        TextView nombre, descripcion,precio;
        CheckBox agregado;
        ImageView miniatura;

        public ViewHolderBebida(View itemView){
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.txtnombre);
            descripcion = (TextView) itemView.findViewById(R.id.txtdescripcion);
            precio = (TextView) itemView.findViewById(R.id.txtcosto);
            miniatura = (ImageView) itemView.findViewById(R.id.imagen);
        }

        public void asignarDatos(Bebida b){

            nombre.setText(b.getNombre());
            descripcion.setText(b.getDescripcion());
            precio.setText("$ " + String.valueOf(b.getPrecio()));
            Glide.with(this.itemView).load(b.getUrl()).into(miniatura);
        }
    }

}
