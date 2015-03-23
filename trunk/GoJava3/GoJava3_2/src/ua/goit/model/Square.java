package ua.goit.model;

import java.awt.*;

public class Square implements Shape {
  private Types type = Types.SQUARE;
  private Point point1;
  private int length;

  public Square() {
  }

  public Square(Point point1, int length) {
    this.point1 = point1;
    this.length = length;
  }

  public Types getType() {
    return type;
  }

  public Point getPoint1() {
    return point1;
  }

  public void setPoint1(Point point1) {
    this.point1 = point1;
  }

  public int getLength() {
    return length;
  }

  public void setlength(int length) {
    this.length = length;
  }
}
