package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuActivity extends AppCompatActivity {
    private Button salirBtn;
    private FirebaseAuth mAuth;
    private TextView txtid, txtcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAuth = FirebaseAuth.getInstance();
        salirBtn = findViewById(R.id.btnSalir);


        txtcorreo=findViewById(R.id.correo);
        FirebaseUser currentUser = mAuth.getCurrentUser();



        txtcorreo.setText(currentUser.getEmail());




        salirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {signOut();
            }
        });
    }
    private void signOut(){
        mAuth.signOut();
        finish();
    }


    public void VentanaBebida(View view) {
        Intent intent = new Intent(getBaseContext(),BebidaActivity.class);
        startActivity(intent);
    }

    public void VentanaComida(View view) {
        Intent intent = new Intent(getBaseContext(),ComidaActivity.class);
        startActivity(intent);
    }
}