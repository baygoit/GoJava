package ua.goit.shapeserializer.basicobjects;

public class Square implements Shape {

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

}
