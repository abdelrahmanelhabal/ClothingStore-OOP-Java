package dao.interfaces;

import models.products.Product;

import java.util.List;

public interface ProductDAO {
    public boolean save(Product product);
    public boolean delete(int id);
    public boolean update(Product product , int id);
    public List<Product> getAll();
    public Product getById(int id);
}
