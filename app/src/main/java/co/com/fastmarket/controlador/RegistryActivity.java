package co.com.fastmarket.controlador;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jaredrummler.materialspinner.MaterialSpinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.fastmarket.R;
import co.com.fastmarket.funcion.FuncionUsuario;
import co.com.fastmarket.inyeccion.FastMarketApplication;
import co.com.fastmarket.modelo.Role;
import co.com.fastmarket.modelo.User;

public class RegistryActivity extends AppCompatActivity {

    @BindView(R.id.user_name_et)
    EditText etUserName;

    @BindView(R.id.user_email_et)
    EditText etUserEmail;

    @BindView(R.id.reg_password_et)
    EditText etPassword;

    @BindView(R.id.spinner)
    MaterialSpinner spinner;

    @Inject
    FuncionUsuario funcionUsuario;

    @Inject
    User user;

    @Inject
    Role role;

    @BindView(R.id.btnRegistry)
    Button btnRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        ButterKnife.bind(this);
        ((FastMarketApplication) getApplication()).getDiComponent().inject(this);
        putRoles();
        btnRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registry();
            }
        });

    }

    /**
     * Método para validar inicio de sesión
     **/
    private void registry() {
        if (etUserName.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()
                || etUserEmail.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.atencion))
                    .setMessage(getString(R.string.usuario_obligatorio))
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.yes, (dialog, which) -> dialog.dismiss())
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else {
            user.setUserName(etUserName.getText().toString());
            user.setUserPassword(etPassword.getText().toString());
            user.setUserEmail(etUserEmail.getText().toString());
            user.setIdUserRole(1);
            if (validateUserName(user)) {
                new AlertDialog.Builder(this)
                        .setTitle(getString(R.string.atencion))
                        .setMessage(getString(R.string.usuario_registrado))
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                            Intent intent = new Intent(RegistryActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        })
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();
            }else{
                new AlertDialog.Builder(this)
                        .setTitle(getString(R.string.atencion))
                        .setMessage(getString(R.string.usuario_existente))
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.yes, (dialog, which) -> dialog.dismiss())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }
    }

    /**
     * Método para validar si el usuairo ya existe en la BD
     *
     * @return
     */
    private Boolean validateUserName(User user) {
        return funcionUsuario.registerUser(user);
    }

    private void putRoles(){
        role.setIdRole(1);
        role.setNameRole("Cliente");
        spinner.setItems(role.getNameRole());
    }
}
