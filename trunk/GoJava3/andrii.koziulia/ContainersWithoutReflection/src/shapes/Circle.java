package shapes;

/**
 * Created by Alex on 22.03.2015.
 */
public class Circle extends Shape {
  private Point center = new Point();
  private int radius;

  public Circle() {
  }

  public Circle(Point center, int radius) {
    this.center = center;
    this.radius = radius;
  }

  public Point getCenter() {
    return center;
  }

  public int getRadius() {
    return radius;
  }

  public void setCenter(Point center) {
    this.center = center;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }
}
