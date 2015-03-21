package ua.goit.shramko.serializator.serializers;

import ua.goit.shramko.serializator.basicobjects.Shape;

public class SerializerJSON implements SerializerFor {

  public String serialize(Shape shape) {
    return "JSON";
  }

}
