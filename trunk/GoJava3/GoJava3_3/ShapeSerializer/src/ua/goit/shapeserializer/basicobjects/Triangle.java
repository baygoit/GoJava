package ua.goit.shapeserializer.basicobjects;

public class Triangle implements Shape {

  private Point a;
  private Point b;
  private Point c;

  public Triangle() {
    super();
  }

  public Triangle(Point a, Point b, Point c) {
    super();
    this.a = a;
    this.b = b;
    this.c = c;
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

  public Point getC() {
    return c;
  }

  public void setC(Point c) {
    this.c = c;
  }

}
