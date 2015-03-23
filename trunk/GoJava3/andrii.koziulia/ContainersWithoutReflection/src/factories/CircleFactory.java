package factories;

import shapes.Circle;
import shapes.Point;

/**
 * Created by Alex on 22.03.2015.
 */
public class CircleFactory implements AbstractShapeFactory {

  @Override
  public Circle getShape() {
    return new Circle();
  }

  public Circle getShape(Point center, int radius) {
    return new Circle(center, radius);
  }
}
