package ua.goit.shapeserializer.basicobjects;

public class Circle extends Shape {

  private int radius;
  private Point center;

  public Circle() {
    super();
  }

  public Circle(int radius, Point center) {
    super();
    this.radius = radius;
    this.center = center;
  }

  @Override
  public Point getCenter() {
    return center;
  }

  @Override
  public void setCenter(Point center) {
    this.center = center;
  }

  @Override
  public int getRadius() {
    return radius;
  }

  @Override
  public void setRadius(int radius) {
    this.radius = radius;
  }

}
