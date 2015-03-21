package ua.goit.shramko.serializator;

public class Circle extends HavingID implements Groupable {

  private int radius;

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public Circle() {
    super();
  }
  
  public Circle(int radius) {
    super();
    this.radius = radius;
  }

}
