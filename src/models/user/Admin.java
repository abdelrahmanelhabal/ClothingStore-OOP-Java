package models.user;

public class Admin extends User{
    public Admin(String username , String password , String email){
        super("Admin",username,email,password);
    }
}
