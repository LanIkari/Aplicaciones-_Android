package mx.unam.curso.miprimerejemplo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText montocompra;
    private TextView tv1, tv2, tv3, tv4, tv5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        montocompra = (EditText) findViewById(R.id.MontoCompra);

        tv1 = (TextView) findViewById(R.id.MontoC);

        tv2 = (TextView) findViewById(R.id.Descuento);

        tv3 = (TextView) findViewById(R.id.CostoNeto);

        tv4 = (TextView) findViewById(R.id.Impuesto);

        tv5 = (TextView) findViewById(R.id.ImporteNeto);

    }

    public void calcular_descuento(View view) {
        double dscto, vventa, impuestos, vfactura;
        String consumo = montocompra.getText().toString();
        double cantconsumo = Double.parseDouble(consumo);
        String porcentaje;
        if (cantconsumo > 30) {

            dscto = cantconsumo * 0.20;

            porcentaje = "20%";

        } else {

            dscto = cantconsumo * 0.10;

            porcentaje = "10%";
        }
        vventa = cantconsumo - dscto;
        impuestos = vventa * 0.18;
        vfactura = vventa + impuestos;
        String resu, resu1, resu2, resu3, resu4;
        resu = "El monto total de la compra es es: " + cantconsumo + " \n";
        resu1 = "El Descuento respectivo es: " + porcentaje + "\t:" + dscto + "\n";
        resu2 = "El Valor venta a pagar es: " + vventa + "\n";
        resu3 = "El Impuesto del 18% es:" + impuestos + "\n";
        resu4 = "El monto a facturar es: " + vfactura + "\n";
        tv1.setText(resu);
        tv2.setText(resu1);
        tv3.setText(resu2);
        tv4.setText(resu3);
        tv5.setText(resu4);
    }
}
