package factories;

import shapes.Point;
import shapes.Rectangle;

/**
 * Created by Alex on 22.03.2015.
 */
public class RectangleFactory implements AbstractShapeFactory {

  @Override
  public Rectangle getShape() {
    return new Rectangle();
  }

  public Rectangle getShape(Point topLeft, int width, int height) {
    return new Rectangle(topLeft, width, height);
  }
}
