package co.com.fastmarket.controlador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.fastmarket.R;
import co.com.fastmarket.adapter.OrderAdapter;
import co.com.fastmarket.funcion.FuncionOrder;
import co.com.fastmarket.funcion.FuncionShipping;
import co.com.fastmarket.funcion.FuncionUsuario;
import co.com.fastmarket.inyeccion.FastMarketApplication;
import co.com.fastmarket.modelo.Order;
import co.com.fastmarket.modelo.ShippingDetails;
import co.com.fastmarket.modelo.UserSesion;

public class ListOrderActivity extends BaseActivity {

    @Inject
    FuncionShipping funcionShipping;

    @Inject
    FuncionUsuario funcionUsuario;

    @Inject
    UserSesion userSesion;

    @Inject
    FuncionOrder funcionOrder;

    @Inject
    Order order;

    @BindView(R.id.listViewOrder)
    ListView listViewOrder;

    private OrderAdapter orderAdapter;

    private ArrayList<Order> ordersArrayList;

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);
        ButterKnife.bind(this);
        ((FastMarketApplication) getApplication()).getDiComponent().inject(this);
        init();
    }

    /**
     * Método que inicializa el Activity
     */
    private void init() {
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.lista_compra);
        registerOrder();
        ordersArrayList = funcionOrder.getOrder();
        if (ordersArrayList.size() > 0) {
            orderAdapter = new OrderAdapter(ListOrderActivity.this, ordersArrayList);
            listViewOrder.setAdapter(orderAdapter);
        }

    }

    /**
     * Método para insertar la Order
     */
    private void registerOrder() {
        int amount = 0;
        userSesion = funcionUsuario.getUserSesion();
        List<ShippingDetails> shippingList = funcionShipping.getShipping(userSesion);

        if (shippingList.size() > 0) {

            for (ShippingDetails shippingDetails1 : shippingList) {
                order.setIdUser(shippingDetails1.getIdUser());
                order.setOrderDate(dateFormat.format(date));
                order.setOrderState("Pedido");
                amount = amount + shippingDetails1.getShippingAmount();
            }
            order.setOrderAmount(amount);

            funcionOrder.registerOrder(order);
        }

    }
}
