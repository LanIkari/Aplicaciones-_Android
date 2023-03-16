package com.example.sumatoria_numeros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnSuma = null;
    private EditText NumEntero;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSuma = (Button)findViewById(R.id.BtnSuma);
        NumEntero = (EditText) findViewById(R.id.Num_Entero);
        Resultado = (TextView) findViewById(R.id.Imprimir_Resultado);

        btnSuma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String valor1 = NumEntero.getText().toString();
                int nro1 = Integer.parseInt(valor1);
                int suma = nro1 * (nro1 + 1) / 2;
                String resul = "";
                resul = "La suma de los " + nro1 +
                        " primeros numeros enteros es : " +
                        suma;
                Resultado.setText(resul);
            }
        });
    }
}