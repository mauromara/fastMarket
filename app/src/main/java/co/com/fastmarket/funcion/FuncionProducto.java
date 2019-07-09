package co.com.fastmarket.funcion;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.fastmarket.R;
import co.com.fastmarket.bdHelper.manager.ProductManager;
import co.com.fastmarket.inyeccion.FastMarketApplication;
import co.com.fastmarket.modelo.Product;

/**
 * Clase para manejar las funciones de consulta para el modelo Producto
 */
public class FuncionProducto {

    private static FuncionProducto funcionProducto;

    /*Productmanager*/
    @Inject
    ProductManager productManager;

    /**
     * Constructor
     *
     * @param context
     */
    private FuncionProducto(Context context) {
        FastMarketApplication.getApp().getDiComponent().inject(this);
    }

    /**
     * Constructor Singleton
     *
     * @param context
     * @return
     */
    public static FuncionProducto getInstance(Context context) {
        if (funcionProducto == null) {
            funcionProducto = new FuncionProducto(context);
        }

        return funcionProducto;
    }

    /**
     * Método para insertar los productos
     *
     * @return
     */
    public void registerProduct() {
        List<Product> productList = productManager.all();
        if (productList.size() == 0) {
            Product prod1 = new Product();
            prod1.setIdCategory(1);
            prod1.setImageId(R.drawable.leche);
            prod1.setProductAmount(3500);
            prod1.setProductName("Leche");
            prod1.setProductType("Lácteos");
            prod1.setProductDescription("Leche deslactosada");
            Product prod2 = new Product();
            prod2.setIdCategory(1);
            prod2.setImageId(R.drawable.huevos);
            prod2.setProductAmount(8500);
            prod2.setProductName("Huevos");
            prod2.setProductType("Lácteos");
            prod2.setProductDescription("Huevos de Gallina");
            productList.add(prod1);
            productList.add(prod2);
            for (Product prd : productList) {
                productManager.createOrUpdate(prd);
            }
        }
    }

    /**
     * Método para obtener los productos
     *
     * @return
     */
    public ArrayList<Product> getProduct() {
        List<Product> productList = productManager.all();
       return new ArrayList<>(productList);
    }
}
