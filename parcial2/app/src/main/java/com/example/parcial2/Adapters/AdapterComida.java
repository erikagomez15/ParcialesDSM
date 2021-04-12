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
import com.example.parcial2.ComidaActivity;
import com.example.parcial2.DetalleActivity;
import com.example.parcial2.R;
import com.example.parcial2.model.Comida;
import java.util.ArrayList;

public class AdapterComida extends RecyclerView.Adapter<AdapterComida.ViewHolderComida> {

    ArrayList<Comida> listComida;
    public AdapterComida(ArrayList<Comida> listcomida){
        this.listComida = listcomida;
    }

    @Override
    public ViewHolderComida onCreateViewHolder(ViewGroup parent, int viewType){
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productos,null,false);
       return new ViewHolderComida(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderComida holder, int position){
        holder.asignarDatos(listComida.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetalleActivity.class);
                intent.putExtra("item",listComida.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return listComida.size();
    }

    public class ViewHolderComida extends RecyclerView.ViewHolder{
        TextView nombre, descripcion,precio;
        ImageView miniatura;

        public ViewHolderComida(View itemView){
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.txtnombre);
            descripcion = (TextView) itemView.findViewById(R.id.txtdescripcion);
            precio = (TextView) itemView.findViewById(R.id.txtcosto);
            miniatura = (ImageView) itemView.findViewById(R.id.imagen);
        }

        public void asignarDatos(Comida c){

            nombre.setText(c.getNombre());
            descripcion.setText(c.getDescripcion());
            precio.setText("$ "+String.valueOf(c.getPrecio()));
            Glide.with(this.itemView).load(c.getUrl()).into(miniatura);

        }
    }
}
