package ua.goit.shapeserializer;

import ua.goit.shapeserializer.json.ShapeJSONSerializer;


public class SerializerFactory {

  public static SerializeClassHolder getSerializerFor(String type) {
    if ("XML".equals(type.toUpperCase())) {
      return new SerializeXMLClassHolder();
    } else if ("JSON".equals(type.toUpperCase())) {
      return new SerializeJSONClassHolder();
    } else {
      throw new IllegalArgumentException("\"xml\" or \"json\" expeted.");
    }
  }

}
