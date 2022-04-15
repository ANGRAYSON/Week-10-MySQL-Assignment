package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PetsDBConnection {
  
  private final static String CONNECTION_URL = "jdbc:mysql://localhost:3306/pets";
  private final static String USERNAME = "root";
  private final static String PASSWORD = "password";
  private static Connection connection;
  private static PetsDBConnection instance;
  
  private PetsDBConnection(Connection connection) {
    this.connection = connection;
  }
  
  public static Connection getConnected() {
    if(instance == null) {
      
      try {
        connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        instance = new PetsDBConnection(connection);
        System.out.println("Connected Successfully to Database.");
        
      } catch (SQLException e) {
        System.out.println("FAILED");
        e.printStackTrace();
      }
      
    }
    return PetsDBConnection.connection;
  }
  
}
