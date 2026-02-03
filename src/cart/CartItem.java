package cart;

import products.Product;

public class CartItem {
    private Product product;
    private String color;
    private int size, quantity;

    public CartItem(Product product, String color, int size, int quantity) {
        setProduct(product);
        setColor(color);
        setQuantity(quantity);
        setSize(size);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be empty");
        }
        this.product = product;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be empty");
        }
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be > 0");
        }
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        this.quantity = quantity;
    }

    public double calculateTotalPrice() {
        return product.getPrice() * quantity;
    }

    public void displayCartItem() {
        product.displayInfo();
        System.out.println(" | Quantity : " + quantity);
    }

    boolean equals(CartItem other) {
        return other.getProduct().getId() == getProduct().getId() &&
                other.getColor().equals(getColor()) &&
                other.getSize() == getSize();
    }
}