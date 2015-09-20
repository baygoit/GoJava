/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.xml;
import java.util.List;

import ua.goit.shapeserializer.SerializeClassHolder;
import ua.goit.shapeserializer.SerializeXMLClassHolder;
import ua.goit.shapeserializer.SerializerFactory;
import ua.goit.shapeserializer.basicobjects.Group;
import ua.goit.shapeserializer.basicobjects.Shape;

public class GroupXMLSerializer extends ShapeXMLSerializer  {

    @Override
    public String serialize(Shape arg) {
	Group groupShapes = (Group) arg;
	StringBuilder result = new StringBuilder();
	List<Shape> shapes = groupShapes.getValues();
	
        SerializeClassHolder classHolder = SerializerFactory.getSerializerFor("xml");
	//  result.append(new SerializeXMLClassHolder().getSerializator(shape).serialize(circle.getCenter()));
	result.append("<Group>\n");
	for (Shape shape : shapes) {
	    result.append(classHolder.serialize(shape));
	}
	result.append("</Group>\n");

	return result.toString();
    }
}