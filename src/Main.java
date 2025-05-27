import products.Product;
import products.User;
import products.UserI;
import products.UserImpl;

import java.util.ArrayList;
import java.util.List;

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




    public static void main(String[] args) {

//        createProduct/
        List<Product> products = new ArrayList<>();

        UserI userInterface = new UserImpl();
        User user = userInterface.createUser();

        // Simple null check
        if (user != null) {
            System.out.println("User created: " + user.getName());
        }

    }
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


}