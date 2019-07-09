package co.com.fastmarket.bdHelper.manager;

import co.com.fastmarket.bdHelper.BdHelper;
import co.com.fastmarket.modelo.Product;
import java.sql.SQLException;

/**
 * Clase manager para la interacción con la BD de la clase Product
 */
public class ProductManager extends CrudManager<Product, Integer> {

    /**
     * Constructor
     *
     * @param helper
     * @throws SQLException
     */
    public ProductManager(BdHelper helper) throws SQLException {
        super(helper, Product.class);
    }
}
