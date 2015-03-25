package ua.goit.model;

public class Square implements Shape {
  private Types type = Types.SQUARE;
  private Point topLeft;
  private int length;

  public Square() {
  }

  public Square(Point topLeft, int length) {
    this.topLeft = topLeft;
    this.length = length;
  }

  public Types getType() {
    return type;
  }

  public Point getTopLeft() {
    return topLeft;
  }

  public void setTopLeft(Point topLeft) {
    this.topLeft = topLeft;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }
}
