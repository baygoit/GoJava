package serializers;

import groups.Group;
import shapes.Circle;
import shapes.CombinationFigure;
import shapes.Rectangle;
import shapes.Triangle;

import java.util.HashSet;

/**
 * Created by Alex on 23.03.2015.
 */
public final class SerializerClasses {
  private static HashSet<Class> stringSerializableClasses = new HashSet<Class>() {{
    add(Group.class);
    add(Triangle.class);
    add(Rectangle.class);
    add(Circle.class);
    add(CombinationFigure.class);
  }};
  
  private static HashSet<Class> finalClasses = new HashSet<Class>() {{
    add(Long.class);
    add(long.class);
    add(Integer.class);
    add(int.class);
    add(Short.class);
    add(short.class);
    add(Character.class);
    add(char.class);
    add(Byte.class);
    add(byte.class);
    add(Double.class);
    add(double.class);
    add(Float.class);
    add(float.class);
    add(Boolean.class);
    add(boolean.class);
  }};

  public static boolean finalClassesContains(Class cl) {
    return finalClasses.contains(cl);
  }

  public static boolean serializableClassesContains(Class cl) {
    return stringSerializableClasses.contains(cl);
  }
}
