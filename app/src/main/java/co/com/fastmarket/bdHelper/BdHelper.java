package co.com.fastmarket.bdHelper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.File;
import java.io.InputStream;

import co.com.fastmarket.modelo.Order;
import co.com.fastmarket.modelo.Product;
import co.com.fastmarket.modelo.Role;
import co.com.fastmarket.modelo.ShippingDetails;
import co.com.fastmarket.modelo.User;
import co.com.fastmarket.modelo.UserSesion;

/**
 * Clase para crear la base de datos
 */
public class BdHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "fastMarket.db";

    private static final int DB_VERSION = 1;
    private BdHelper helper;

    public BdHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        crearTablas();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }

    public static String getDbName() {
        return DB_NAME;
    }

    /**
     * Método que crea las tablas modeladas
     */
    private void crearTablas() {
        try {
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Role.class);
            TableUtils.createTable(connectionSource, Product.class);
            TableUtils.createTable(connectionSource, ShippingDetails.class);
            TableUtils.createTable(connectionSource, UserSesion.class);
            TableUtils.createTable(connectionSource, Order.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
