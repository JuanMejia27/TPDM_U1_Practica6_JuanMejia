package mx.edu.ittepic.tpdm_u1_practica6_juanmejia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nombre;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=findViewById(R.id.nombre);
        lista=findViewById(R.id.lista);

        ArrayList<String> l = new ArrayList<String>();
        l.add("Capturar");l.add("Consultar");l.add("Acerca de...");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,l);

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        String archivo = nombre.getText().toString();
                        if (archivo.equals("")) {
                            //Toast.makeText(this,"Escribe el nombre del archivo primero",Toast.LENGTH_LONG).show();
                            msj("Escribe el nombre del archivo primero");
                        }else{
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            intent.putExtra("archivo", archivo);
                            startActivity(intent);
                        }
                        break;

                    case 1:
                        String archivo2 = nombre.getText().toString();
                        if (archivo2.equals("")) {
                            //Toast.makeText(this,"Escribe el nombre del archivo primero",Toast.LENGTH_LONG).show();
                            msj("Escribe el nombre del archivo primero");
                        }else{
                            Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                            intent.putExtra("nomar", archivo2);
                            startActivity(intent);
                        }

                        break;

                    case 2:
                        if (position == 2) {
                            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                            alerta.setTitle("Acerca de...").setMessage("(C) Reservados Juan Antonio Mejia Peña\n Tecnologico de Tepic")
                                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    }).show();
                        }
                        break;
                }//switch
            }
        });
    }//onCreate

    private void msj(String msj) {
        Toast.makeText(this,msj,Toast.LENGTH_SHORT).show();
    }

}//class
