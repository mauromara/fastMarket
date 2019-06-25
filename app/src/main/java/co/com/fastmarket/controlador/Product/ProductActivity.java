package co.com.fastmarket.controlador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import butterknife.BindView;
import co.com.fastmarket.R;

public class ProductActivity extends BaseActivity {

    @BindView(R.id.mCv_lacteo)
    CardView mCvLacteo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        init();
    }

    /**
     * Método que inicializa el Activity
     */
    private void init() {
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.product_name);
        mCvLacteo.setOnClickListener(v -> {
            Intent intent = new Intent(ProductActivity.this, ProductLacDetailActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
    }
}
