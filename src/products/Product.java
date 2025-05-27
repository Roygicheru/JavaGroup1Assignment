package products;

public class Product extends BaseModel {
    private String name;
    private double price;
    private int quantity;
    private ProductType productType;

    // Existing getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public ProductType getProductType() { return productType; }
    public void setProductType(ProductType productType) { this.productType = productType; }

    // METHOD OVERRIDING: toString method for display
    @Override
    public String toString() {
        // Basic product display - can be overridden by subclasses
        return String.format("Product: %s - $%.2f (Qty: %d)",
                name != null ? name : "Unnamed Product",
                price, quantity);
    }

    // Additional display method that can be overridden
    public String displayDetails() {
        StringBuilder details = new StringBuilder();
        details.append("=== PRODUCT DETAILS ===\n");
        details.append("ID: ").append(getId()).append("\n");
        details.append("Name: ").append(name != null ? name : "N/A").append("\n");
        details.append("Price: $").append(String.format("%.2f", price)).append("\n");
        details.append("Quantity: ").append(quantity).append("\n");

        if (productType != null) {
            details.append("Type: ").append(productType.getName()).append("\n");
            details.append("Category: ").append(productType.getType()).append("\n");
        }

        details.append("Created: ").append(getDateCreated()).append("\n");
        return details.toString();
    }
}