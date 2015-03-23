package shapes;

/**
 * Created by Alex on 23.03.2015.
 */
public class Combination extends Shape {
  public Circle circle;
  public Rectangle rectangle;

  public Combination(Circle circle, Rectangle rectangle) {
    this.circle = circle;
    this.rectangle = rectangle;
  }
}
