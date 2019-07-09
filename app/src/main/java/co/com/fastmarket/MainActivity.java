package co.com.fastmarket;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.com.fastmarket.controlador.LoginActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * Permisos iniciales para > Marshmallow
     **/
    private static final String[] INIT_PERMS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,
    };

    /**
     * Id de los permisos iniciales
     **/
    private static final int INIT_REQUEST = 1338;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (validatePerms()) {
            init();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(INIT_PERMS, INIT_REQUEST);
        }
    }

    private void init() {
        requestPermission();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, INIT_PERMS, 1);
    }

    /**
     * Este método valida los permisos según la versión de ANdroid
     */
    private boolean validatePerms() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {

            return true;
        }
        for (String permission : INIT_PERMS) {
            if (!hasPermission(permission)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Método que valida si tiene el permiso ya autorizado en el String recibido
     */
    @TargetApi(Build.VERSION_CODES.M)
    private boolean hasPermission(String perm) {
        return (PackageManager.PERMISSION_GRANTED == checkSelfPermission(perm));
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == INIT_REQUEST) {
            if (validatePerms()) {
                init();
            } else {
                requestPermissions(INIT_PERMS, INIT_REQUEST);
            }
        }
    }
}
