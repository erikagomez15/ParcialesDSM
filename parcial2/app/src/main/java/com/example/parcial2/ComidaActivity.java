package com.example.parcial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.parcial2.Adapters.AdapterComida;
import com.example.parcial2.model.Comida;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ComidaActivity extends AppCompatActivity {


    ArrayList<Comida> listComida;
    RecyclerView recycler;
    AdapterComida adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);

        recycler = (RecyclerView) findViewById(R.id.contenedorcomida);

        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        listComida = new ArrayList<Comida>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapter = new AdapterComida(listComida);
        recycler.setAdapter(adapter);
        database.getReference("Comida").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                listComida.removeAll(listComida);
                for (DataSnapshot snapshot : datasnapshot.getChildren()){
                    Comida c = snapshot.getValue(Comida.class);
                    listComida.add(c);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }




}