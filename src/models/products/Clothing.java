package models.products;

public class Clothing extends Product {
    public Clothing(String name , double price, int stock ,
                    String color , String material , String brand) {
        super("Clothing",name, price, stock,color,brand,material);
    }
}
