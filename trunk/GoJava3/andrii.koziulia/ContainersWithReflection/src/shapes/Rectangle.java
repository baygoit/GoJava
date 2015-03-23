package shapes;

/**
 * Created by Alex on 22.03.2015.
 */
public class Rectangle extends Shape {
  public Point topLeft;
  public int width;
  public int height;

  public Rectangle() {
  }

  public Rectangle(Point topLeft, int width, int height) {
    this.topLeft = topLeft;
    this.width = width;
    this.height = height;
  }
}
