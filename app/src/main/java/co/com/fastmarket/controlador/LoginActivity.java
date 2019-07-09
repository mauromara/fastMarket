package co.com.fastmarket.controlador;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.fastmarket.R;
import co.com.fastmarket.controlador.Product.ProductActivity;
import co.com.fastmarket.funcion.FuncionUsuario;
import co.com.fastmarket.inyeccion.FastMarketApplication;
import co.com.fastmarket.modelo.User;
import co.com.fastmarket.modelo.UserSesion;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.reg_usuario_et)
    EditText etUser;

    @BindView(R.id.reg_password_et)
    EditText etPassword;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.btnRegistry)
    Button btnRegistry;

    @Inject
    FuncionUsuario funcionUsuario;

    @Inject
    User user;

    @Inject
    UserSesion userSesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ((FastMarketApplication) getApplication()).getDiComponent().inject(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        btnRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistryActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Método para validar inicio de sesión
     **/
    private void login() {
        if (etUser.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.atencion))
                    .setMessage(getString(R.string.usuario_obligatorio))
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else {
            user.setUserName(etUser.getText().toString());
            user.setUserPassword(etPassword.getText().toString());
            if (funcionUsuario.validateLoginUser(user)) {
                Intent intent = new Intent(LoginActivity.this, ProductActivity.class);
                startActivity(intent);
                finish();
            }else{
                new AlertDialog.Builder(this)
                        .setTitle(getString(R.string.atencion))
                        .setMessage(getString(R.string.usuario_incorrecto))
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }
    }
}
