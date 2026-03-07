package models.user;

public class Customer extends User{
    public Customer(String name , String password , String email){
        super("Customer",name,email,password);
    }
}
