package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Pet;

public class PetsDao {
  
  private static Connection connection;
  private final static String CREATE_A_PET_QUERY = "INSERT INTO pets(species, name, color, age) VALUES(?,?,?,?)"; 
  private final static String VIEW_PETS_QUERY = "SELECT * FROM pets";
  private final static String UPDATE_PET_NAME_QUERY = "UPDATE pets SET name = ? WHERE idNum = ?";
  private final static String DELETE_PET_FROM_DB_QUERY = "DELETE FROM pets WHERE idNum = ?";
  
  public PetsDao() {
    this.connection = PetsDBConnection.getConnected();
  }
  
  public static void createAPet(String species, String name, String color, int age) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(CREATE_A_PET_QUERY);
    ps.setString(1, species);
    ps.setString(2, name);
    ps.setString(3, color);
    ps.setInt(4, age);
    ps.executeUpdate();
  }
  
  public static List<Pet> viewPets() throws SQLException {
    Statement statement = connection.createStatement();
    ResultSet rs = statement.executeQuery(VIEW_PETS_QUERY);
    List<Pet> petList = new ArrayList<Pet>();
    while(rs.next()) {
      petList.add(populatePets(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
    }
    return petList;
  }
  
  public static Pet populatePets(int idNum, String species, String name, String color, int age) {
    return new Pet(idNum, species, name, color, age);
  }
  
  public static void updatePetName(String name, int id) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(UPDATE_PET_NAME_QUERY);
    ps.setString(1, name);
    ps.setInt(2, id);
    ps.executeUpdate();
  }
  
  public static void deletePetFromList(int id) throws SQLException {
    PreparedStatement ps = connection.prepareStatement(DELETE_PET_FROM_DB_QUERY);
    ps.setInt(1, id);
    ps.executeUpdate();
  }

}
