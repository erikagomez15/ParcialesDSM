package sv.edu.udb.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class segundaactividad extends AppCompatActivity {

    private double isss1;
    private double afp1;
    private double renta1;
    private double bono1;
    private double sueldo1;
    private TextView nombre1;
    private TextView tsueldo1;
    private TextView tafp1;
    private TextView trenta1;
    private TextView tisss1;
    private TextView tbono1;



    private double isss2;
    private double afp2;
    private double renta2;
    private double bono2;
    private double sueldo2;
    private TextView nombre2;
    private TextView tsueldo2;
    private TextView tafp2;
    private TextView trenta2;
    private TextView tisss2;
    private TextView tbono2;



    private double isss3;
    private double afp3;
    private double renta3;
    private double bono3;
    private double sueldo3;
    private TextView nombre3;
    private TextView tsueldo3;
    private TextView tafp3;
    private TextView trenta3;
    private TextView tisss3;
    private TextView tbono3;


    private  TextView mayor;
    private TextView menor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundaactividad);

        tsueldo1 =(TextView)findViewById(R.id.t1sueldo);
        tsueldo2=(TextView)findViewById(R.id.t2sueldo);
        tsueldo3=(TextView)findViewById(R.id.t3sueldo);

        tisss1=(TextView)findViewById(R.id.t1isss);
        tisss2=(TextView)findViewById(R.id.t2isss);
        tisss3=(TextView)findViewById(R.id.t3isss);

        tafp1=(TextView)findViewById(R.id.t1afp);
        tafp2=(TextView)findViewById(R.id.t2afp);
        tafp3=(TextView)findViewById(R.id.t3afp);

        trenta1=(TextView)findViewById(R.id.t1renta);
        trenta2=(TextView)findViewById(R.id.t2renta);
        trenta3=(TextView)findViewById(R.id.t3renta);

        tbono1=(TextView)findViewById(R.id.t1bono);
        tbono2=(TextView)findViewById(R.id.t2bono);
        tbono3=(TextView)findViewById(R.id.t3bono);

        nombre1=(TextView)findViewById(R.id.t1nombre);
        nombre2=(TextView)findViewById(R.id.t2nombre);
        nombre3=(TextView)findViewById(R.id.t3nombre);

        mayor=(TextView)findViewById(R.id.sueldomayor);
        menor=(TextView)findViewById(R.id.sueldomenor);



        Bundle bundle = getIntent().getExtras();
        String n1 = bundle.getString("txtn1");
        String p1 = bundle.getString("txtp1");
        String c1 = bundle.getString("txtc1").toLowerCase();
        String h1 = bundle.getString("txth1");
        int horauno = Integer.parseInt(h1);

        String n2 = bundle.getString("txtn2");
        String p2 = bundle.getString("txtp2");
        String c2 = bundle.getString("txtc2").toLowerCase();
        String h2 = bundle.getString("txth2");
        int horados = Integer.parseInt(h2);

        String n3 = bundle.getString("txtn3");
        String p3 = bundle.getString("txtp3");
        String c3 = bundle.getString("txtc3").toLowerCase();
        String h3 = bundle.getString("txth3");
        int horatres = Integer.parseInt(h3);

        calculosueldo(horauno,horados,horatres);

        if(c1.equalsIgnoreCase("Gerente") && c2.equalsIgnoreCase("Asistente") && c3.equalsIgnoreCase("Secretaria"))
        {
            bono1 = 0 ;
            bono2 = 0 ;
            bono3 = 0;
            tbono1.setText("Bono: No aplica");
            tbono2.setText("Bono: No aplica");
            tbono3.setText("Bono: No aplica");
        }
        else {
            bono1 = Bonos(c1,sueldo1);
            bono2 = Bonos(c2,sueldo2);
            bono3 = Bonos(c3,sueldo3);

            tbono1.setText("Bono:" +String.format("%.2f",bono1));
            tbono2.setText("Bono:" +String.format("%.2f",bono2));
            tbono3.setText("Bono:" +String.format("%.2f",bono3));
        }

        sueldo1 = sueldo1 + bono1;
        sueldo2 = sueldo2 + bono2;
        sueldo3 = sueldo3 + bono3;

        orden(sueldo1,sueldo2,sueldo3);

        tsueldo1.setText("Sueldo Liquido: "+String.format("%.2f",sueldo1));
        tsueldo2.setText("Sueldo Liquido: "+String.format("%.2f",sueldo2));
        tsueldo3.setText("Sueldo Liquido: "+String.format("%.2f",sueldo3));

        tisss1.setText("ISSS: "+String.format("%.2f",isss1));
        tisss2.setText("ISSS: "+String.format("%.2f",isss2));
        tisss3.setText("ISSS: "+String.format("%.2f",isss3));

        tafp1.setText("AFP: "+String.format("%.2f",afp1));
        tafp2.setText("AFP: "+String.format("%.2f",afp2));
        tafp3.setText("AFP: "+String.format("%.2f",afp3));

        trenta1.setText("Renta: "+String.format("%.2f",renta1));
        trenta2.setText("Renta: "+String.format("%.2f",renta2));
        trenta3.setText("Renta: "+String.format("%.2f",renta3));

        nombre1.setText(n1+" "+p1);
        nombre2.setText(n2+" "+p2);
        nombre3.setText(n3+" "+p3);

    }
    public void calculosueldo(int horas1, int horas2, int horas3)
    {
        double sueldobase1, sueldobase2,sueldobase3;
        if(horas1<=160)
        {
            sueldobase1 = horas1 *9.75;
            isss1 =sueldobase1*0.0525;
            afp1 = sueldobase1*0.0688;
            renta1 = sueldobase1*0.1;
            sueldo1 = sueldobase1-(isss1+afp1+renta1);
        }
        else{

            sueldobase1 = (160*9.75)+(horas1-160)*11.50;
            isss1 =sueldobase1*0.0525;
            afp1 = sueldobase1*0.0688;
            renta1 = sueldobase1*0.1;
            sueldo1 = sueldobase1-(isss1+afp1+renta1);

        }
        if (horas2<=160){
            sueldobase2 = horas2 *9.75;
            isss2 =sueldobase2*0.0525;
            afp2 = sueldobase2*0.0688;
            renta2 = sueldobase2*0.1;
            sueldo2 = sueldobase2-(isss2+afp2+renta2);
        }
        else{
            sueldobase2 = (160*9.75)+(horas2-160)*11.50;
            isss2 =sueldobase2*0.0525;
            afp2 = sueldobase2*0.0688;
            renta2 = sueldobase2*0.1;
            sueldo2 = sueldobase2-(isss2+afp2+renta2);
        }
        if (horas3<=160){
            sueldobase3 = horas3 *9.75;
            isss3 =sueldobase3*0.0525;
            afp3 = sueldobase3*0.0688;
            renta3 = sueldobase3*0.1;
            sueldo3 = sueldobase3-(isss3+afp3+renta3);
        }
        else{
            sueldobase3 = (160*9.75)+(horas3-160)*11.50;
            isss3 =sueldobase3*0.0525;
            afp3 = sueldobase3*0.0688;
            renta3 = sueldobase3*0.1;
            sueldo3 = sueldobase3-(isss3+afp3+renta3);
        }



    }

    public  void orden( double sueldo1, double sueldo2, double sueldo3){

        if (sueldo1 > sueldo2 && sueldo1 > sueldo3)
        {
            mayor.setText("Sueldo mayor: " +String.format("%.2f",sueldo1));

        }if(sueldo2> sueldo1 && sueldo2>sueldo3){
            mayor.setText("Sueldo mayor: " +String.format("%.2f",sueldo2));
        }if (sueldo3>sueldo1 && sueldo3>sueldo2){
            mayor.setText("Sueldo mayor: " +String.format("%.2f",sueldo3));
        }

        if (sueldo1 < sueldo2 && sueldo1 <sueldo3)
        {
            menor.setText("Sueldo menor: " +String.format("%.2f",sueldo1));

        }if(sueldo2 < sueldo1 && sueldo2 < sueldo3){
            menor.setText("Sueldo menor: " +String.format("%.2f",sueldo2));
        }if (sueldo3 < sueldo1 && sueldo3 < sueldo2){
            menor.setText("Sueldo menor: " +String.format("%.2f",sueldo3));
        }
    }

    public double Bonos(String cargo, double sueldo){
        double bono;
            switch (cargo){
                case "gerente":
                    bono = sueldo * 0.1;
                    break;
                case "asistente":
                    bono = sueldo * 0.05;
                    break;
                case "secretaria":
                    bono = sueldo * 0.03;
                    break;
                default:
                    bono = sueldo * 0.02;
                    break;
            }
           return bono;
    }





}