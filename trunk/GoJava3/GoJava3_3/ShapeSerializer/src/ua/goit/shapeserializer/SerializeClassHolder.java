package ua.goit.shapeserializer;

import ua.goit.shapeserializer.basicobjects.Shape;

import java.util.HashMap;
import java.util.Map;

public abstract class SerializeClassHolder {
  static Map<Object, Object> serialMap;

  static {
    serialMap = new HashMap<Object, Object>();
  }

  public static ShapeSerializer getSerializator(Shape arg) {

    Object clazz = serialMap.get(arg.getClass());

    if (clazz == null) {
      throw new UnsupportedOperationException();
    }

    try {
      return ((Class<? extends ShapeSerializer>) clazz).newInstance();

    } catch (InstantiationException | IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }


  public String serialize(Shape arg) {

    Object clazz;
    clazz = serialMap.get(arg.getClass());
    ShapeSerializer shapeSerializer = null;
    if (clazz == null) {
      throw new UnsupportedOperationException("Unknown serializer for " + arg.toString());
    }
    try {
      shapeSerializer = ((Class<? extends ShapeSerializer>) clazz).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return shapeSerializer.serialize(arg);
  }


  public String innerSerialize(Shape arg) {

    return this.serialize(arg);

  }
}