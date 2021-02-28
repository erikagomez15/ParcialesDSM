package com.example.ejercicio2parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResumenVotos extends AppCompatActivity {

    private TextView tvVoto1, tvVoto2, tvVoto3,tvVoto4;
    private TextView tvPorcentaje1, tvPorcentaje2, tvPorcentaje3, tvPorcentaje4;
    private String[] ArregloVotos;
    private String votos;
    private int Numero=0, contador1 = 0, contador2 = 0, contador3 = 0, contador4 = 0;
    private double porcentaje1,porcentaje2,porcentaje3,porcentaje4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_votos);
        tvVoto1 =(TextView)findViewById(R.id.voto1);
        tvVoto2 =(TextView)findViewById(R.id.voto2);
        tvVoto3 =(TextView)findViewById(R.id.voto3);
        tvVoto4 =(TextView)findViewById(R.id.voto4);
        tvPorcentaje1 = (TextView)findViewById(R.id.porcentaje1);
        tvPorcentaje2 = (TextView)findViewById(R.id.porcentaje2);
        tvPorcentaje3 = (TextView)findViewById(R.id.porcentaje3);
        tvPorcentaje4 = (TextView)findViewById(R.id.porcentaje4);

        Bundle bundle = getIntent().getExtras();
        votos = bundle.getString("txtvotos");
        ArregloVotos = votos.split(" ");
        Numero = ArregloVotos.length;
        for (int i=0; i<Numero; i++)
        {
            if(ArregloVotos[i].equals("1"))contador1++;
            else if(ArregloVotos[i].equals("2"))contador2++;
            else if(ArregloVotos[i].equals("3"))contador3++;
            else contador4++;
        }
        porcentaje1 = (contador1*100)/Numero;
        porcentaje2 = (contador2*100)/Numero;
        porcentaje3 = (contador3*100)/Numero;
        porcentaje4 = (contador4*100)/Numero;

        tvVoto1.setText(String.valueOf(contador1));
        tvVoto2.setText(String.valueOf(contador2));
        tvVoto3.setText(String.valueOf(contador3));
        tvVoto4.setText(String.valueOf(contador4));
        tvPorcentaje1.setText(String.valueOf(porcentaje1)+"%");
        tvPorcentaje2.setText(String.valueOf(porcentaje2)+"%");
        tvPorcentaje3.setText(String.valueOf(porcentaje3)+"%");
        tvPorcentaje4.setText(String.valueOf(porcentaje4)+"%");

    }

}