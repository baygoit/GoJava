package ua.goit.managers;

import ua.goit.model.*;

public class TreeSerializer{
	StringBuilder result = new StringBuilder("");
	Serializer serializer;
	public String serialize(ContainerShapes container, String parseTo){
		//Group to XML
		if (container.getType() == Types.GROUP && parseTo.equals("xml")){
			GroupShapes group = (GroupShapes) container;
			result.append("<group>");
			for (int i = 0; i < group.size(); i++){
				 if (group.get(i).getType() == Types.GROUP){
					result.append(serialize(group.get(i),"xml"));
				} else {
					serializer = SerializerFactory.getSerializer("xml");
					result.append(serializer.serialize(container));
				}
			}
			result.append("</grout>");
			//Group to JSON
		} else if (container.getType() == Types.GROUP && parseTo.equals("json")){
			GroupShapes group = (GroupShapes) container;
			result.append("{");
			for (int i = 0; i < group.size(); i++){
				if (group.get(i).getType() == Types.TRIANGLE){
					result.append("{triangle:");
					serializer = SerializerFactory.getSerializer("json");
					result.append(serializer.serialize(container));
					result.append("}");
				} else if (group.get(i).getType() == Types.CIRCLE){
					result.append("{circle:");
					serializer = SerializerFactory.getSerializer("json");
					result.append(serializer.serialize(container));
					result.append("}");
				} else if (group.get(i).getType() == Types.SQUARE){
					result.append("{square:");
					serializer = SerializerFactory.getSerializer("json");
					result.append(serializer.serialize(container));
					result.append("}");
				} else if (group.get(i).getType() == Types.RECTANGLE){
					result.append("{rectangle:");
					serializer = SerializerFactory.getSerializer("json");
					result.append(serializer.serialize(container));
					result.append("}");
				} else if (group.get(i).getType() == Types.GROUP){
					result.append(serialize(group.get(i),"json"));
				}
			}
			result.append("}");
			//Triangle to json
		} else if (container.getType() == Types.TRIANGLE && parseTo.equals("json")){
			result.append("{triangle:");
			serializer = SerializerFactory.getSerializer("json");
			result.append(serializer.serialize(container));
			result.append("}");
			//Circle to json
		} else if (container.getType() == Types.CIRCLE && parseTo.equals("json")){
			result.append("{circle:");
			serializer = SerializerFactory.getSerializer("json");
			result.append(serializer.serialize(container));
			result.append("}");
			//Square to json
		} else if (container.getType() == Types.SQUARE && parseTo.equals("json")){
			result.append("{square:");
			serializer = SerializerFactory.getSerializer("json");
			result.append(serializer.serialize(container));
			result.append("}");
			//Rectangle to json
		} else if (container.getType() == Types.RECTANGLE && parseTo.equals("json")){
			result.append("{rectangle:");
			serializer = SerializerFactory.getSerializer("json");
			result.append(serializer.serialize(container));
			result.append("}");
			//All to xml
		} else {
			serializer = SerializerFactory.getSerializer("xml");
			result.append(serializer.serialize(container));
		}
		return result.toString();
	}
}

