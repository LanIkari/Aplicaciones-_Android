package mx.unam.curso.miprimerejemplo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private EditText campoDolar;
    private EditText campoPesos;
    private static final int DOLAR_EN_PESOS = Menu.FIRST;
    private static final int PESOS_EN_DOLAR = Menu.FIRST + 1;
    private static final int SALIR = Menu.FIRST + 2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campoDolar = findViewById(R.id.dolar);
        campoPesos = findViewById(R.id.pesos);

        Button dolarAPesos = findViewById(R.id.dolar2pesos);
        Button pesosADolar = findViewById(R.id.pesos2dolar);
        Button salir = (Button) findViewById(R.id.salir);
        dolarAPesos.setOnClickListener(new View.OnClickListener() { public void onClick(View view) {
            f_dolar_a_pesos();
        }
        });
        pesosADolar.setOnClickListener(new View.OnClickListener() { public void onClick(View view) {
            f_pesos_a_dolar();
        }
        });
        salir.setOnClickListener(new View.OnClickListener() { public void onClick(View view) {
            f_salir();
        }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) { super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, DOLAR_EN_PESOS, 0, R.string.m_dolar2pesos); menu.add(Menu.NONE, PESOS_EN_DOLAR, 1, R.string.m_pesos2dolar); menu.add(Menu.NONE, SALIR, 2, R.string.salir);
        return true;
    }
    public void f_dolar_a_pesos()
    {
        campoPesos.setText(""+Double.parseDouble(campoDolar.getText().toString())*19.92);
    }
    public void f_pesos_a_dolar()
    {
        campoDolar.setText(""+Double.parseDouble(campoPesos.getText().toString())/19.92);
    }
    public void f_salir()
    {
        setResult(RESULT_OK); finish();
    }
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) { super.onMenuItemSelected(featureId, item);
        switch(item.getItemId()) { case DOLAR_EN_PESOS:
            f_dolar_a_pesos(); break;
            case PESOS_EN_DOLAR: f_pesos_a_dolar(); break;
            case SALIR: f_salir(); break;
        }
        return true;
    }
}
