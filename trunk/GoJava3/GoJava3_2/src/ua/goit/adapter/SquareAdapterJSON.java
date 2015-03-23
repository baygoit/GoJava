package ua.goit.adapter;

import ua.goit.managers.Serializer;
import ua.goit.model.ContainerShapes;
import ua.goit.model.Square;

public class SquareAdapterJSON implements Serializer {
  StringBuilder result = new StringBuilder();

  @Override
  public String serialize(ContainerShapes container) {
    Square square = (Square) container;
    result.append("{square:");

    result.append("{point1:");
    result.append("{x:" + square.getPoint1().x + "}");
    result.append("{y:" + square.getPoint1().y + "}");
    result.append("}");

    result.append("{length:" + square.getLength() + "}");

    result.append("}");
    return result.toString();  }
}
