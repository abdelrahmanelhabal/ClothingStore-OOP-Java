package products;

public class Clothing extends Product {
    private int size ;
    private String color , brand  , material ;
    public Clothing(String name, String category, double price, int stock ,
                    String color , int size , String material , String brand) {
        super(name, category, price, stock);
        setColor(color);
        setSize(size);
        setBrand(brand);
        setMaterial(material);
    }

    public int getSize() { return size; }

    public void setSize(int size) {
        if(size <= 0){
            throw new IllegalArgumentException("Size must be > 0");
        }
        this.size = size;
    }

    public String getColor() { return color; }

    public void setColor(String color) {
        if(color == null || color.trim().isEmpty()){
            throw new IllegalArgumentException("Color cannot be empty");
        }
        this.color = color;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) {
        if(brand == null || brand.trim().isEmpty()){
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        this.brand = brand;
    }

    public String getMaterial() { return material; }

    public void setMaterial(String material) {
        if(material == null || material.trim().isEmpty()){
            throw new IllegalArgumentException("Material cannot be empty");
        }
        this.material = material;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(
                " | Color : " + getColor() +
                        " | Size : " + getSize() +
                        " | Material : " + getMaterial() +
                        " | Brand : " + getBrand()
        );
    }
}
