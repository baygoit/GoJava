package ua.goit.serializers;

import ua.goit.model.*;

public class XMLSerializer implements Serializer {

  @Override
  public String serialize(ContainerShapes object) {
    Serializer serializer = MapService.getAdapter(object.getType(), SerializerType.XML);
    return serializer.serialize(object);
  }
}
