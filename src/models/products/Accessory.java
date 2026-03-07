package models.products;

public class Accessory extends Product{

    public Accessory(String name, double price, int stock ,
                     String color , String brand , String material ) {
        super("Accessory",name, price, stock,color,brand,material);
    }

}
