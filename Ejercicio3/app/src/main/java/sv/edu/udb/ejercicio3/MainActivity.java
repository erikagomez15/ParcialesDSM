package sv.edu.udb.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombre1;
    private EditText apellido1;
    private EditText cargo1;
    private EditText horas1;

    private EditText nombre2;
    private EditText apellido2;
    private EditText cargo2;
    private EditText horas2;

    private EditText nombre3;
    private EditText apellido3;
    private EditText cargo3;
    private EditText horas3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre1=(EditText)findViewById(R.id.txtn1);
        apellido1=(EditText)findViewById(R.id.txtp1);
        cargo1=(EditText)findViewById(R.id.txtc1);
        horas1=(EditText)findViewById(R.id.txth1);

        nombre2=(EditText)findViewById(R.id.txtn2);
        apellido2=(EditText)findViewById(R.id.txtp2);
        cargo2=(EditText)findViewById(R.id.txtc2);
        horas2=(EditText)findViewById(R.id.txth2);

        nombre3=(EditText)findViewById(R.id.txtn3);
        apellido3=(EditText)findViewById(R.id.txtp3);
        cargo3=(EditText)findViewById(R.id.txtc3);
        horas3=(EditText)findViewById(R.id.txth3);
    }

    public void segundaactividad (View v){

        if(horas1.getText().toString() == "0" || horas2.getText().toString()=="0" || horas3.getText().toString()=="0"){
            Toast notificacion = Toast.makeText(this, "No se aceptan horas igual a cero", Toast.LENGTH_LONG);
            notificacion.show();

       }


        else {
            Intent i = new Intent(this, segundaactividad.class);
            i.putExtra("txtn1", nombre1.getText().toString());
            i.putExtra("txtp1", apellido1.getText().toString());
            i.putExtra("txtc1", cargo1.getText().toString());
            i.putExtra("txth1", horas1.getText().toString());

            i.putExtra("txtn2", nombre2.getText().toString());
            i.putExtra("txtp2", apellido2.getText().toString());
            i.putExtra("txtc2", cargo2.getText().toString());
            i.putExtra("txth2", horas2.getText().toString());

            i.putExtra("txtn3", nombre3.getText().toString());
            i.putExtra("txtp3", apellido3.getText().toString());
            i.putExtra("txtc3", cargo3.getText().toString());
            i.putExtra("txth3", horas3.getText().toString());
            startActivity(i);
        }
    }
}