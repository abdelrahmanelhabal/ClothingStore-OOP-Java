package user;

import cart.Cart;
import cart.CartItem;

public class Customer extends User{
    private Cart cart ;
    private double balance ;
    public Customer(String name , String password , String email , double balance){
        super(name,email,password);
        cart = new Cart();
        setBalance(balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance < 0){
            throw new IllegalArgumentException("Balance must be >= 0");
        }
        this.balance = balance;
    }

    public Cart getCart() { return cart; }


    public void increaseBalance(double quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += quantity;
    }

    public void decreaseBalance(double quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (quantity > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= quantity;
    }

    public void addToCart(CartItem cartItem){
        cart.addItem(cartItem);
    }

    public void removeFromCart(CartItem cartItem){
        cart.removeItem(cartItem);
    }
    public double checkout() {
        double total = cart.calculateTotal();
        decreaseBalance(total);
        return total;
    }
}
