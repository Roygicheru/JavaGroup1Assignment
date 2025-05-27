package products;

public class ClothingProducts extends Product {
    private String size;
    private String material;
    private String season;

    public ClothingProducts() {
        super();
        // Set clothing-specific defaults
        this.size = "M";
        this.material = "Cotton";
        this.season = "All-season";
    }

    // METHOD OVERRIDING: Override getPrice for material-based pricing
    @Override
    public double getPrice() {
        double basePrice = super.getPrice();
        double materialMultiplier = getMaterialMultiplier();
        // Premium materials cost more
        return basePrice * materialMultiplier;
    }

    // Helper method for material pricing
    private double getMaterialMultiplier() {
        switch (material.toLowerCase()) {
            case "silk": return 1.5;
            case "wool": return 1.3;
            case "leather": return 1.8;
            case "cotton": return 1.0;
            default: return 1.0;
        }
    }

    // METHOD OVERRIDING: Override toString for clothing-specific display
    @Override
    public String toString() {
        return String.format("Clothing: %s (%s, %s) - $%.2f",
                getName(), size, material, getPrice());
    }

    // METHOD OVERRIDING: Override displayDetails for detailed clothing info
    @Override
    public String displayDetails() {
        return String.format("=== CLOTHING ITEM ===\nName: %s\nSize: %s\nMaterial: %s\n" +
                        "Season: %s\nBase Price: $%.2f\nFinal Price: $%.2f\nQuantity: %d",
                getName(), size, material, season,
                super.getPrice(), getPrice(), getQuantity());
    }

    // Clothing-specific getters and setters
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
}