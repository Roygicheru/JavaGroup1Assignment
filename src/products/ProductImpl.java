package products;

public class ProductImpl implements ProductI {
    // ARRAY-BASED STORAGE as per requirements
    private Product[] products;
    private int productCount;
    private static final int INITIAL_CAPACITY = 10;

    public ProductImpl() {
        this.products = new Product[INITIAL_CAPACITY];
        this.productCount = 0;
    }

    @Override
    public Product createProduct(Product product, ProductType productType) {
        product.setProductType(productType);

        // Check if array needs resizing
        if (productCount >= products.length) {
            resizeArray();
        }

        products[productCount] = product;
        productCount++;
        return product;
    }

    @Override
    public java.util.List<Product> getProducts() {
        java.util.List<Product> productList = new java.util.ArrayList<>();
        for (int i = 0; i < productCount; i++) {
            if (products[i] != null) {
                productList.add(products[i]);
            }
        }
        return productList;
    }

    // Array management methods
    private void resizeArray() {
        int newCapacity = products.length * 2;
        Product[] newArray = new Product[newCapacity];
        System.arraycopy(products, 0, newArray, 0, productCount);
        products = newArray;
        System.out.println("Array resized to capacity: " + newCapacity);
    }

    public Product[] getProductsArray() {
        // Return copy of array with only valid products
        Product[] result = new Product[productCount];
        System.arraycopy(products, 0, result, 0, productCount);
        return result;
    }

    public int getProductCount() {
        return productCount;
    }

    public Product getProductById(Long id) {
        for (int i = 0; i < productCount; i++) {
            if (products[i] != null && products[i].getId().equals(id)) {
                return products[i];
            }
        }
        return null;
    }

    public boolean removeProduct(Long id) {
        for (int i = 0; i < productCount; i++) {
            if (products[i] != null && products[i].getId().equals(id)) {
                // Shift remaining elements left
                System.arraycopy(products, i + 1, products, i, productCount - i - 1);
                products[productCount - 1] = null;
                productCount--;
                return true;
            }
        }
        return false;
    }

    // Original discount method (percentage-based from ProductType)
    @Override
    public Product applyDiscount(Product product) throws Exception {
        ProductType productType = product.getProductType();
        if (productType == null) {
            throw new Exception("Product type not set for product ID: " + product.getId());
        }

        double discountTotal = 0.0;
        if (productType.getPercentageDiscount() != null) {
            discountTotal = productType.getPercentageDiscount() * product.getPrice();
        }

        // Create discount record for tracking
        Discount discount = new Discount();
        discount.setDescription("Type-based discount for product ID " + product.getId());
        discount.setTotal(discountTotal);

        // Apply discount to product price
        product.setPrice(product.getPrice() - discountTotal);
        return product;
    }

    // OVERLOADED METHOD: Apply fixed amount discount
    public Product applyFixedDiscount(Product product, double fixedAmount) throws Exception {
        if (product == null) {
            throw new Exception("Product cannot be null");
        }
        if (fixedAmount < 0) {
            throw new Exception("Discount amount cannot be negative");
        }

        // Ensure discount doesn't exceed product price
        double actualDiscount = Math.min(fixedAmount, product.getPrice());

        // Create discount record
        Discount discount = new Discount();
        discount.setDescription("Fixed amount discount: $" + actualDiscount);
        discount.setTotal(actualDiscount);

        // Apply discount
        product.setPrice(product.getPrice() - actualDiscount);
        return product;
    }

    // OVERLOADED METHOD: Apply percentage discount with custom rate
    public Product applyPercentageDiscount(Product product, double percentageRate) throws Exception {
        if (product == null) {
            throw new Exception("Product cannot be null");
        }
        if (percentageRate < 0 || percentageRate > 1) {
            throw new Exception("Percentage rate must be between 0 and 1");
        }

        // Calculate discount amount
        double discountAmount = product.getPrice() * percentageRate;

        // Create discount record
        Discount discount = new Discount();
        discount.setDescription(String.format("Custom %.0f%% discount", percentageRate * 100));
        discount.setTotal(discountAmount);

        // Apply discount
        product.setPrice(product.getPrice() - discountAmount);
        return product;
    }

    // OVERLOADED METHOD: Apply user-specific discount (loyalty program)
    public Product applyLoyaltyDiscount(Product product, User user, double loyaltyRate) throws Exception {
        if (product == null || user == null) {
            throw new Exception("Product and User cannot be null");
        }

        // Base loyalty discount
        double baseDiscount = product.getPrice() * loyaltyRate;

        // Create discount record linking to user
        Discount discount = new Discount();
        discount.setDescription("Loyalty discount for user: " + user.getName());
        discount.setTotal(baseDiscount);
        discount.setUser(user); // Link discount to specific user

        // Apply discount
        product.setPrice(product.getPrice() - baseDiscount);
        return product;
    }

    // OVERLOADED METHOD: Bulk discount for multiple products
    public Product[] applyBulkDiscount(Product[] productArray, double bulkDiscountRate) throws Exception {
        if (productArray == null || productArray.length == 0) {
            throw new Exception("Product array cannot be null or empty");
        }

        // Apply bulk discount to each product
        for (Product product : productArray) {
            if (product != null) {
                double discountAmount = product.getPrice() * bulkDiscountRate;

                // Create individual discount records
                Discount discount = new Discount();
                discount.setDescription("Bulk purchase discount");
                discount.setTotal(discountAmount);

                // Apply discount
                product.setPrice(product.getPrice() - discountAmount);
            }
        }

        return productArray;
    }
}