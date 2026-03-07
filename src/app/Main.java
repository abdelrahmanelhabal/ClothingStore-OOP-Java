package app;


import models.products.Accessory;
import models.products.Clothing;
import models.products.Product;
import models.user.Admin;
import models.user.Customer;
import models.user.User;
import service.ProductService;
import service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product tShirt = new Clothing("T-Shirt",  300,
                50, "Black", "Cotton", "Zara"
        );

        Product jeans = new Clothing("Jeans", 700,
                30, "Blue",  "Denim", "Zara"
        );

        Accessory watch = new Accessory("Watch", 1200.0, 20,
                "Black", "Casio",  "Metal"
        );

        Accessory headphones = new Accessory("Headphones", 800.0,15,
                "White", "Sony", "Plastic"
        );

        User admin = new Admin("Abdelrahman Elhabal" , "Elhabal123","elhabal@gmail.com");

        User customer = new Customer( "Ali",  "Ali12345",  "Ali@gmail.com" );

        ProductService productService = new ProductService() ;

//        productService.saveProduct(tShirt);
//        productService.saveProduct(jeans);
//        productService.saveProduct(watch);
//        productService.saveProduct(headphones);


        UserService userService = new UserService();

//        userService.saveUser(admin);
//        userService.saveUser(customer);


        List<Product> products = productService.getAllProducts();
        System.out.println("Products");
        for(Product product : products){
            System.out.println(product.toString());
        }
        System.out.println("Users");
        List<User> users = userService.getAllUsers();
        for(User user : users){
            System.out.println(user.toString());
        }

    }
}