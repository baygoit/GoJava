package shapes;

/**
 * Created by Alex on 22.03.2015.
 */
public class Circle extends Shape {
  public Point center = new Point();
  public int radius;

  public Circle() {
  }

  public Circle(Point center, int radius) {
    this.center = center;
    this.radius = radius;
  }
}
