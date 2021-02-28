package com.example.ejercicio2parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText EditVotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditVotos = (EditText)findViewById(R.id.txtvotos);
    }

    public void EnvioDeVotos(View v){
        Intent i = new Intent(this,ResumenVotos.class);
        i.putExtra("txtvotos",EditVotos.getText().toString());
        startActivity(i);
    }
}