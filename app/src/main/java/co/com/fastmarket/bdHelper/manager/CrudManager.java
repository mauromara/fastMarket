package co.com.fastmarket.bdHelper.manager;

import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.List;

import co.com.fastmarket.bdHelper.BdHelper;

/**
 * Clase de tipo CRUD para la Base de Datos
 *
 * @param <T>
 * @param <Id>
 */
public class CrudManager<T, Id> {

    private static final String TAG_LOG = CrudManager.class.getName();

    private BdHelper helper;
    protected final Dao<T, Id> dao;
    private final Class<T> clazz;

    public CrudManager(BdHelper helper, Class<T> clazz) throws SQLException {
        this.helper = helper;
        this.clazz = clazz;
        dao = helper.getDao(clazz);
    }

    /**
     * Creación (o actualización) de la entidad T. En caso de que la entidad utilice Id
     * autogenerado, éste será cargado en la instancia
     *
     * @param entidad Instancia de la entidad T a ser creada en la BD
     * @return True si la entidad pudo ser creada, False de lo contrario
     */
    public boolean createOrUpdate(T entidad) {
        boolean creado = false;

        try {
            dao.createOrUpdate(entidad);
            creado = true;
        } catch (SQLException e) {
            Log.e(TAG_LOG,
                    String.format("Un error ocurrió mientras se creaba la entidad {%s}", clazz), e);
        }

        return creado;
    }


    /**
     * Creación ( de la entidad T. En caso de que la entidad utilice Id
     * autogenerado, éste será cargado en la instancia
     *
     * @param entidad Instancia de la entidad T a ser creada en la BD
     * @return id si la entidad pudo ser creada
     */
    public int create(T entidad) {
        int id = -1;

        try {
            id = dao.create(entidad);

        } catch (SQLException e) {
            Log.e(TAG_LOG,
                    String.format("Un error ocurrió mientras se creaba la entidad {%s}", clazz), e);
        }

        return id;
    }

    /**
     * Busca una el id de ina entidad
     *
     * @param entidad entidad a buscar
     * @return id id de la entidad
     */
    public Id findId(T entidad) {
        Id id = null;

        try {
            id = dao.extractId(entidad);

        } catch (SQLException e) {
            Log.e(TAG_LOG, String.format(
                    "Un error ocurrió mientras se buscaba la entidad {%s} con id {%s}", clazz, id),
                    e);
        }

        return id;
    }

    /**
     * Busca una entidad por su Id
     *
     * @param id Id de la entidad a buscar
     * @return Retorna la instancia si existe una coincidencia. De lo contrario, retorna null
     */
    public T findById(Id id) {
        T entidad = null;

        try {
            entidad = dao.queryForId(id);

        } catch (SQLException e) {
            Log.e(TAG_LOG, String.format(
                    "Un error ocurrió mientras se buscaba la entidad {%s} con id {%s}", clazz, id),
                    e);
        }

        return entidad;
    }

    /**
     * Retorna una entidad de todas las entidades T almacenadas por fitro entero
     *
     * @return Entidad de las entidades almacenadas
     */
    public T entityFilterId(Integer id, String campo) {
        T entidad = null;
        try {
            Where<T, Id> where = dao.queryBuilder().where();
            where.eq(campo, id);
            entidad = where.queryForFirst();
        } catch (SQLException e) {
            Log.e(TAG_LOG,
                    String.format("Un error ocurrió recuperando todas las entidades {%s}", clazz),
                    e);
        }
        return entidad;
    }

    /**
     * Retorna una lista de todas las entidades T almacenadas
     *
     * @return Lista de las entidades almacenadas
     */
    public List<T> all() {
        List<T> todos = null;
        try {
            todos = dao.queryForAll();
        } catch (SQLException e) {
            Log.e(TAG_LOG,
                    String.format("Un error ocurrió recuperando todas las entidades {%s}", clazz),
                    e);
        }
        return todos;
    }


    /**
     * Retorna una lista de todas las entidades T almacenadas por fitro entero
     *
     * @return Lista de las entidades almacenadas
     */
    public List<T> allFilterId(Integer id, String campo) {
        List<T> todos = null;
        try {
            Where<T, Id> where = dao.queryBuilder().where();
            where.eq(campo, id);
            todos = where.query();
        } catch (SQLException e) {
            Log.e(TAG_LOG,
                    String.format("Un error ocurrió recuperando todas las entidades {%s}", clazz),
                    e);
        }
        return todos;
    }

    /**
     * Elimina una entidad T dado su Id. Retorna la entidad eliminada
     *
     * @param id Id de la entidad a eliminar
     * @return El elemento T eliminado
     */
    public T eliminate(Id id) {
        T entidad = findById(id);
        try {
            if (entidad != null) {
                dao.deleteById(id);
            }
        } catch (SQLException e) {
            Log.e(TAG_LOG, String.format(
                    "Un error ha ocurrido mientras se eliminaba la entidad {%s} con Id {%s}", clazz,
                    id), e);
        }
        return entidad;
    }

    /**
     * Elimina todos los registros de la tabla
     **/
    public void eliminateAll() {
        try {
            dao.deleteBuilder().delete();
        } catch (SQLException e) {
            Log.e(TAG_LOG, String.format("Un error ha ocurrido limpiando la tabla de la entidad %s",
                    this.clazz), e);
        }
    }

}
