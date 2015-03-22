package ua.goit.managers;

import ua.goit.model.*;

public class CircleFactory implements ContainerShapesFactory {

  @Override
  public Circle getShapeContainer() {
    return new Circle();
  }
}