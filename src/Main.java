import products.*;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /*
    TODO: Products
    adding, displaying, discounts, product types -> Details and behaviour
    TODO: User
    Group1: Timothy, Dennis, Gideon, Angeline, Roy, Gloria : Roy
    Group2:  Steve, Abednego, C Yegon, Byron, Eugine, Pacific :  Abednego


 maven:
 mysql/postgres:

     */


    private static ProductImpl productManager = new ProductImpl();
    private static UserImpl userManager = new UserImpl();
    private static User currentUser = null;
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

//        createProduct/
        System.out.println("=== WELCOME TO ONLINE STORE CATALOG SYSTEM ===");

        // Initialize with some sample data
        initializeSampleData();

        boolean running = true;
        while (running) {
            displayMainMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        handleUserManagement();
                        break;
                    case 2:
                        handleProductManagement();
                        break;
                    case 3:
                        handleShopping();
                        break;
                    case 4:
                        handleDiscounts();
                        break;
                    case 5:
                        displayCatalog();
                        break;
                    case 6:
                        displayStatistics();
                        break;
                    case 0:
                        System.out.println("Thank you for using Online Store Catalog System!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           MAIN MENU");
        System.out.println("=".repeat(50));
        System.out.println("1. User Management");
        System.out.println("2. Product Management");
        System.out.println("3. Shopping");
        System.out.println("4. Apply Discounts");
        System.out.println("5. View Catalog");
        System.out.println("6. Statistics");
        System.out.println("0. Exit");
        System.out.println("=".repeat(50));

        if (currentUser != null) {
            System.out.println("Logged in as: " + currentUser.getName());
        }

        System.out.print("Enter your choice: ");
    }

    private static void handleUserManagement() {
        System.out.println("\n=== USER MANAGEMENT ===");
        System.out.println("1. Create New User");
        System.out.println("2. Login");
        System.out.println("3. View All Users");
        System.out.println("4. Current User Info");
        System.out.print("Enter choice: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    User newUser = userManager.createUser();
                    if (newUser != null) {
                        System.out.println("User created successfully!");
                        currentUser = newUser;
                    }
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    userManager.displayAllUsers();
                    break;
                case 4:
                    if (currentUser != null) {
                        displayUserInfo(currentUser);
                    } else {
                        System.out.println("No user logged in.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }

    private static void handleProductManagement() {
        System.out.println("\n=== PRODUCT MANAGEMENT ===");
        System.out.println("1. Add Sport Product");
        System.out.println("2. Add Travel Product");
        System.out.println("3. Add Clothing Product");
        System.out.println("4. View Product Details");
        System.out.println("5. Remove Product");
        System.out.print("Enter choice: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createSportProduct();
                    break;
                case 2:
                    createTravelProduct();
                    break;
                case 3:
                    createClothingProduct();
                    break;
                case 4:
                    viewProductDetails();
                    break;
                case 5:
                    removeProduct();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }

    private static void handleShopping() {
        if (currentUser == null) {
            System.out.println("Please login first to shop!");
            return;
        }

        System.out.println("\n=== SHOPPING ===");
        displayCatalog();

        System.out.print("Enter Product ID to purchase (0 to cancel): ");
        try {
            Long productId = Long.parseLong(scanner.nextLine());
            if (productId == 0) return;

            Product product = productManager.getProductById(productId);
            if (product != null) {
                userManager.puchaseProduct(product, currentUser);
            } else {
                System.out.println("Product not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid product ID!");
        }
    }

    private static void handleDiscounts() {
        System.out.println("\n=== DISCOUNT MANAGEMENT ===");
        System.out.println("1. Apply Type-based Discount");
        System.out.println("2. Apply Fixed Amount Discount");
        System.out.println("3. Apply Percentage Discount");
        System.out.println("4. Apply Loyalty Discount");
        System.out.println("5. Apply Bulk Discount");
        System.out.print("Enter choice: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            applyDiscountByType(choice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }

    private static void createSportProduct() {
        System.out.println("\n=== CREATE SPORT PRODUCT ===");

        SportProducts sportProduct = new SportProducts();

        System.out.print("Enter product name: ");
        sportProduct.setName(scanner.nextLine());

        System.out.print("Enter price: $");
        sportProduct.setPrice(Double.parseDouble(scanner.nextLine()));

        System.out.print("Enter quantity: ");
        sportProduct.setQuantity(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter sport rate multiplier (default 1): ");
        String rateInput = scanner.nextLine();
        if (!rateInput.isEmpty()) {
            sportProduct.setSportRate(Integer.parseInt(rateInput));
        }

        // Create product type
        ProductType productType = new ProductType();
        productType.setName("Sport Product");
        productType.setType(Type.GOLF_ITEMS);
        productType.setPercentageDiscount(0.05); // 5% default discount

        productManager.createProduct(sportProduct, productType);
        System.out.println("Sport product created successfully!");
        System.out.println("Final price with sport rate: $" + String.format("%.2f", sportProduct.getPrice()));
    }

    private static void createTravelProduct() {
        System.out.println("\n=== CREATE TRAVEL PRODUCT ===");

        TravelProducts travelProduct = new TravelProducts();

        System.out.print("Enter product name: ");
        travelProduct.setName(scanner.nextLine());

        System.out.print("Enter base price: $");
        travelProduct.setPrice(Double.parseDouble(scanner.nextLine()));

        System.out.print("Enter quantity: ");
        travelProduct.setQuantity(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter destination: ");
        travelProduct.setDestination(scanner.nextLine());

        System.out.print("Enter travel days: ");
        travelProduct.setTravelDays(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter luggage weight (kg): ");
        travelProduct.setLuggageWeight(Double.parseDouble(scanner.nextLine()));

        // Create product type
        ProductType productType = new ProductType();
        productType.setName("Travel Product");
        productType.setType(Type.TRAVEL_ITEMS);
        productType.setPercentageDiscount(0.10); // 10% default discount

        productManager.createProduct(travelProduct, productType);
        System.out.println("Travel product created successfully!");
        System.out.println("Final price with travel surcharges: $" + String.format("%.2f", travelProduct.getPrice()));
    }

    private static void createClothingProduct() {
        System.out.println("\n=== CREATE CLOTHING PRODUCT ===");

        ClothingProducts clothingProduct = new ClothingProducts();

        System.out.print("Enter product name: ");
        clothingProduct.setName(scanner.nextLine());

        System.out.print("Enter base price: $");
        clothingProduct.setPrice(Double.parseDouble(scanner.nextLine()));

        System.out.print("Enter quantity: ");
        clothingProduct.setQuantity(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter size (S/M/L/XL): ");
        clothingProduct.setSize(scanner.nextLine());

        System.out.print("Enter material (Cotton/Silk/Wool/Leather): ");
        clothingProduct.setMaterial(scanner.nextLine());

        System.out.print("Enter season (Spring/Summer/Fall/Winter/All-season): ");
        clothingProduct.setSeason(scanner.nextLine());

        // Create product type
        ProductType productType = new ProductType();
        productType.setName("Clothing Product");
        productType.setType(Type.CLOTHING_PRODUCTS);
        productType.setPercentageDiscount(0.15); // 15% default discount

        productManager.createProduct(clothingProduct, productType);
        System.out.println("Clothing product created successfully!");
        System.out.println("Final price with material multiplier: $" + String.format("%.2f", clothingProduct.getPrice()));
    }

    private static void displayCatalog() {
        System.out.println("\n=== PRODUCT CATALOG ===");
        Product[] products = productManager.getProductsArray();

        if (products.length == 0) {
            System.out.println("No products available.");
            return;
        }

        for (Product product : products) {
            System.out.println("ID: " + product.getId() + " | " + product.toString());
        }
    }

    private static void viewProductDetails() {
        System.out.print("Enter Product ID: ");
        try {
            Long productId = Long.parseLong(scanner.nextLine());
            Product product = productManager.getProductById(productId);

            if (product != null) {
                System.out.println("\n" + product.displayDetails());
            } else {
                System.out.println("Product not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid product ID!");
        }
    }

    private static void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        try {
            Long productId = Long.parseLong(scanner.nextLine());

            if (productManager.removeProduct(productId)) {
                System.out.println("Product removed successfully!");
            } else {
                System.out.println("Product not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid product ID!");
        }
    }

    private static void applyDiscountByType(int discountType) {
        System.out.print("Enter Product ID: ");
        try {
            Long productId = Long.parseLong(scanner.nextLine());
            Product product = productManager.getProductById(productId);

            if (product == null) {
                System.out.println("Product not found!");
                return;
            }

            System.out.println("Original price: $" + String.format("%.2f", product.getPrice()));

            switch (discountType) {
                case 1:
                    productManager.applyDiscount(product);
                    System.out.println("Type-based discount applied!");
                    break;
                case 2:
                    System.out.print("Enter fixed discount amount: $");
                    double fixedAmount = Double.parseDouble(scanner.nextLine());
                    productManager.applyFixedDiscount(product, fixedAmount);
                    System.out.println("Fixed discount applied!");
                    break;
                case 3:
                    System.out.print("Enter discount percentage (0.0-1.0): ");
                    double percentage = Double.parseDouble(scanner.nextLine());
                    productManager.applyPercentageDiscount(product, percentage);
                    System.out.println("Percentage discount applied!");
                    break;
                case 4:
                    if (currentUser == null) {
                        System.out.println("Please login first!");
                        return;
                    }
                    System.out.print("Enter loyalty discount rate (0.0-1.0): ");
                    double loyaltyRate = Double.parseDouble(scanner.nextLine());
                    productManager.applyLoyaltyDiscount(product, currentUser, loyaltyRate);
                    System.out.println("Loyalty discount applied!");
                    break;
                case 5:
                    System.out.print("Enter bulk discount rate (0.0-1.0): ");
                    double bulkRate = Double.parseDouble(scanner.nextLine());
                    Product[] allProducts = productManager.getProductsArray();
                    productManager.applyBulkDiscount(allProducts, bulkRate);
                    System.out.println("Bulk discount applied to all products!");
                    break;
                default:
                    System.out.println("Invalid discount type!");
                    return;
            }

            System.out.println("New price: $" + String.format("%.2f", product.getPrice()));

        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        } catch (Exception e) {
            System.out.println("Error applying discount: " + e.getMessage());
        }
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        User user = userManager.findUserByName(username);
        if (user != null) {
            currentUser = user;
            System.out.println("Login successful! Welcome, " + user.getName());
        } else {
            System.out.println("User not found!");
        }
    }

    private static void displayUserInfo(User user) {
        System.out.println("\n=== USER INFORMATION ===");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("ID Number: " + user.getIdNumber());
        System.out.println("Member since: " + user.getDateCreated());
    }

    private static void displayStatistics() {
        System.out.println("\n=== SYSTEM STATISTICS ===");
        System.out.println("Total Users: " + userManager.getUserCount());
        System.out.println("Total Products: " + productManager.getProductCount());

        Product[] products = productManager.getProductsArray();
        if (products.length > 0) {
            double totalValue = 0;
            int totalQuantity = 0;

            for (Product product : products) {
                totalValue += product.getPrice() * product.getQuantity();
                totalQuantity += product.getQuantity();
            }

            System.out.println("Total Inventory Value: $" + String.format("%.2f", totalValue));
            System.out.println("Total Items in Stock: " + totalQuantity);
            System.out.println("Average Product Price: $" + String.format("%.2f", totalValue / totalQuantity));
        }
    }

    private static void initializeSampleData() {
        // Create sample product types
        ProductType golfType = new ProductType();
        golfType.setName("Golf Equipment");
        golfType.setType(Type.GOLF_ITEMS);
        golfType.setPercentageDiscount(0.05);

        // Create sample products
        SportProducts golfClub = new SportProducts();
        golfClub.setName("Premium Golf Club Set");
        golfClub.setPrice(299.99);
        golfClub.setQuantity(10);
        golfClub.setSportRate(2);

        TravelProducts backpack = new TravelProducts();
        backpack.setName("Travel Backpack");
        backpack.setPrice(89.99);
        backpack.setQuantity(15);
        backpack.setDestination("Multi-purpose");
        backpack.setTravelDays(7);
        backpack.setLuggageWeight(2.5);

        ClothingProducts jacket = new ClothingProducts();
        jacket.setName("Winter Jacket");
        jacket.setPrice(149.99);
        jacket.setQuantity(8);
        jacket.setSize("L");
        jacket.setMaterial("Wool");
        jacket.setSeason("Winter");

        // Add to product manager
        productManager.createProduct(golfClub, golfType);

        ProductType travelType = new ProductType();
        travelType.setName("Travel Gear");
        travelType.setType(Type.TRAVEL_ITEMS);
        travelType.setPercentageDiscount(0.10);
        productManager.createProduct(backpack, travelType);

        ProductType clothingType = new ProductType();
        clothingType.setName("Winter Clothing");
        clothingType.setType(Type.CLOTHING_PRODUCTS);
        clothingType.setPercentageDiscount(0.15);
        productManager.createProduct(jacket, clothingType);

        System.out.println("Sample data initialized: 3 products added to catalog.");
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


}}