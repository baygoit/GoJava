package ua.goit.shapeserializer.xml;

import ua.goit.shapeserializer.ShapeSerializer;
import ua.goit.shapeserializer.basicobjects.Shape;

public abstract class ShapeXMLSerializer implements ShapeSerializer {
  @Override
  public abstract String serialize(Shape shape);
}