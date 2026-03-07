package dao.impl;
import dao.exception.DaoException;
import dao.interfaces.ProductDAO;
import database.DBConnection;
import models.products.Product;
import java.sql.*;
import java.util.*;

public class ProductDAOImpl implements ProductDAO {
    private final Connection connection ;

    public ProductDAOImpl(){
        connection = DBConnection.getConnection();
    }

    Product processRow(ResultSet resultSet) throws SQLException{
        Product product = new Product(
                resultSet.getString("category"),
                resultSet.getString("name"),
                resultSet.getDouble("price"),
                resultSet.getInt("stock"),
                resultSet.getString("color"),
                resultSet.getString("brand"),
                resultSet.getString("material")
        ) {};
        product.setId(resultSet.getInt("id"));
        return product ;
    }

    @Override
    public boolean save(Product product) {
        final String QUERY = "INSERT INTO Product (name,stock,category,price,color,brand,material) values(?,?,?,?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getStock());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setDouble(4,product.getPrice());
            preparedStatement.setString(5,product.getColor());
            preparedStatement.setString(6,product.getBrand());
            preparedStatement.setString(7,product.getMaterial());
            int row = preparedStatement.executeUpdate();
            return row > 0 ;
        }
        catch (SQLException e){
           throw new DaoException("Failed to save product into database" , e);
        }
    }

    @Override
    public boolean delete(int id) {
        final String QUERY = "DELETE FROM Product WHERE id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setInt(1, id);
            int row = preparedStatement.executeUpdate();
            return row > 0 ;
        }
        catch (SQLException e){
            throw new DaoException("Failed to delete product from database , product id : " + id + e);
        }
    }

    @Override
    public boolean update(Product product , int id) {
       final String QUERY = "UPDATE Product set name=? , stock=? , category=? , price=? , color=? , brand=? , material=? WHERE id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getStock());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setDouble(4,product.getPrice());
            preparedStatement.setString(5,product.getColor());
            preparedStatement.setString(6,product.getBrand());
            preparedStatement.setString(7,product.getMaterial());
            preparedStatement.setInt(8,id);
            int row = preparedStatement.executeUpdate();
            return row > 0 ;
        }
        catch (SQLException e){
           throw new DaoException("Failed to update product from database , Product id : " + id + e);
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        final String QUERY = "SELECT * FROM Product";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            ResultSet resultSet = preparedStatement.executeQuery() ;
            while (resultSet.next()){
                Product product = processRow(resultSet);
                products.add(product);
            }
            return products ;
        }
        catch (SQLException e){
            throw new DaoException("Failed to get all products from database" , e);
        }
    }

    @Override
    public Product getById(int id) {
        final String QUERY = "SELECT * From Product WHERE id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setInt(1 , id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
               return processRow(resultSet);
            }
        }
        catch (SQLException e){
            throw new DaoException("Failed to get Product From database , Product id : " + id + e);
        }
        return null ;
    }
}
