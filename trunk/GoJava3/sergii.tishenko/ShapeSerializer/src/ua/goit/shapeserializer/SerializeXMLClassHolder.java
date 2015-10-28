package ua.goit.shapeserializer;

import ua.goit.shapeserializer.basicobjects.*;
import ua.goit.shapeserializer.xml.*;

public class SerializeXMLClassHolder extends SerializeClassHolder{

    static {
	serialMap.put(Point.class, PointXMLSerializer.class);
	serialMap.put(Circle.class, CircleXMLSerializer.class);
	serialMap.put(Group.class, GroupXMLSerializer.class);
	serialMap.put(Square.class, SquareXMLSerializer.class);
	serialMap.put(Triangle.class, TriangleXMLSerializer.class);
    }

}
