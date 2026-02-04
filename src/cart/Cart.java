package cart;

import products.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    private List<CartItem> items ;
    public Cart(){
        items = new ArrayList<CartItem>();
    }

    public void addItem(CartItem item){
        for(CartItem cartItem : items){
            if(cartItem.equals(item)) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        items.add(new CartItem(item.getProduct(),item.getColor(),item.getSize(),item.getQuantity()));
    }

    public void removeItem(CartItem item) {
        Iterator<CartItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next();
            if (cartItem.equals(item)) {
                int newQuantity = cartItem.getQuantity() - item.getQuantity();

                if (newQuantity > 0) {
                    cartItem.setQuantity(newQuantity);
                } else {
                    iterator.remove();
                }
                return;
            }
        }
        throw new IllegalArgumentException("This item is not in the cart!");
    }

    public double calculateTotal(){
        double res = 0 ;
        for(CartItem cartItem : this.items){
            res += cartItem.calculateTotalPrice();
        }
        return res;
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }
}
