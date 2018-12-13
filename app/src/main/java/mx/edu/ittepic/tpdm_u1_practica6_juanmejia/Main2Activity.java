package mx.edu.ittepic.tpdm_u1_practica6_juanmejia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class Main2Activity extends AppCompatActivity {
    EditText Numeros;
    Button guardar;
    String nombrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Numeros = findViewById(R.id.numeros);
        guardar = findViewById(R.id.guardar);
        nombrear = getIntent().getStringExtra("archivo");
        final String n = Numeros.getText().toString();
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nombrear,MODE_PRIVATE));
                    archivo.write(n);
                    archivo.close();
                    //Toast.makeText(this,"Guardado",Toast.LENGTH_LONG).show();
                    msj("Guardado");
                }catch (Exception e){
                    //Toast.makeText(this,"Error "+e.getMessage(),Toast.LENGTH_LONG).show();
                    msj("Error "+e.getMessage());
                }
            }
        });
    }//onCreate

    private void msj(String msj) {
        Toast.makeText(this,msj,Toast.LENGTH_SHORT).show();
    }

}//class
