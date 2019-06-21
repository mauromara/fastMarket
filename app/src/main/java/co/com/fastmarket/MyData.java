package co.com.fastmarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyData extends AppCompatActivity {

    TextView tvnombre, tvapellidos, tvedad, tvcelular,tvcorreo;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);


        tvnombre     = (TextView) findViewById(R.id.tvNombre);
        tvapellidos  = (TextView) findViewById(R.id.tvApellido);
        tvedad       = (TextView) findViewById(R.id.tvEdad);
        tvcelular    = (TextView) findViewById(R.id.tvCelular);
        tvcorreo     = (TextView) findViewById(R.id.tvCorreo);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(MyData.this,Registry.class);
                startActivity(intent);
            }
        });


    }

}
