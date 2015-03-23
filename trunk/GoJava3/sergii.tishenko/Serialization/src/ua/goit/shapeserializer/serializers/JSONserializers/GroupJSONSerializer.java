/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.JSONserializers;

import java.util.List;

import ua.goit.shapeserializer.basicobjects.Group;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializers.SerializeJSONClassHolder;



public class GroupJSONSerializer extends ShapeJSONSerializer{
    
    @Override
    public String serialize(Shape arg) {
	Group groupShapes = (Group) arg;
	StringBuilder result = new StringBuilder();
	List<Shape> shapes = groupShapes.getValues();
	SerializeJSONClassHolder classHolder = new SerializeJSONClassHolder();
	result.append("\"Group\": \n");
	result.append("[\n");
	for (Shape shape : shapes) {
	    result.append("{\n");
	    result.append(classHolder.getSerializator(shape).serialize(shape));
	    result.append("}\n");
	    result.append(",");
	    
	}
	
	result.delete(result.length() - 1, result.length() );
	
	result.append("]\n");


	return result.toString();
    }    
}