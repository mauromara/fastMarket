package co.com.fastmarket.controlador;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.fastmarket.R;
import co.com.fastmarket.controlador.Product.ProductActivity;

public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.appbar)
    @Nullable
    Toolbar toolbar;

    @BindView(R.id.drawerLayout)
    @Nullable
    DrawerLayout drawerLayout;

    @BindView(R.id.navView)
    @Nullable
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Método que inicializa toda la activity
     */
    private void init() {
        inicializarToolbar();
        if (navigationView != null) {
            View headerView = navigationView.getHeaderView(0);
            initMenuNavigationView(headerView);
        }
    }

    /**
     * Método que inicializa la toolbar de la aplicación
     */
    private void inicializarToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void initMenuNavigationView(View view) {
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    Intent intent = null;
                    if (menuItem.getItemId() == R.id.menu_inicio) {
                        intent = new Intent(BaseActivity.this
                                , ProductActivity.class);
                    }

                    if (menuItem.getItemId() == R.id.menu_list_order) {
                        intent = new Intent(BaseActivity.this
                                , ListOrderActivity.class);
                    }

                    if (intent != null) {
                        startActivity(intent);
                        finish();
                    }

                    drawerLayout.closeDrawers();
                    return true;
                });
    }
}
