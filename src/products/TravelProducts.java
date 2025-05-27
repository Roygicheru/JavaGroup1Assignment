package products;

public class TravelProducts extends Product {
    private String destination;
    private Integer travelDays;
    private Double luggageWeight;

    public TravelProducts() {
        super();
        // Initialize travel - specific defaults
        this.travelDays = 1;
        this.luggageWeight = 0.0;
    }

    @Override
    public double getPrice(){
        double basePrice = super.getPrice(); // Gets base price from product class
        double travelSurcharge = (travelDays * 10.0) + (luggageWeight * 2.0);
        return basePrice + travelSurcharge;
    }

    // Override toString to show travel-specific information
    @Override
    public String toString() {
        return String.format("Travel Product: %s\nDestination: %s\nDuration: %d days\n" +
                        "Luggage: %.1f kg\nTotal Price: $%.2f",
                getName(), destination, travelDays, luggageWeight, getPrice());
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getTravelDays() {
        return travelDays;
    }

    public void setTravelDays(Integer travelDays) {
        this.travelDays = travelDays;
    }

    public Double getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(Double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }
}
