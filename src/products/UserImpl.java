package products;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserImpl implements UserI {
    // Array-based storage for users
    private User[] users;
    private int userCount;
    private static final int INITIAL_CAPACITY = 10;

    public UserImpl() {
        this.users = new User[INITIAL_CAPACITY];
        this.userCount = 0;
    }

    @Override
    public User createUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CREATE NEW USER ===");
        System.out.print("Please enter your username: ");
        String name = scanner.nextLine();

        System.out.print("Please enter ID Number: ");
        String idNumber = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        User user = new User(idNumber, name, email, password);

        // Add user to array storage
        if (userCount >= users.length) {
            resizeUserArray();
        }
        users[userCount] = user;
        userCount++;

        System.out.println("User created successfully! ID: " + user.getId());
        return user;
    }

    @Override
    public Product puchaseProduct(Product product, User user) {
        if (product == null || user == null) {
            System.out.println("Error: Product or User cannot be null");
            return null;
        }

        if (product.getQuantity() <= 0) {
            System.out.println("Error: Product out of stock!");
            return null;
        }

        // Simulate purchase process
        System.out.println("=== PURCHASE CONFIRMATION ===");
        System.out.println("User: " + user.getName());
        System.out.println("Product: " + product.getName());
        System.out.println("Price: $" + String.format("%.2f", product.getPrice()));
        System.out.println("Quantity Available: " + product.getQuantity());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter quantity to purchase (1-" + product.getQuantity() + "): ");

        try {
            int purchaseQuantity = Integer.parseInt(scanner.nextLine());

            if (purchaseQuantity < 1 || purchaseQuantity > product.getQuantity()) {
                System.out.println("Invalid quantity!");
                return null;
            }

            // Update product quantity
            product.setQuantity(product.getQuantity() - purchaseQuantity);

            double totalCost = product.getPrice() * purchaseQuantity;
            System.out.println("Purchase successful!");
            System.out.println("Total cost: $" + String.format("%.2f", totalCost));
            System.out.println("Remaining quantity: " + product.getQuantity());

            return product;

        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity format!");
            return null;
        }
    }

    // Additional user management methods
    public User findUserById(Long id) {
        for (int i = 0; i < userCount; i++) {
            if (users[i] != null && users[i].getId().equals(id)) {
                return users[i];
            }
        }
        return null;
    }

    public User findUserByName(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i] != null && users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }

    public User[] getAllUsers() {
        User[] result = new User[userCount];
        System.arraycopy(users, 0, result, 0, userCount);
        return result;
    }

    public int getUserCount() {
        return userCount;
    }

    private void resizeUserArray() {
        int newCapacity = users.length * 2;
        User[] newArray = new User[newCapacity];
        System.arraycopy(users, 0, newArray, 0, userCount);
        users = newArray;
        System.out.println("User array resized to capacity: " + newCapacity);
    }

    public void displayAllUsers() {
        System.out.println("=== ALL USERS ===");
        if (userCount == 0) {
            System.out.println("No users found.");
            return;
        }

        for (int i = 0; i < userCount; i++) {
            User user = users[i];
            if (user != null) {
                System.out.printf("ID: %d | Name: %s | Email: %s | ID Number: %s%n",
                        user.getId(), user.getName(), user.getEmail(), user.getIdNumber());
            }
        }
    }
}