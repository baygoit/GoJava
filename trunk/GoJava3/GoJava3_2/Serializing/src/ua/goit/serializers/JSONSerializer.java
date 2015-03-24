package ua.goit.serializers;

import ua.goit.model.*;

public class JSONSerializer implements Serializer {

  @Override
  public String serialize(ContainerShapes object) {
    Serializer serializer = AdapterMaps.getValue(object.getType(), SerializerType.JSON);
    return serializer.serialize(object);
  }
}
