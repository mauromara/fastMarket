package co.com.fastmarket.controlador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.fastmarket.R;
import co.com.fastmarket.adapter.ProductAdapter;
import co.com.fastmarket.funcion.FuncionProducto;
import co.com.fastmarket.inyeccion.FastMarketApplication;
import co.com.fastmarket.modelo.Product;
import co.com.fastmarket.modelo.ShippingDetails;

public class ProductLacDetailActivity extends BaseActivity {

    @Inject
    FuncionProducto funcionProducto;

    @BindView(R.id.listViewProd)
    ListView listViewProd;

    @BindView(R.id.imBtnBuy)
    ImageButton imBtnBuy;

    @Inject
    ShippingDetails shippingDetails;

    private ProductAdapter productAdapter;

    private ArrayList<Product> productsArrayList;

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
        funcionProducto.registerProduct();
        productsArrayList = funcionProducto.getProduct();
        productAdapter = new ProductAdapter(ProductLacDetailActivity.this, productsArrayList);
        listViewProd.setAdapter(productAdapter);
        imBtnBuy.setOnClickListener(view -> {
            insertShippping();

        });
    }

    /**
     * Método para crear una compra
     */
    private void insertShippping(){

    }

    @Override
    public void onBackPressed() {
    }
}
