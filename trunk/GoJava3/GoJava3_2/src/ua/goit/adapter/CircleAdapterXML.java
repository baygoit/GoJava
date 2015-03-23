package ua.goit.adapter;

import ua.goit.managers.Serializer;
import ua.goit.model.Circle;
import ua.goit.model.ContainerShapes;

public class CircleAdapterXML implements Serializer {

  public String serialize(ContainerShapes container) {
    Circle circle = (Circle) container;
    StringBuilder xml = new StringBuilder();

    xml.append("<circle>");

    xml.append("<point1>");
    xml.append("<x>" + circle.getCenter().x + "</x>");
    xml.append("<y>" + circle.getCenter().y + "</y>");
    xml.append("</point1>");

    xml.append("<radius>" + circle.getRadius() + "</length>");

    xml.append("</circle>");

    return xml.toString();
  }

}
