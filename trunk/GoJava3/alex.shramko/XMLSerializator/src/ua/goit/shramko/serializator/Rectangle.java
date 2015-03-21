package ua.goit.shramko.serializator;

public class Rectangle extends HavingID implements Groupable {

  private int height;
  private int weight;

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Rectangle() {
    super();
  }
  
  public Rectangle(int height, int weight) {
    super();
    this.height = height;
    this.weight = weight;
  }

}
