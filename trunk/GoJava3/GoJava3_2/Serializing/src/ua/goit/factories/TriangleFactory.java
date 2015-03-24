package ua.goit.factories;

import ua.goit.model.*;

import java.awt.*;

public class TriangleFactory implements ContainerShapesFactory {

  @Override
  public Triangle getShapeContainer() {
    return new Triangle();
  }

  public Triangle getShapeContainer(Point point1, Point point2, Point point3) {
    return new Triangle(point1, point2, point3);
  }
}
