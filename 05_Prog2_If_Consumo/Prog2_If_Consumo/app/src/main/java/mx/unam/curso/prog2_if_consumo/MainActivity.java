package mx.unam.curso.prog2_if_consumo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText montoCompra2;
    private TextView tv12,tv22,tv32,tv42,tv52;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        montoCompra2=(EditText)findViewById(R.id.montoCompra);
        tv12=(TextView)findViewById(R.id.montoC2);
        tv22=(TextView)findViewById(R.id.descuento2);
        tv32=(TextView)findViewById(R.id.costoNeto2);
        tv42=(TextView)findViewById(R.id.impuesto2);
        tv52=(TextView)findViewById(R.id.importeNeto2);
    }
    public void calcular_descuento2(View view){
        double dscto,vventa,impuestos,vfactura;
        String consumo=montoCompra2.getText().toString();
        double cantconsumo2=Double.parseDouble(consumo);
        String porcentaje;
        // calcular descuento
        if(cantconsumo2>100) {
            dscto=cantconsumo2*0.30;
            porcentaje="30%";
        }else if(cantconsumo2 > 60) {
            dscto=cantconsumo2*0.20;
            porcentaje="20%";
        }else if(cantconsumo2>30) {
            dscto=cantconsumo2*0.15;
            porcentaje="15%";
        }else {
            dscto = cantconsumo2 * 0.10;
            porcentaje = "10%";
        }
            //calcular valor venta
            vventa=cantconsumo2-dscto;
            //calcular impuestos
            impuestos=vventa*0.18;
            //calcular valor factura
            vfactura=vventa+impuestos;

        //Mostrar resultados
        String resu="",resu1="",resu2="",resu3="",resu4="";

        resu="El monto de la venta es: "+cantconsumo2+"\n";
        resu1="El descuento es: "+porcentaje+"\t "+dscto+"\n";
        resu2="El monto de la venta a pagar es: "+vventa+"\n";
        resu3="El nImpuesto 18% es: "+impuestos+"\n";
        resu4="El monto a facturar es: "+vfactura+"\n";

        tv12.setText(resu);
        tv22.setText(resu1);
        tv32.setText(resu2);
        tv42.setText(resu3);
        tv52.setText(resu4);
    }

}