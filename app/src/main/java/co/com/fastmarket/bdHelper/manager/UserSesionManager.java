package co.com.fastmarket.bdHelper.manager;

import co.com.fastmarket.bdHelper.BdHelper;
import co.com.fastmarket.modelo.UserSesion;

import java.sql.SQLException;

/**
 * Clase manager para la interacción con la BD de la clase Usuario Sesion
 */
public class UserSesionManager extends CrudManager<UserSesion, Integer> {

    /**
     * Constructor
     *
     * @param helper
     * @throws SQLException
     */
    public UserSesionManager(BdHelper helper) throws SQLException {
        super(helper, UserSesion.class);
    }
}
