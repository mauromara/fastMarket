package co.com.fastmarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registry extends AppCompatActivity {


    EditText nombre, apellido, edad, celular, correo;
    Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);


        nombre   = (EditText) findViewById(R.id.editNombre);
        apellido = (EditText) findViewById(R.id.editApellidos);
        edad     = (EditText) findViewById(R.id.editEdad);
        celular  = (EditText) findViewById(R.id.editCelular);
        correo   = (EditText) findViewById(R.id.editCorreo);
        aceptar  = (Button)findViewById(R.id.btnAceptar);

        aceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String name  = nombre.getText().toString();
                String ape   = apellido.getText().toString();
                String age   = edad.getText().toString();
                String phone = celular.getText().toString();
                String email = correo.getText().toString();

                Intent i = new Intent(Registry.this, MyData.class);
                startActivity(i);

                i.putExtra("name", name);
                i.putExtra("ape", ape);
                i.putExtra("age", age);
                i.putExtra("phone", phone);
                i.putExtra("email", email);





            }
            } );


        }

    }
