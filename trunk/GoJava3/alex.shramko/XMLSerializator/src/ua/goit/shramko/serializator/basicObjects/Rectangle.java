package ua.goit.shramko.serializator.basicObjects;

public class Rectangle implements Shape {

  private Point a;
  private Point b;

  public Rectangle() {
    super();
  }

  public Point getA() {
    return a;
  }

  public void setA(Point a) {
    this.a = a;
  }

  public Point getB() {
    return b;
  }

  public void setB(Point b) {
    this.b = b;
  }

  public Rectangle(Point a, Point b) {
    super();
    this.a = a;
    this.b = b;
  }

}
