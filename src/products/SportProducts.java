package products;

public class SportProducts extends Product {
    private Integer sportRate = 2; // Default sport rate multiplier
    private String sportType;
    private String difficulty;

    public SportProducts() {
        super();
        // Initialize sport-specific defaults
        this.sportType = "General";
        this.difficulty = "Intermediate";
    }

    // METHOD OVERRIDING: Override getPrice for sport-specific pricing
    @Override
    public double getPrice() {
        // Apply sport rate multiplier to base price
        return super.getPrice() * sportRate;
    }

    // METHOD OVERRIDING: Override toString for sport-specific display
    @Override
    public String toString() {
        return String.format("Sport Product: %s (%s) - $%.2f [Rate: %dx]",
                getName(), sportType, getPrice(), sportRate);
    }

    // METHOD OVERRIDING: Override displayDetails for detailed sport info
    @Override
    public String displayDetails() {
        return String.format("=== SPORT PRODUCT ===\nName: %s\nSport Type: %s\n" +
                        "Difficulty: %s\nBase Price: $%.2f\nSport Rate: %dx\n" +
                        "Final Price: $%.2f\nQuantity: %d\nID: %d",
                getName(), sportType, difficulty,
                super.getPrice(), sportRate, getPrice(), getQuantity(), getId());
    }

    // Sport-specific getters and setters
    public Integer getSportRate() {
        return sportRate;
    }

    public void setSportRate(Integer sportRate) {
        if (sportRate == null || sportRate < 1) {
            this.sportRate = 1; // Minimum multiplier of 1
        } else {
            this.sportRate = sportRate;
        }
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType != null ? sportType : "General";
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty != null ? difficulty : "Intermediate";
    }
}