package dao.interfaces;

import models.products.Product;
import models.user.User;

import java.util.List;

public interface UserDao {
    public boolean save(User user);
    public boolean delete(int id);
    public boolean update(User User , int id);
    public List<User> getAll();
    public User getById(int id);
    User getByEmail(String email);
}
