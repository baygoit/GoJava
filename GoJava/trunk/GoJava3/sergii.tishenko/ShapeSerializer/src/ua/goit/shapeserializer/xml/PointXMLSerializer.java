package ua.goit.shapeserializer.xml;

import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;

public class PointXMLSerializer extends ShapeXMLSerializer {
    
    @Override
    public String serialize(Shape shape) {
	    StringBuilder result = new StringBuilder();
	    Point point = (Point) shape;
	    result.append("<point>\n<x>");
	    result.append(point.getX() + "</x>\n<y>");
	    result.append(point.getY());
	    result.append("</y>\n</point>\n");
	    return result.toString();
	  }



}
