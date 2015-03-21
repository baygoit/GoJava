package ua.goit.shramko.serializator.serializers;

import ua.goit.shramko.serializator.basicobjects.Shape;

public interface SerializerFor {

  public String serialize(Shape shape);
  
}
