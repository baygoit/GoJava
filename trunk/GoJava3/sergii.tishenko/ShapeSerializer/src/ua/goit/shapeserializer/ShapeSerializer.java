package ua.goit.shapeserializer;

import ua.goit.shapeserializer.basicobjects.Shape;

/**
 * Created by Aleksey Kurkov on 22.03.15.
 */
public interface ShapeSerializer {
  public String serialize(Shape shape);
}
