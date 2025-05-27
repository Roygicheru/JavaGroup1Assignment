package products;

public class Product extends BaseModel {
    private String name;
    private double price;
    private int quantity;
    private ProductType productType;

//    public Product(String name, double price, int quantity, ProductType productType) {
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//        this.productType = productType;
//    }


    public Long getId(){
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}