package co.com.fastmarket.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Clase del modelo Usuario en sesion
 */
@DatabaseTable
public class UserSesion {

    @DatabaseField(generatedId = true)
    private int idUserSesion;

    @DatabaseField(canBeNull = false)
    private int idUser;

    @DatabaseField(canBeNull = false)
    private String userName;

    public int getIdUserSesion() {
        return idUserSesion;
    }

    public void setIdUserSesion(int idUserSesion) {
        this.idUserSesion = idUserSesion;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
