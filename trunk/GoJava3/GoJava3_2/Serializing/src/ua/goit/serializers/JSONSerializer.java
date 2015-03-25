package ua.goit.serializers;

import ua.goit.model.*;

public class JSONSerializer implements Serializer {

  @Override
  public String serialize(ContainerShapes object) {
    Serializer serializer = MapService.getAdapter(object.getType(), SerializerType.JSON);
    return serializer.serialize(object);
  }
}
