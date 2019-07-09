package co.com.fastmarket.inyeccion.modulo;

import co.com.fastmarket.modelo.Order;
import co.com.fastmarket.modelo.Role;
import co.com.fastmarket.modelo.ShippingDetails;
import co.com.fastmarket.modelo.User;
import co.com.fastmarket.modelo.UserSesion;
import dagger.Module;
import dagger.Provides;

/**
 * Clase del módulo Dagger para la inyeccion de las clases modeladas
 */
@Module
public class ModeloModulo {

    /**
     * Provider Usuario
     *
     * @return
     */
    @Provides
    public User provideUser() {
        return new User();
    }

    /**
     * Provider Role
     *
     * @return
     */
    @Provides
    public Role provideRole() {
        return new Role();
    }

    /**
     * Provider Shipping
     *
     * @return
     */
    @Provides
    public ShippingDetails provideShipping() {
        return new ShippingDetails();
    }

    /**
     * Provider Usuario Sesion
     *
     * @return
     */
    @Provides
    public UserSesion provideUserSesion() {
        return new UserSesion();
    }

    /**
     * Provider Order
     *
     * @return
     */
    @Provides
    public Order provideOrder() {
        return new Order();
    }
}
