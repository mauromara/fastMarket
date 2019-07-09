package co.com.fastmarket.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Clase del modelo Order
 */
@DatabaseTable
public class Order {

    @DatabaseField(generatedId = true)
    private int idOrder;

    @DatabaseField(canBeNull = false)
    private int idUser;

    @DatabaseField(canBeNull = false)
    private String orderDate;

    @DatabaseField(canBeNull = false)
    private String orderState;

    @DatabaseField(canBeNull = false)
    private int orderAmount;


    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}
