package products;

public class SportProducts extends Product {

    private Integer sportRate;

    public SportProducts() {
        super();
        setPrice(super.getPrice() * sportRate);
    }

    public double getPrice() {
        return getPrice();
    }
}
