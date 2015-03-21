package ua.goit.shramko.serializator.serializers;

import ua.goit.shramko.serializator.basicobjects.Shape;

public class SerializerXML implements SerializerFor {

  public String serialize(Shape shape) {
    return "XML";
  }
  
}
