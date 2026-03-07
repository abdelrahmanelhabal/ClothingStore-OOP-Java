package dao.impl;
import dao.exception.DaoException;
import dao.interfaces.UserDao;
import database.DBConnection;
import models.user.User;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;
import java.util.*;

public class UserDaoImpl implements UserDao {
    private final Connection connection ;
    public UserDaoImpl(){
        connection = DBConnection.getConnection();
    }

    User processRow(ResultSet resultSet) throws SQLException{
     User user = new User(
             resultSet.getString("role"),
             resultSet.getString("username"),
            resultSet.getString("email"),
             resultSet.getString("password")
     ) {};
     user.setId(resultSet.getInt("id"));
     return user;
    }
    @Override
    public boolean save(User user) {
        final String QUERY = "INSERT INTO User (username , email , password , role) values (?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,hashedPassword);
            preparedStatement.setString(4,user.getRole());
            int row = preparedStatement.executeUpdate();
            return row > 0 ;
        }catch (SQLException e){
            throw new DaoException("Failed to save user into database");
        }
    }

    @Override
    public boolean delete(int id) {
        final String QUERY = "DELETE FROM User WHERE id =?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setInt(1 , id);
            int row = preparedStatement.executeUpdate() ;
            return row > 0 ;
        }
        catch (SQLException e){
            throw new DaoException("Failed to delete user from database , user id : " + id + e);
        }
    }

    @Override
    public boolean update(User user, int id) {
        final String QUERY = "UPDATE User SET username=? , email=? , password=? , role=? WHERE id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            String password = user.getPassword();

            if (!password.startsWith("$2a$")) {
                password = BCrypt.hashpw(password, BCrypt.gensalt());
            }

            preparedStatement.setString(1 , user.getName());
            preparedStatement.setString(2 , user.getEmail());
            preparedStatement.setString(3 , password);
            preparedStatement.setString(4 , user.getRole());
            preparedStatement.setInt(5 , id);
            int row = preparedStatement.executeUpdate();
            return row > 0 ;
        }
        catch (SQLException e){
            throw new DaoException("Failed to update user from database , user id : " + id + e);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        final String QUERY = "SELECT * FROM User";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            ResultSet resultSet = preparedStatement.executeQuery() ;
            while (resultSet.next()){
                User user = processRow(resultSet);
                users.add(user);
            }
            return users;
        }
        catch (SQLException e){
            throw new DaoException("Failed to get all user form database");
        }
    }

    @Override
    public User getById(int id) {
        final String QUERY = "SELECT  * FROM User WHERE id =?" ;
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setInt(1 , id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            if(resultSet.next()){
                return processRow(resultSet);
            }
        }
        catch (SQLException e){
            throw new DaoException("Failed to get product from database , product id : " + id + e);
        }
        return null ;
    }

    @Override
    public User getByEmail(String email) {

        final String QUERY = "SELECT id, username, email, password, role FROM User WHERE email = ?";

        try (PreparedStatement prepareStatement = connection.prepareStatement(QUERY)) {
            prepareStatement.setString(1, email);
            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()) {
                return processRow(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new DaoException("Failed to get user by email: " + email, e);
        }
    }
}
