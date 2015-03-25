package ua.goit.adapter;

import ua.goit.model.*;
import ua.goit.serializers.*;

public class GroupAdapterXML implements Serializer {

  public String serialize(ContainerShapes container) {
    Serializer serializer;
    StringBuilder result = new StringBuilder("");

    GroupShapes group = (GroupShapes) container;
    result.append("<group>");
    for (int i = 0; i < group.size(); i++) {
      ContainerShapes localContainer = group.get(i);
      serializer = MapService.getSerializer(SerializerType.XML);
      result.append(serializer.serialize(localContainer));
    }
    result.append("</group>");
    return result.toString();
  }
}
