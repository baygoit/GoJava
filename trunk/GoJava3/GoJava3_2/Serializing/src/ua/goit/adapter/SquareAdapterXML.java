package ua.goit.adapter;

import ua.goit.model.ContainerShapes;
import ua.goit.model.Square;
import ua.goit.serializers.Serializer;

public class SquareAdapterXML implements Serializer {

  public String serialize(ContainerShapes container) {
    StringBuilder result = new StringBuilder();
    Square square = (Square) container;
    result.append("<square>");

    result.append("<point1>");
    result.append("<x>" + square.getTopLeft().getX() + "</x>");
    result.append("<y>" + square.getTopLeft().getY() + "</y>");
    result.append("</point1>");

    result.append("<length>" + square.getLength() + "</length>");

    result.append("</square>");
    return result.toString();
  }

}
