package shapes;

/**
 * Created by Alex on 22.03.2015.
 */
public class Rectangle extends Shape {
  private Point topLeft = new Point();
  private int width;
  private int height;

  public Rectangle() {
  }

  public Rectangle(Point topLeft, int width, int height) {
    this.topLeft = topLeft;
    this.width = width;
    this.height = height;
  }

  public Point getTopLeft() {
    return topLeft;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void setTopLeft(Point topLeft) {
    this.topLeft = topLeft;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public void setHeight(int height) {
    this.height = height;
  }

}
