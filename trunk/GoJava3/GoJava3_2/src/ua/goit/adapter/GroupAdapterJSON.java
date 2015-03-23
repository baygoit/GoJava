package ua.goit.adapter;

import ua.goit.managers.Serializer;
import ua.goit.managers.SerializerFactory;
import ua.goit.managers.SerializerType;
import ua.goit.model.ContainerShapes;
import ua.goit.model.GroupShapes;
import ua.goit.model.Types;


public class GroupAdapterJSON {
	StringBuilder result = new StringBuilder("");
	Serializer serializer;
	public String serialize(ContainerShapes container){
		GroupShapes group = (GroupShapes) container;
		result.append("{");
		for (int i = 0; i < group.size(); i++){
			if (group.get(i) == null){
				result.append("null:{null},");
			} else if (group.get(i).getType() == Types.TRIANGLE){
				result.append("{triangle:");
				serializer = SerializerFactory.getSerializer(SerializerType.JSON);
				result.append(serializer.serialize(container));
				result.append("}");
			} else if (group.get(i).getType() == Types.CIRCLE){
				result.append("{circle:");
				serializer = SerializerFactory.getSerializer(SerializerType.JSON);
				result.append(serializer.serialize(container));
				result.append("}");
			} else if (group.get(i).getType() == Types.SQUARE){
				result.append("{square:");
				serializer = SerializerFactory.getSerializer(SerializerType.JSON);
				result.append(serializer.serialize(container));
				result.append("}");
			} else if (group.get(i).getType() == Types.RECTANGLE){
				result.append("{rectangle:");
				serializer = SerializerFactory.getSerializer(SerializerType.JSON);
				result.append(serializer.serialize(container));
				result.append("}");
			} else if (group.get(i).getType() == Types.GROUP){
				result.append(serialize(group.get(i)));
			}
		}
		result.append("}");
		return result.toString();
	}
	
}
