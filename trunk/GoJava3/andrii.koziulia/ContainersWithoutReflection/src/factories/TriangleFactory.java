package factories;

import shapes.Point;
import shapes.Triangle;

/**
 * Created by Alex on 22.03.2015.
 */
public class TriangleFactory implements AbstractShapeFactory {

  @Override
  public Triangle getShape() {
    return new Triangle();
  }

  public Triangle getShape(Point point1, Point point2, Point point3) {
    return new Triangle(point1, point2, point3);
  }
}
