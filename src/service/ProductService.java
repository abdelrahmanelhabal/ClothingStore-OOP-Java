package service;
import dao.impl.ProductDAOImpl;
import dao.interfaces.ProductDAO;
import models.products.Product;
import java.util.List;

public class ProductService {
    final private ProductDAO productDAO ;

    public ProductService(){
        productDAO = new ProductDAOImpl();
    }

    public boolean saveProduct(Product product){
        return productDAO.save(product);
    }

    public boolean deleteProduct(int id){
      return productDAO.delete(id);
    }

    public boolean updateProduct(Product product , int id){
        return productDAO.update(product,id);
    }

    public List<Product> getAllProducts(){
        return productDAO.getAll();
    }

    public Product getProductById(int id){
        return productDAO.getById(id);
    }
}
