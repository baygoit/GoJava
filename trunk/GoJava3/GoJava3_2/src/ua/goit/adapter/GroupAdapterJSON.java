package ua.goit.adapter;

import ua.goit.managers.*;
import ua.goit.model.*;


public class GroupAdapterJSON implements Serializer {
 StringBuilder result = new StringBuilder("");
 Serializer serializer;

  public String serialize(ContainerShapes container){
    GroupShapes group = (GroupShapes) container;
    result.append("{group:");
    for (int i = 0; i < group.size(); i++){
      ContainerShapes localContainer = group.get(i);
      serializer = SerializerFactory.getSerializer(SerializerType.JSON);
      result.append(serializer.serialize(localContainer));
    }
    result.append("}");
    return result.toString();
  }
}
