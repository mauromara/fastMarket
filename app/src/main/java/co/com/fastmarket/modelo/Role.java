package co.com.fastmarket.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Clase del modelo Role
 */
@DatabaseTable
public class Role {

    @DatabaseField(canBeNull = false)
    private int idRole;

    @DatabaseField(canBeNull = false)
    private String nameRole;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
