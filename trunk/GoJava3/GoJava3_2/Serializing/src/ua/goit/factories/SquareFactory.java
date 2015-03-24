package ua.goit.factories;

import ua.goit.model.Point;
import ua.goit.model.Square;

public class SquareFactory implements ContainerShapesFactory {

  @Override
  public Square getShapeContainer() {
    return new Square();
  }

  public Square getShapeContainer(Point point1, int length) {
    return new Square(point1, length);
  }
}
