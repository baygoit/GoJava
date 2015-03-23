package ua.goit.managers;

import ua.goit.model.*;

import java.awt.*;

public class CircleFactory implements ContainerShapesFactory {

  @Override
  public Circle getShapeContainer() {
    return new Circle();
  }

  public Circle getShapeContainer(Point center, int radius) {
    return new Circle(center, radius);
  }
}