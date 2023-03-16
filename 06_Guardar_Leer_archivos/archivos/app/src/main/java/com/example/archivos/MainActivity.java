package com.example.archivos;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import com.example.archivos.R;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends Activity {

    private Button btnEscribirArchivo = null;
    private Button btnLeerArchivo = null;
    private Button btnLeerRaw = null;
    private EditText txtNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        btnEscribirArchivo = (Button)findViewById(R.id.BtnEscribirArchivo);
        btnLeerArchivo = (Button)findViewById(R.id.BtnLeerArchivo);
        btnLeerRaw = (Button)findViewById(R.id.BtnLeerRaw);

        btnEscribirArchivo.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0)
            {
                try
                {
                    OutputStreamWriter fout =
                            new OutputStreamWriter(
                                    openFileOutput("prueba_int.txt", Context.MODE_PRIVATE));

                    fout.write(txtNombre.getText().toString());
                    fout.close();

                    Log.i("Archivos", "Archivo creado!");
                }
                catch (Exception ex)
                {
                    Log.e("Archivos", "Error al escribir Archivo a memoria interna");
                }
            }
        });

        btnLeerArchivo.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0)
            {
                try
                {
                    BufferedReader fin =
                            new BufferedReader(
                                    new InputStreamReader(
                                            openFileInput("prueba_int.txt")));

                    String texto = fin.readLine();
                    fin.close();

                    Log.i("Archivos", "Archivo leido!");
                    Log.i("Archivos", "Texto: " + texto);
                }
                catch (Exception ex)
                {
                    Log.e("Archivos", "Error al leer Archivo desde memoria interna");
                }
            }
        });

        btnLeerRaw.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0)
            {
                String linea = "";

                try
                {
                    InputStream fraw =
                            getResources().openRawResource(R.raw.prueba_raw);

                    BufferedReader brin =
                            new BufferedReader(new InputStreamReader(fraw));

                    linea = brin.readLine();
                    fraw.close();

                    Log.i("Archivos", "Archivo RAW leido!");
                    Log.i("Archivos", "Texto: " + linea);
                }
                catch (Exception ex)
                {
                    Log.e("Archivos", "Error al leer Archivo desde recurso raw");;
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}