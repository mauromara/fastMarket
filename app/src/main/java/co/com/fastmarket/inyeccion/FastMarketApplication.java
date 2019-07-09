package co.com.fastmarket.inyeccion;

import android.app.Application;

import co.com.fastmarket.inyeccion.modulo.DaggerDiComponent;
import co.com.fastmarket.inyeccion.modulo.DiComponent;
import co.com.fastmarket.inyeccion.modulo.FuncionModulo;
import co.com.fastmarket.inyeccion.modulo.ManagerModulo;
import co.com.fastmarket.inyeccion.modulo.ModeloModulo;

public class FastMarketApplication extends Application {

    /* Componente */
    private DiComponent diComponent;

    /* Aplicacion */
    private static FastMarketApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initComponent();
    }

    /**
     * Inicializador de componente dagger
     */
    private void initComponent() {
        diComponent = DaggerDiComponent.builder()
                .funcionModulo(new FuncionModulo(this))
                .managerModulo(new ManagerModulo(this))
                .modeloModulo(new ModeloModulo())
                .build();
    }

    /**
     * Obtiene el componente para el inject
     *
     * @return
     */
    public DiComponent getDiComponent() {
        return diComponent;
    }

    /**
     * Obtiene la aplicacion
     *
     * @return
     */
    public static FastMarketApplication getApp() {
        return app;
    }
}
