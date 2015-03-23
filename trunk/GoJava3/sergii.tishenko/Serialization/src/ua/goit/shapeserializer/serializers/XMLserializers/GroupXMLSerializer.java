/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.XMLserializers;
import java.util.List;

import ua.goit.shapeserializer.basicobjects.Group;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializers.SerializeClassHolder;
import ua.goit.shapeserializers.SerializeXMLClassHolder;
import ua.goit.shapeserializers.SerializerFactory;

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