package shapes;

/**
 * Created by Alex on 23.03.2015.
 */
public class CombinationFigure extends Shape {
  public Circle circle;
  public Rectangle rectangle;

  public CombinationFigure(Circle circle, Rectangle rectangle) {
    this.circle = circle;
    this.rectangle = rectangle;
  }
}
