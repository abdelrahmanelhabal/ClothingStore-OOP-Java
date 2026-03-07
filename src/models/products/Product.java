package models.products;

public abstract class Product {
    private int id ;
    private String name ;
    private double price ;
    private int stock ;
    private String category ;
    private String color ;
    private String brand ;
    private String material ;
    public Product(String category , String name, double price , int stock
            , String color , String brand , String material ){
        setName(name);
        setCategory(category);
        setPrice(price);
        setStock(stock);
        setColor(color);
        setBrand(brand);
        setMaterial(material);
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " cannot be empty");
        }
    }

    public int getId() { return id; }

    public void setId(int id){
        if(id <= 0 ){
            throw new IllegalArgumentException("Id must be > 0");
        }
        this.id = id ;
    }

    public String getName() { return name; }

    public void setName(String name) {
        validateString(name,"Name");
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
        validateString(category,"Category");
        this.category = category;
    }

    public String getColor() { return color; }

    public void setColor(String color) {
        validateString(color,"Color");
        this.color = color;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) {
        validateString(brand,"Brand");
        this.brand = brand;
    }

    public String getMaterial() { return material; }

    public void setMaterial(String material) {
        validateString(material,"Material");
        this.material = material;
    }

    @Override
    public String toString() {
        return
                "Id : " + getId() +
                        " | Name : " + getName() +
                        " | Category : " + getCategory() +
                        " | Price : " + getPrice() +
                        " | Stock : " + getStock() +
                        " | Color : " + getColor() +
                        " | Brand : " + getBrand() +
                        " | Material : " + getMaterial();

    }
}
