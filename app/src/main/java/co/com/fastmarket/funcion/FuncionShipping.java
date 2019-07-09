package co.com.fastmarket.funcion;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import co.com.fastmarket.bdHelper.manager.ShippingManager;
import co.com.fastmarket.inyeccion.FastMarketApplication;
import co.com.fastmarket.modelo.ShippingDetails;
import co.com.fastmarket.modelo.UserSesion;

/**
 * Clase para manejar las funciones de consulta para el modelo Shipping
 */
public class FuncionShipping {

    private static FuncionShipping funcionShipping;

    /*Shippingmanager*/
    @Inject
    ShippingManager shippingManager;

    /**
     * Constructor
     *
     * @param context
     */
    private FuncionShipping(Context context) {
        FastMarketApplication.getApp().getDiComponent().inject(this);
    }

    /**
     * Constructor Singleton
     *
     * @param context
     * @return
     */
    public static FuncionShipping getInstance(Context context) {
        if (funcionShipping == null) {
            funcionShipping = new FuncionShipping(context);
        }

        return funcionShipping;
    }

    /**
     * Metodo que valida si los usuarios ya se encuentran en la base local
     *
     * @return
     */
    public void insertShipping(ShippingDetails shippingDetails) {
        shippingManager.create(shippingDetails);
    }

    /**
     * Método para obtener los productos
     *
     * @return
     */
    public List<ShippingDetails> getShipping(UserSesion userSesion) {
        List<ShippingDetails> shippingList = shippingManager.allFilterId(userSesion.getIdUser(), "idUser");
        return shippingList;
    }

}
