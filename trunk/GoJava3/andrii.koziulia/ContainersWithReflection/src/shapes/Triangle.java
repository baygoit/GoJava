package shapes;

/**
 * Created by Alex on 22.03.2015.
 */
public class Triangle extends Shape {
  public Point point1;
  public Point point2;
  public Point point3;

  public Triangle() {
  }

  public Triangle(Point point1, Point point2, Point point3) {
    this.point1 = point1;
    this.point2 = point2;
    this.point3 = point3;
  }
}
