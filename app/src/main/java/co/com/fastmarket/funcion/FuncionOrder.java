package co.com.fastmarket.funcion;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.fastmarket.bdHelper.manager.OrderManager;
import co.com.fastmarket.bdHelper.manager.ShippingManager;
import co.com.fastmarket.inyeccion.FastMarketApplication;
import co.com.fastmarket.modelo.Order;

/**
 * Clase para manejar las funciones de consulta para el modelo Order
 */
public class FuncionOrder {

    private static FuncionOrder funcionOrder;

    /*Ordermanager*/
    @Inject
    OrderManager orderManager;

    /*Shippingmanager*/
    @Inject
    ShippingManager shippingManager;

    /**
     * Constructor
     *
     * @param context
     */
    private FuncionOrder(Context context) {
        FastMarketApplication.getApp().getDiComponent().inject(this);
    }

    /**
     * Constructor Singleton
     *
     * @param context
     * @return
     */
    public static FuncionOrder getInstance(Context context) {
        if (funcionOrder == null) {
            funcionOrder = new FuncionOrder(context);
        }

        return funcionOrder;
    }

    /**
     * Metodo que valida si los usuarios ya se encuentran en la base local
     *
     * @return
     */
    public void registerOrder(Order order) {
        orderManager.createOrUpdate(order);
        shippingManager.eliminateAll();
    }

    /**
     * Método para obtener las ordenes
     *
     * @return
     */
    public ArrayList<Order> getOrder() {
        List<Order> orderList = orderManager.all();
        return new ArrayList<>(orderList);
    }
}
