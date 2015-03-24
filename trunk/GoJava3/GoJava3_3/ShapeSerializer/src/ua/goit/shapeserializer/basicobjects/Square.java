package ua.goit.shapeserializer.basicobjects;

public class Square extends Shape {

  private Point a;
  private Point b;

  public Square() {
    super();
  }

  public Square(Point a, Point b) {
    super();
    this.a = a;
    this.b = b;
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

}
