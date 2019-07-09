package co.com.fastmarket.bdHelper.manager;

import co.com.fastmarket.bdHelper.BdHelper;
import co.com.fastmarket.modelo.ShippingDetails;

import java.sql.SQLException;

/**
 * Clase manager para la interacción con la BD de la clase Shipping
 */
public class ShippingManager extends CrudManager<ShippingDetails, Integer> {

    /**
     * Constructor
     *
     * @param helper
     * @throws SQLException
     */
    public ShippingManager(BdHelper helper) throws SQLException {
        super(helper, ShippingDetails.class);
    }
}
