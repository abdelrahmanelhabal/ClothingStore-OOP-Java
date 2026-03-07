package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
   private final static String url ;
   private final static  String username;
   private final static String password ;

   static {
       try{
           Properties prop = new Properties() ;
           prop.load(DBConnection.class
                   .getClassLoader()
                   .getResourceAsStream("resources/config.properties"));
           url = prop.getProperty("DB_URL");
           username = prop.getProperty("DB_USER");
           password = prop.getProperty("DB_PASSWORD");
       }
       catch (IOException e){
           throw new RuntimeException("Failed to load database config", e);
       }
   }
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url,username,password);
        }
        catch (SQLException e){
            throw new RuntimeException("Filed to connect to Database");
        }
    }
}
