package sv.edu.udb.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etb;
    private EditText eta;
    private EditText etc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etb =(EditText)findViewById(R.id.txtb);
        eta =(EditText)findViewById(R.id.txta);
        etc =(EditText)findViewById(R.id.txtc);

    }

    public void segundaactividad (View v){
        Intent i = new Intent( this, segundaactividad.class);
        i.putExtra( "txtb", etb.getText().toString());
        i.putExtra("txta", eta.getText().toString());
        i.putExtra("txtc", etc.getText().toString());
        startActivity(i);

    }
}