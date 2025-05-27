import products.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        createProduct/
        List<Product> products = new ArrayList<>();

        UserI userInterface = new UserImpl();
        User user = userInterface.createUser();

    //Creating a product type
        ProductType productType = new ProductType();
        productType.setName("Golf Club");
        productType.setDescription("Premium golf product");
        productType.setType(Type.GOLF_ITEMS);
        productType.setPercentageDiscount(0.20);

//        creating a product and assign product type

        Product product = new Product();
        product.setProductType(productType);
        product.setPrice(250);

        //Adding a product using ProductImpl
        ProductI productService = new ProductImpl();
        product = productService.createProduct(product, productType);
        products.add(product);

        // Checking and applying discounts
        // try catch exception
        try{
            product = productService.applyDiscount(product);
        }catch (Exception e) {
            System.out.println("Error Applying Discount: " + e.getMessage());
        }
         //carrying out purchases
        userInterface.puchaseProduct(product, user);

        //Displaying Details
        System.out.println("\n USER DETAILS ");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());

        System.out.println("\n PRODUCT DETAILS ");
        System.out.println("Product Type: " + product.getProductType().getName());
        System.out.println("Original Price: 250.0");
        System.out.println("Discount Percentage: " + (productType.getPercentageDiscount() * 100) + "%");
        System.out.println("Price After Discount: " + product.getPrice());

        System.out.println("\n DISCOUNT DETAILS ");
        Discount discount = new Discount();
        discount.setUser(user);
        discount.setDescription("Discount for product: " + product.getProductType().getName());
        discount.setTotal(productType.getPercentageDiscount() * 250.0);
        System.out.println("Description: " + discount.getDescription());
        System.out.println("Total Discount: " + discount.getTotal());

    }
}