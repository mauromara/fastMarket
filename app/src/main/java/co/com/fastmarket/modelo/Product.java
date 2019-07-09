package co.com.fastmarket.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Clase del modelo Producto
 */
@DatabaseTable
public class Product {

    @DatabaseField(generatedId = true)
    private int idProduct;

    @DatabaseField(canBeNull = false)
    private int idCategory;

    @DatabaseField(canBeNull = false)
    private String productType;

    @DatabaseField(canBeNull = false)
    private String productName;

    @DatabaseField(canBeNull = false)
    private String productDescription;

    @DatabaseField(canBeNull = false)
    private int productAmount;

    @DatabaseField(canBeNull = false)
    private int imageId;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
