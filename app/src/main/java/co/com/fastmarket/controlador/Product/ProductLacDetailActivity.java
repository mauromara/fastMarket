package co.com.fastmarket.controlador.Product;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.fastmarket.R;
import co.com.fastmarket.adapter.ProductAdapter;
import co.com.fastmarket.controlador.BaseActivity;
import co.com.fastmarket.funcion.FuncionOrder;
import co.com.fastmarket.funcion.FuncionProducto;
import co.com.fastmarket.funcion.FuncionShipping;
import co.com.fastmarket.funcion.FuncionUsuario;
import co.com.fastmarket.inyeccion.FastMarketApplication;
import co.com.fastmarket.modelo.Order;
import co.com.fastmarket.modelo.Product;
import co.com.fastmarket.modelo.ShippingDetails;
import co.com.fastmarket.modelo.UserSesion;

public class ProductLacDetailActivity extends BaseActivity {

    @Inject
    FuncionProducto funcionProducto;

    @BindView(R.id.listViewProd)
    ListView listViewProd;

    @Inject
    ShippingDetails shippingDetails;

    @Inject
    FuncionShipping funcionShipping;

    @Inject
    FuncionUsuario funcionUsuario;

    @Inject
    UserSesion userSesion;

    private ProductAdapter productAdapter;

    private ArrayList<Product> productsArrayList;

    @Inject
    FuncionOrder funcionOrder;

    @Inject
    Order order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        ((FastMarketApplication) getApplication()).getDiComponent().inject(this);
        init();
    }

    /**
     * Método que inicializa el Activity
     */
    private void init() {
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.product_detail);
        userSesion = funcionUsuario.getUserSesion();
        funcionProducto.registerProduct();
        productsArrayList = funcionProducto.getProduct();
        productAdapter = new ProductAdapter(ProductLacDetailActivity.this, productsArrayList, item -> insertShippping(item));
        listViewProd.setAdapter(productAdapter);

    }

    /**
     * Método para crear una compra
     */
    private void insertShippping(Product product) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.atencion))
                .setMessage(getString(R.string.compra_seguro))
                .setCancelable(false)
                .setNegativeButton(android.R.string.no, (dialogInterface, i) -> dialogInterface.dismiss())
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    shippingDetails.setIdUser(userSesion.getIdUser());
                    shippingDetails.setShippingAmount(product.getProductAmount());
                    shippingDetails.setShippingState("Pendiente");
                    funcionShipping.insertShipping(shippingDetails);
                    Toast.makeText(this, "Compra aprobada",
                            Toast.LENGTH_LONG).show();
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    @Override
    public void onBackPressed() {
    }
}
