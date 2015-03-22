package ua.goit.shapeserializer.serializers;

import ua.goit.shapeserializer.basicobjects.Shape;

/**
 * Created by Aleksey Kurkov on 22.03.15.
 */
public interface SerializeFor {
  String serialize(Shape shape);
}
