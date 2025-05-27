package products;

import java.util.Scanner;

public class UserImpl implements UserI {


    @Override
    public User createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username: \n");
        String name = scanner.nextLine();
        System.out.println("Please enter IdNumber\n");
        String idNumber = scanner.nextLine();
        System.out.println("Enter Email\n");
        String email = scanner.nextLine();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setIdNumber(idNumber);

        return user;
    }
    @Override
    public Product puchaseProduct(Product product, User user) {
        return null;
    }
}
