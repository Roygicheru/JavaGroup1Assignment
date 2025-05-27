package products;

public class SportProducts extends Product {

    private Integer sportRate = 1;

    public SportProducts() {
        super();
//        setPrice(super.getPrice() * sportRate);
    }

    @Override
    public double getPrice() {
        return super.getPrice() * sportRate;
    }

    public Integer getSportRate() {
        return sportRate;
    }

    public void setSportRate(Integer sportRate) {
        this.sportRate = sportRate;
    }
}
