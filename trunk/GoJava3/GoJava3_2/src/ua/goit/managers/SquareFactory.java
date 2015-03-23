package ua.goit.managers;

import ua.goit.model.Square;

public class SquareFactory implements ContainerShapesFactory {

  @Override
  public Square getShapeContainer() {
    return new Square();
  }
}
