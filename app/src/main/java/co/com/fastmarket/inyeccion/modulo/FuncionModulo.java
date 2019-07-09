package co.com.fastmarket.inyeccion.modulo;

import android.content.Context;

import co.com.fastmarket.bdHelper.BdHelper;
import co.com.fastmarket.funcion.FuncionOrder;
import co.com.fastmarket.funcion.FuncionProducto;
import co.com.fastmarket.funcion.FuncionShipping;
import co.com.fastmarket.funcion.FuncionUsuario;
import dagger.Module;
import dagger.Provides;

/**
 * Clase del módulo Dagger para la inyeccion de las funciones
 */
@Module
public class FuncionModulo {

    private final Context mContext;

    public FuncionModulo(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    Context context() {
        return mContext;
    }


    /**
     * Provider Funcion Usuario
     *
     * @return
     */
    @Provides
    public FuncionUsuario provideFuncionUsuario() {
        return FuncionUsuario.getInstance(mContext);
    }

    /**
     * Provider Funcion Producto
     *
     * @return
     */
    @Provides
    public FuncionProducto provideFuncionProducto() {
        return FuncionProducto.getInstance(mContext);
    }

    /**
     * Provider Funcion Shipping
     *
     * @return
     */
    @Provides
    public FuncionShipping provideFuncionShipping() {
        return FuncionShipping.getInstance(mContext);
    }

    /**
     * Provider Funcion Order
     *
     * @return
     */
    @Provides
    public FuncionOrder provideFuncionOrder() {
        return FuncionOrder.getInstance(mContext);
    }
}
