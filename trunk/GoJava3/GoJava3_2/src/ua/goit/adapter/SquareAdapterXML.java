package ua.goit.adapter;

import ua.goit.model.ContainerShapes;
import ua.goit.model.Square;
import ua.goit.serializers.Serializer;

public class SquareAdapterXML implements Serializer {
  StringBuilder result = new StringBuilder();

  public String serialize(ContainerShapes container) {
    Square square = (Square) container;
    result.append("<square>");

    result.append("<point1>");
    result.append("<x>" + square.getPoint1().x + "</x>");
    result.append("<y>" + square.getPoint1().y + "</y>");
    result.append("</point1>");

    result.append("<length>" + square.getLength() + "</length>");

    result.append("</square>");
    return result.toString();
  }

}
