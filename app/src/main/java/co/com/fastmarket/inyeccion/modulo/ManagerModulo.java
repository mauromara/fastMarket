package co.com.fastmarket.inyeccion.modulo;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;

import co.com.fastmarket.bdHelper.BdHelper;
import co.com.fastmarket.bdHelper.manager.OrderManager;
import co.com.fastmarket.bdHelper.manager.ProductManager;
import co.com.fastmarket.bdHelper.manager.RoleManager;
import co.com.fastmarket.bdHelper.manager.ShippingManager;
import co.com.fastmarket.bdHelper.manager.UserManager;
import co.com.fastmarket.bdHelper.manager.UserSesionManager;
import co.com.fastmarket.modelo.UserSesion;
import dagger.Module;
import dagger.Provides;

/**
 * Clase del módulo Dagger para la inyeccion de la BD
 */
@Module
public class ManagerModulo {

    private final BdHelper helper;
    private final Context mContext;

    /**
     * Constructor
     *
     * @param mContext
     */
    public ManagerModulo(Context mContext) {
        this.mContext = mContext;
        helper = OpenHelperManager.getHelper(mContext, BdHelper.class);
    }

    @Provides
    Context context() {
        return mContext;
    }

    /**
     * Provider Usuario Manager
     *
     * @return
     */
    @Provides
    public UserManager provideUserManager() {
        try {
            return new UserManager(helper);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Provider Role Manager
     *
     * @return
     */
    @Provides
    public RoleManager provideRoleManager() {
        try {
            return new RoleManager(helper);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Provider Product Manager
     *
     * @return
     */
    @Provides
    public ProductManager provideProductManager() {
        try {
            return new ProductManager(helper);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Provider Product Manager
     *
     * @return
     */
    @Provides
    public ShippingManager provideShippingManager() {
        try {
            return new ShippingManager(helper);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Provider Product Manager
     *
     * @return
     */
    @Provides
    public UserSesionManager provideUserSesionManager() {
        try {
            return new UserSesionManager(helper);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Provider Order Manager
     *
     * @return
     */
    @Provides
    public OrderManager provideOrderManager() {
        try {
            return new OrderManager(helper);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
