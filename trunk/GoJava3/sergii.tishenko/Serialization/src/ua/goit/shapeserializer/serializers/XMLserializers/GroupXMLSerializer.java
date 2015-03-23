/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.XMLserializers;
import java.util.List;

import ua.goit.shapeserializer.basicobjects.Group;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializers.SerializeXMLClassHolder;

public class GroupXMLSerializer extends ShapeXMLSerializer  {

    @Override
    public String serialize(Shape arg) {
	Group groupShapes = (Group) arg;
	StringBuilder result = new StringBuilder();
	List<Shape> shapes = groupShapes.getValues();
	SerializeXMLClassHolder classHolder = new SerializeXMLClassHolder();
	result.append("<Group>\n");
	for (Shape shape : shapes) {
	    result.append(classHolder.getSerializator(shape).serialize(shape));
	}
	result.append("</Group>\n");

	return result.toString();
    }
}