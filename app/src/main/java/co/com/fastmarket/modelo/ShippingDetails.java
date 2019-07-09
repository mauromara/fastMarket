package co.com.fastmarket.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Clase del modelo Shipping
 */
@DatabaseTable
public class ShippingDetails {

    @DatabaseField(generatedId = true)
    private int idShipping;

    @DatabaseField(canBeNull = false)
    private int shippingAmount;

    @DatabaseField(canBeNull = false)
    private String shippingState;

    @DatabaseField(canBeNull = false)
    private int idUser;

    public int getIdShipping() {
        return idShipping;
    }

    public void setIdShipping(int idShipping) {
        this.idShipping = idShipping;
    }

    public int getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(int shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
