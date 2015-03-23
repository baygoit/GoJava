package ua.goit.adapter;

import ua.goit.managers.*;
import ua.goit.model.*;


public class GroupAdapterJSON {
 StringBuilder result = new StringBuilder("");
 Serializer serializer;
  public String serialize(ContainerShapes container){
   GroupShapes group = (GroupShapes) container;
   result.append("{");
	 for (int i = 0; i < group.size(); i++){
	  if (group.get(i) == null)
	  {
	   result.append("null:{null},");
	  } else if (group.get(i).getType() == Types.GROUP){
       result.append(serialize(group.get(i)));
      } else {
       result.append("{");
       serializer = SerializerFactory.getSerializer(SerializerType.JSON);
       result.append(serializer.serialize(container));
       result.append("}");
      } 
	 }
	result.append("}");
	return result.toString();
  }
}
