package co.com.fastmarket.bdHelper.manager;

import java.sql.SQLException;

import co.com.fastmarket.bdHelper.BdHelper;
import co.com.fastmarket.modelo.User;

/**
 * Clase manager para la interacción con la BD de la clase Usuario
 */
public class UserManager extends CrudManager<User, Integer> {
    /**
     * Constructor
     *
     * @param helper
     * @throws SQLException
     */
    public UserManager(BdHelper helper) throws SQLException {
        super(helper, User.class);
    }
}
