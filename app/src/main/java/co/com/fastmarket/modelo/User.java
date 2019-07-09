package co.com.fastmarket.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Clase del modelo Usuario
 */
@DatabaseTable
public class User {

    @DatabaseField(generatedId = true)
    private int idUser;

    @DatabaseField(canBeNull = false)
    private int idUserRole;

    @DatabaseField(canBeNull = false)
    private String userName;

    @DatabaseField(canBeNull = false)
    private String userEmail;

    @DatabaseField(canBeNull = false)
    private String userPassword;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(int idUserRole) {
        this.idUserRole = idUserRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
