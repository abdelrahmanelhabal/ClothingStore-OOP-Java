package service;

import dao.impl.UserDaoImpl;
import dao.interfaces.UserDao;
import models.user.User;

import java.util.List;

public class UserService {
   final private UserDao userDao ;

   public UserService(){
       userDao = new UserDaoImpl();
   }

   public boolean saveUser(User user){
       User existingUser = userDao.getByEmail(user.getEmail());

       if(existingUser != null){
           throw new IllegalArgumentException("Email already exists");
       }

       return userDao.save(user);
   }

   public boolean deleteUser(int id){
       return userDao.delete(id);
   }

   public boolean updateUser(User user , int id){
       return userDao.update(user,id);
   }

   public List<User> getAllUsers(){
       return userDao.getAll();
   }

   public User getUserById(int id){
       return userDao.getById(id);
   }
}
