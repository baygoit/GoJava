package ua.goit.shapeserializer.basicobjects;

public class Triangle extends Shape {

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

  @Override
  public Point getA() {
    return a;
  }

  @Override
  public void setA(Point a) {
    this.a = a;
  }

  @Override
  public Point getB() {
    return b;
  }

  @Override
  public void setB(Point b) {
    this.b = b;
  }

  @Override
  public Point getC() {
    return c;
  }

  @Override
  public void setC(Point c) {
    this.c = c;
  }

}
