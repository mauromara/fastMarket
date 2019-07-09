package co.com.fastmarket.bdHelper.manager;

import co.com.fastmarket.bdHelper.BdHelper;
import co.com.fastmarket.modelo.Order;
import java.sql.SQLException;

/**
 * Clase manager para la interacción con la BD de la clase Order
 */
public class OrderManager extends CrudManager<Order, Integer> {

    /**
     * Constructor
     *
     * @param helper
     * @throws SQLException
     */
    public OrderManager(BdHelper helper) throws SQLException {
        super(helper, Order.class);
    }
}
