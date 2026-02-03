package products;

public class Accessory extends Product{
    private String color , brand , type ;
    public Accessory(String name, String category, double price, int stock ,
                        String color , String brand , String type ) {
        super(name, category, price, stock);
        setColor(color);
        setType(type);
        setBrand(brand);
    }

    public String getColor() { return color; }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()){
            throw new IllegalArgumentException("Color cannot be empty");
        }
        this.color = color;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()){
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        this.brand = brand;
    }

    public String getType() { return type; }

    public void setType(String type) {
        if (type == null || type.trim().isEmpty()){
            throw new IllegalArgumentException("Type cannot be empty");
        }
        this.type = type;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(
                " | Color : " + getColor() +
                        " | Type : " + getType() +
                        " | Brand : " + getBrand()
        );
    }
}
