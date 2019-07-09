package co.com.fastmarket.inyeccion.modulo;

import co.com.fastmarket.controlador.ListOrderActivity;
import co.com.fastmarket.controlador.LoginActivity;
import co.com.fastmarket.controlador.Product.ProductActivity;
import co.com.fastmarket.controlador.Product.ProductLacDetailActivity;
import co.com.fastmarket.controlador.RegistryActivity;
import co.com.fastmarket.funcion.FuncionOrder;
import co.com.fastmarket.funcion.FuncionProducto;
import co.com.fastmarket.funcion.FuncionShipping;
import co.com.fastmarket.funcion.FuncionUsuario;
import dagger.Component;

/**
 * Clase componente para asignar el uso de los módulos Dagger inyectados
 */
@Component(modules = {ManagerModulo.class, ModeloModulo.class, FuncionModulo.class})
public interface DiComponent {

    /**
     * Inject de activities
     *
     * @param loginActivity
     */

    void inject(LoginActivity loginActivity);

    void inject(RegistryActivity registryActivity);

    void inject(ProductActivity productActivity);

    void inject(ProductLacDetailActivity productLacDetailActivity);

    void inject(ListOrderActivity listOrderActivity);

    /**
     * Inject de Funciones
     */
    void inject(FuncionUsuario funcionUsuario);

    void inject(FuncionProducto funcionProducto);

    void inject(FuncionShipping funcionShipping);

    void inject(FuncionOrder funcionOrder);
}
