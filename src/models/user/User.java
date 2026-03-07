package models.user;

import java.util.regex.Pattern;

public abstract class User {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private String name , email , password , role;
    private int id ;
   public User(String role , String name , String email , String password){
        setName(name);
        setEmail(email);
        setPassword(password);
        setRole(role);
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
       if(id <= 0 ){
           throw new IllegalArgumentException("Id must be > 0 ");
       }
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role == null || role.trim().isEmpty()){
            throw new IllegalArgumentException("Role cannot be empty");
        }
        this.role = role;
    }

    public String getName() { return name; }

    public void setName(String name) {
       if(name == null || name.trim().isEmpty()){
           throw new IllegalArgumentException("Name cannot be empty");
       }
        this.name = name;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email.trim();
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        if (password == null || password.length() < 8 || password.contains(" ")) {
            throw new IllegalArgumentException("Password must be at least 8 characters and contain no spaces");
        }
       this.password = password;
    }

    public String toString(){
       return "Id : " + getId() + " | Name : " + getName() +
              " | Email : " + getEmail() +
              " | Role : " + getRole() ;
    }
}
