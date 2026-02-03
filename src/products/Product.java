package products;

public abstract class Product {
    private static int idCount = 0 ;
    private final int id ;
    private String name ;
    private double price ;
    private int stock ;
    private String category ;

    public Product(String name , String category , double price , int stock){
        this.id = ++idCount ;
        setName(name);
        setCategory(category);
        setPrice(price);
        setStock(stock);
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getPrice() { return price; }

    public void setPrice(double price){
        if(price < 0){
            throw new IllegalArgumentException("Price must be >= 0");
        }
        this.price = price;
    }

    public int getStock() { return stock; }

    public void setStock(int stock) {
        if(stock < 0){
            throw new IllegalArgumentException("Stock must be >= 0");
        }
        this.stock = stock;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.category = category;
    }


    public void increaseStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        stock += quantity;
    }

    public void decreaseStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > stock){
            throw new IllegalArgumentException("Insufficient stock");
        }
        stock -= quantity;
    }

    public void displayInfo() {
        System.out.print(
                "Id : " + getId() +
                        " | Name : " + getName() +
                        " | Category : " + getCategory() +
                        " | Price : " + getPrice() +
                        " | Stock : " + getStock()
        );
    }
}
