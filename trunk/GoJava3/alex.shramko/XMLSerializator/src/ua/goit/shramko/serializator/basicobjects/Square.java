package ua.goit.shramko.serializator.basicobjects;

public class Square extends Shape {

  private Point a;
  private Point b;

  public Square() {
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

  public Square(Point a, Point b) {
    super();
    this.a = a;
    this.b = b;
  }

}
