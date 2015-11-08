package ua.goit.adapter;

import ua.goit.serializers.Serializer;
import ua.goit.model.Circle;
import ua.goit.model.ContainerShapes;

public class CircleAdapterXML implements Serializer {

  public String serialize(ContainerShapes container) {
    Circle circle = (Circle) container;
    StringBuilder xml = new StringBuilder();

    xml.append("<circle>");

    xml.append("<center>");
    xml.append("<x>" + circle.getCenter().getX() + "</x>");
    xml.append("<y>" + circle.getCenter().getY() + "</y>");
    xml.append("</center>");

    xml.append("<radius>" + circle.getRadius() + "</radius>");

    xml.append("</circle>");

    return xml.toString();
  }

}