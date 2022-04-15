package Application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import dao.PetsDao;
import entity.Pet;

// Create a new Java project in Eclipse
// Write a Java menu driven application that allows you to perform all four CRUD operations on your table.
public class Application {
  
  static Scanner input = new Scanner(System.in);
 
  public static PetsDao petDao = new PetsDao();

  public static void main(String[] args) {
    
    String choice = "";
    
    while(!choice.equals("0")) {
      try {
        if(choice.equals("1")) {
          adoptAPet();
        }else if(choice.equals("2")) {
          reviewPets();
        }else if(choice.equals("3")) {
          changePetName();
        }else if(choice.equals("4")) {
          givePetAway();
        }
      }catch(SQLException e) {
        e.printStackTrace();
      }
      
      System.out.println("__________________________________________________________");
      printOptions();
      choice = input.nextLine();
    }

  }
  
  public static void printOptions() {
    System.out.println("1) Adopt a pet");
    System.out.println("2) Review current pets");
    System.out.println("3) Update a pet's name");
    System.out.println("4) Give pet up for adoption");
    System.out.println("0) Exit");
  }
  
  public static void adoptAPet() throws SQLException {
    System.out.print("Species: ");
    String species = input.nextLine();
    System.out.print("Name: ");
    String name = input.nextLine();
    System.out.print("Color: ");
    String color = input.nextLine();
    System.out.print("Age: ");
    int age = Integer.parseInt(input.nextLine());
    PetsDao.createAPet(species, name, color, age);
    System.out.println("You have adopted " + name + "!");
    
  }
  
  public static void reviewPets() throws SQLException {
    List<Pet> petList = PetsDao.viewPets();
    for(Pet pet : petList) {
      System.out.println("Id Number: " + pet.getIdNum()
                       + " Species: " + pet.getSpecies()
                       + " Name : " + pet.getName()
                       + " Color: " + pet.getColor()
                       + " Age: " + pet.getAge());
    }
    
    }
  
  public static void changePetName() throws SQLException {
    System.out.print("Do you know the ID of which pet name you would like to change? Y for yes, N for no. ");
    String answer = input.nextLine();
    if(answer.equalsIgnoreCase("N")){
      System.out.println("Here is your pet list: ");
      reviewPets();
    } 
    System.out.println("Please enter the ID of the pet name you are changing: ");
    int id = Integer.parseInt(input.nextLine());
    System.out.println("Please enter new name: ");
    String name = input.nextLine();
    PetsDao.updatePetName(name, id);
    System.out.println("Name updated!");
  }
  
  public static void givePetAway() throws SQLException {
    System.out.println("Do you know the ID number of the pet you are giving away? Y for yes, N for no.");
    String answer = input.nextLine();
    if(answer.equalsIgnoreCase("N")) {
      System.out.println("Here is your list of pets: ");
      reviewPets();
    }
    System.out.println("Please enter the ID number of the pet you would like to give away: ");
    int id = Integer.parseInt(input.nextLine());
    PetsDao.deletePetFromList(id);
    System.out.println("Pet successfuly rehomed.");
  }
  
}

