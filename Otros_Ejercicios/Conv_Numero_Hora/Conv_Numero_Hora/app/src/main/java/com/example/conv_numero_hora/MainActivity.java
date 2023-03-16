package com.example.conv_numero_hora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private  EditText Num_Decimal;
    private  TextView hora, mins, segs, desegs;
    private Button btnConv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConv = (Button) findViewById(R.id.BtnConv);
        Num_Decimal = (EditText) findViewById(R.id.NumDec);
        hora = (TextView) findViewById(R.id.Hora);
        mins = (TextView) findViewById(R.id.Minuto);
        segs = (TextView) findViewById(R.id.Segundo);
        desegs = (TextView) findViewById(R.id.Desima);
        btnConv.setOnClickListener (new View.OnClickListener(){
            public void onClick(View arg0) {
               String numreal = Num_Decimal.getText().toString();
               int hor, min, seg;
               int dseg;
               double nro1 = Double.parseDouble(numreal);
               hor=(int)(nro1);
               nro1 = (nro1 - hor) *60;
               min = (int)(nro1);
               nro1 = (nro1 - min) *60;
               seg = (int) (nro1);
               nro1 = (nro1 - seg) *60;
               dseg = (int) (nro1);
               String resu = "";
               String resu1 ="";
               String resu2 ="";
               String resu3 ="";
               resu="El total de horas es: "+hor+"\n";
               resu1="El total de minutos es: "+min+"\n";
               resu2="El total de segundos es: "+seg+"\n";
               resu3 ="El total de décimos de segundos es: "+dseg+"\n";

               hora.setText(resu);
               mins.setText(resu1);
               segs.setText(resu2);
               desegs.setText(resu3);

            }
        });
    }
}