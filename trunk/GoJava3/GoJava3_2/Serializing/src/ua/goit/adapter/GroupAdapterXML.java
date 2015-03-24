package ua.goit.adapter;

import ua.goit.model.*;
import ua.goit.serializers.*;

public class GroupAdapterXML implements Serializer {
  Serializer serializer;
  StringBuilder result = new StringBuilder("");

  public String serialize(ContainerShapes container) {
    GroupShapes group = (GroupShapes) container;
    result.append("<group>");
    for (int i = 0; i < group.size(); i++) {
      ContainerShapes localContainer = group.get(i);
      serializer = SerializerFactory.getSerializer(SerializerType.XML);
      result.append(serializer.serialize(localContainer));
    }
    result.append("</group>");
    return result.toString();
  }
}
