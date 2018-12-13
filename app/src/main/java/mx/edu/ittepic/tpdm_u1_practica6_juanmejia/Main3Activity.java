package mx.edu.ittepic.tpdm_u1_practica6_juanmejia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main3Activity extends AppCompatActivity {
    EditText posicion;
    Button mostrar;
    TextView val;
    String nombrear;
    String vec[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        posicion = findViewById(R.id.posicion);
        mostrar = findViewById(R.id.mostrar);
        val = findViewById(R.id.val);

        nombrear = getIntent().getStringExtra("archivo");
        final int i = Integer.parseInt(posicion.getText().toString());

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    BufferedReader archivo = new BufferedReader(new InputStreamReader(openFileInput(nombrear)));
                    String dts = archivo.readLine();
                    archivo.close();
                    vec = dts.split(",");

                }catch (Exception e){
                    //Toast.makeText(this,"Error "+e.getMessage(),Toast.LENGTH_LONG).show();
                    msj("Error "+e.getMessage());
                }
                val.setText("Posicion "+i+": "+vec[i]);
            }
        });

    }//onCreate

    private void msj(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}//class
