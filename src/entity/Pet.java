package entity;

public class Pet {
  
  private int idNum;
  private String species;
  private String name;
  private String color;
  private int age;
  
  public Pet(int idNum, String species, String name, String color, int age) {
    this.setIdNum(idNum);
    this.setSpecies(species);
    this.setName(name);
    this.setColor(color);
    this.setAge(age);
  }

  public int getIdNum() {
    return idNum;
  }

  public void setIdNum(int idNum) {
    this.idNum = idNum;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

}
