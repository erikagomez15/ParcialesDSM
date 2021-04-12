package com.example.parcial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.parcial2.Adapters.AdapterBebida;
import com.example.parcial2.model.Bebida;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BebidaActivity extends AppCompatActivity {

    ArrayList<Bebida> listBebida;
    RecyclerView recycler;
    AdapterBebida adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebida);

        recycler = (RecyclerView) findViewById(R.id.contenedorbebida);

        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        listBebida = new ArrayList<Bebida>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapter = new AdapterBebida(listBebida);
        recycler.setAdapter(adapter);
        database.getReference("Bebida").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                listBebida.removeAll(listBebida);
                for (DataSnapshot snapshot : datasnapshot.getChildren()){
                    Bebida b = snapshot.getValue(Bebida.class);
                    listBebida.add(b);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}