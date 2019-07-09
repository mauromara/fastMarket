package co.com.fastmarket.funcion;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import co.com.fastmarket.bdHelper.manager.ProductManager;
import co.com.fastmarket.bdHelper.manager.UserManager;
import co.com.fastmarket.bdHelper.manager.UserSesionManager;
import co.com.fastmarket.inyeccion.FastMarketApplication;
import co.com.fastmarket.modelo.Product;
import co.com.fastmarket.modelo.User;
import co.com.fastmarket.modelo.UserSesion;

/**
 * Clase para manejar las funciones de consulta para el modelo usuario
 */
public class FuncionUsuario {

    private static FuncionUsuario funcionUsuario;

    /*Usuario manager*/
    @Inject
    UserManager userManager;

    /*Productmanager*/
    @Inject
    ProductManager productManager;

    /*UsuarioSeson*/
    @Inject
    UserSesion userSesion;

    /*UsuarioSesion manager*/
    @Inject
    UserSesionManager userSesionManager;

    /**
     * Constructor
     *
     * @param context
     */
    private FuncionUsuario(Context context) {
        FastMarketApplication.getApp().getDiComponent().inject(this);
    }

    /**
     * Constructor Singleton
     *
     * @param context
     * @return
     */
    public static FuncionUsuario getInstance(Context context) {
        if (funcionUsuario == null) {
            funcionUsuario = new FuncionUsuario(context);
        }

        return funcionUsuario;
    }

    /**
     * Metodo que valida si los usuarios ya se encuentran en la base local
     *
     * @return
     */
    public Boolean registerUser(User userName) {
        List<User> usuerList = userManager.all();
        if (usuerList.size() > 0) {
            for (User user : usuerList) {
                if (user.getUserName().equals(userName.getUserName())) {
                    return false;
                }
            }
        }

        userManager.create(userName);
        return true;
    }

    /**
     * Método que valida si el usuario o contraseña existen
     */
    public Boolean validateLoginUser(User usuario) {
        userSesionManager.eliminateAll();
        List<User> usuerList = userManager.all();

        for (User usu : usuerList) {
            if (usu.getUserName().equalsIgnoreCase(usuario.getUserName())
                    && usu.getUserPassword().equals(usuario.getUserPassword())) {
                userSesion.setIdUser(usu.getIdUser());
                userSesion.setUserName(usu.getUserName());
                userSesionManager.createOrUpdate(userSesion);
                return true;
            }
        }
        return false;
    }

    /**
     * Meétodo para retornar el usuario en sesión
     *
     * @return
     */
    public UserSesion getUserSesion() {
        List<UserSesion> userSesionAct = userSesionManager.all();

        return userSesionAct.get(0);

    }

}
