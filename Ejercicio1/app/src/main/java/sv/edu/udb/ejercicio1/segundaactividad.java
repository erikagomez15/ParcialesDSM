package sv.edu.udb.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class segundaactividad extends AppCompatActivity {

    private TextView tvx;
    private TextView tvx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundaactividad);
        double respuesta1, respuesta2,formula,descriminante;

        tvx=(TextView)findViewById(R.id.tvx);
        tvx1=(TextView)findViewById(R.id.tvx1);

        Bundle bundle = getIntent().getExtras();
        String B = bundle.getString("txtb");
        double VB = Double.parseDouble(B);
        String A = bundle.getString("txta");
        double VA = Double.parseDouble(A);
        String C = bundle.getString("txtc");
        double VC = Double.parseDouble(C);

      descriminante=  (VB*VB)-4*VA*VC;


      if (descriminante < 0)
      {

          tvx.setText("No existen soluciones reales");
          tvx1.setText("No existen soluciones reales");
          Toast notificacion= Toast.makeText(this,"No posee soluciones reales.",Toast.LENGTH_LONG);
          notificacion.show();

      }
        if (VA  == 0) {
            Toast notificacion= Toast.makeText(this,"Error: el valor de a no puede ser cero",Toast.LENGTH_LONG);
            notificacion.show();
        }
        if (descriminante==0) {
            respuesta1= (-VB + Math.sqrt(descriminante))/(2*VA);
            respuesta2=(-VB -Math.sqrt(descriminante))/(2*VA);

            tvx.setText("Primera Solución :" +respuesta1);
            tvx1.setText("Segunda Solución :" +respuesta2);
            Toast notificacion= Toast.makeText(this,"Posee una unica solución doble",Toast.LENGTH_LONG);
            notificacion.show();

        }


      else {
          respuesta1= (-VB + Math.sqrt(descriminante))/(2*VA);
          respuesta2=(-VB -Math.sqrt(descriminante))/(2*VA);

          tvx.setText("Primera Solución :" +respuesta1);
          tvx1.setText("Segunda Solución :" +respuesta2);
      }




    }
    public void fin(View v){finish();}
}