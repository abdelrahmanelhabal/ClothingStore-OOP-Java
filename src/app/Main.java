package app;

import cart.CartItem;
import products.Accessory;
import products.Clothing;
import user.Customer;

public class Main {
    public static void main(String[] args) {
        Clothing tShirt = new Clothing("T-Shirt", "Clothing", 300,
                50, "Black", 40, "Cotton", "Zara"
        );

        Clothing jeans = new Clothing("Jeans", "Clothing", 700,
                30, "Blue", 38, "Denim", "Zara"
        );

        Accessory watch = new Accessory("Watch", "Accessory", 1200,
                20, "Black", "Casio", "Digital"
        );

        Customer customer = new Customer(
                "Elhabal",
                "password",
                "Elhabal@gmail.com",
                3000
        );

        System.out.println("Customer Created");
        System.out.println(customer.displayInfo());
        System.out.println("Balance: " + customer.getBalance());
        System.out.println("----------------------------------");

        customer.addToCart(new CartItem(tShirt, "Black",40,1));
        customer.addToCart(new CartItem(jeans, "blue",38,1));
        customer.addToCart(new CartItem(watch, "Black",50,1));

        System.out.println("\n===== CHECKOUT =====");
        customer.checkout();

        System.out.println("\nRemaining Balance: " + customer.getBalance());
    }
}