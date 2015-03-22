package ua.goit.adapter;

import ua.goit.managers.*;
import ua.goit.model.*;

public class GroupAdapterXML {
	Serializer serializer;
	StringBuilder result = new StringBuilder("");
	public String serialize(ContainerShapes container){
		GroupShapes group = (GroupShapes) container;
		result.append("<group>");
		for (int i = 0; i < group.size(); i++){
			
			if (group.get(i) == null){
				result.append("<null></null>"); 
			} else if (group.get(i).getType() == Types.GROUP){
				result.append(serialize(group.get(i)));
			} else {
				serializer = SerializerFactory.getSerializer("xml");
				result.append(serializer.serialize(container));
			}
		}
		result.append("</group>");
		return result.toString();
	}
}
