package com.example.programa_subsidioestatal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button btnGuardar = null;
    private EditText etTexto;
    private EditText etTexto2;
    private RadioButton radio;
    private TextView tv1, tv2, tv3, tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGuardar = (Button)findViewById(R.id.BtnGuardar);
        etTexto = findViewById(R.id.etTexto);
        etTexto2 = findViewById(R.id.etTexto2);
        radio=(RadioButton) findViewById(R.id.radio0);
        tv1=(TextView)findViewById(R.id.TotalHijos);
        tv2=(TextView)findViewById(R.id.HijosEscolares);
        tv3=(TextView)findViewById(R.id.Viudez);
        tv4=(TextView)findViewById(R.id.SubsidioTotal);

        btnGuardar.setOnClickListener (new View.OnClickListener(){
            public void onClick(View arg0) {

                int nhijos;
                int hijosEsc;
                double sub1, sub2, sub3, subsidio;

                String numhijos = etTexto.getText().toString();
                nhijos = Integer.parseInt(numhijos);

                String numhijosesc = etTexto2.getText().toString();
                hijosEsc = Integer.parseInt(numhijosesc);

                if(nhijos <=2){
                    sub1 = 1700;
                }
                else if (nhijos <=5){
                    sub1 = 1900;
                }
                else
                    sub1 = 1200;
                sub2 = hijosEsc * 200;
                sub3 = 0;
                if (radio.isChecked()==true){
                    sub3 = 800;
                }
                subsidio = sub1 + sub2 + sub3;

                String resu="", resu1="", resu2="",resu3 ="";

                resu = "El monto del Subsidio por numero de hijos : "+sub1+ "\n";
                resu1 = "El subsidio por hijos en edad escolar:"+sub2+"\n";
                resu2 = "El subsidio por viudez es: "+sub3+"\n";
                resu3 = "El monto del subsidio total acumulado es: "+subsidio+"\n";
                tv1.setText(resu);
                tv2.setText(resu1);
                tv3.setText(resu2);
                tv4.setText(resu3);

            }
        });
    }



}