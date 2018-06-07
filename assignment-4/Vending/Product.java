/**
 * Created by thepnathi on 04/05/2018.
 */
public class Product {
    private String productName; // Product name
    private String productType;
    private double productPrice; // Product price
    private int productStock = 4; // Product stock level / quantity availabel

    // Constructor to take in the data
    public Product(String name, String type, double price) {
        this.productName = name;
        this.productType = type;
        this.productPrice = price;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public String getProductType() {
        return productType;
    }
}
