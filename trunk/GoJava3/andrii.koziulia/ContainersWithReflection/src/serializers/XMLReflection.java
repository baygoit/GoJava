package serializers;

import groups.Group;

import java.lang.reflect.Field;

/**
 * Created by Alex on 23.03.2015.
 */
public class XMLReflection {
  private StringBuilder stringBuilder = new StringBuilder();
  private StringSerializableClasses stringSerializableClasses = new StringSerializableClasses();
  private FinalClasses finalClasses = new FinalClasses();

  public String serialize(StringSerializable object) {
    if (stringSerializableClasses.contains(object.getClass())) {
      stringBuilder.append("<" + object.getClass().getSimpleName() + ">");
    }
    if (object instanceof Group) {
      for (StringSerializable element:(Group)object) {
        serialize(element);
      }
    }
    Field[] fields = object.getClass().getFields();
    try {
      for (Field field : fields) {
        if (!finalClasses.contains(field.getType())&&!stringSerializableClasses.contains(field.getType())) {
          stringBuilder.append("<" + field.getName() + ">");
          serialize((StringSerializable) field.get(object));
          stringBuilder.append("</" + field.getName() + ">");
        } else if (!finalClasses.contains(field.getType())) {
          serialize((StringSerializable) field.get(object));
        } else {
          stringBuilder.append("<" + field.getName() + ">");
          stringBuilder.append(field.get(object));
          stringBuilder.append("</" + field.getName() + ">");
        }
      }
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e.getMessage());
    }
    if (stringSerializableClasses.contains(object.getClass())) {
      stringBuilder.append("</" + object.getClass().getSimpleName() + ">");
    }
    return stringBuilder.toString();
  }
}
