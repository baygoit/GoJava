package ua.goit.adapter;

import ua.goit.model.*;
import ua.goit.serializers.*;

public class GroupAdapterJSON implements Serializer {

  public String serialize(ContainerShapes container) {
    StringBuilder result = new StringBuilder("");
    Serializer serializer;

    result.append("{\"type\":\"GROUP\",\"shapesList\":[");
    GroupShapes group = (GroupShapes) container;
    for (int i = 0; i < group.size(); i++) {
      ContainerShapes localContainer = group.get(i);
      serializer = MapService.getSerializer(SerializerType.JSON);
      result.append(serializer.serialize(localContainer));
      if (i != group.size() - 1) {
        result.append(",");
      }
    }
    result.append("]}");
    return result.toString();
  }
}
