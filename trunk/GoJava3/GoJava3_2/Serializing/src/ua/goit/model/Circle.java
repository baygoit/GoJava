package ua.goit.model;

public class Circle implements Shape {
  private int radius;
  private Point center;
  private Types type = Types.CIRCLE;

  public Circle() {

  }

  public Circle(Point center, int radius) {
    this.center = center;
    this.radius = radius;
  }

  public Types getType() {
    return type;
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public Point getCenter() {
    return center;
  }

  public void setCenter(Point center) {
    this.center = center;
  }

}
