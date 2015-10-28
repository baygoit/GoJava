package ua.goit.shapeserializer;

import ua.goit.shapeserializer.basicobjects.Circle;
import ua.goit.shapeserializer.basicobjects.Group;
import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;
import ua.goit.shapeserializer.basicobjects.Triangle;
import ua.goit.shapeserializer.json.CircleJSONSerializer;
import ua.goit.shapeserializer.json.GroupJSONSerializer;
import ua.goit.shapeserializer.json.PointJSONSerializer;
import ua.goit.shapeserializer.json.SquareJSONSerializer;
import ua.goit.shapeserializer.json.TriangleJSONSerializer;

public class SerializeJSONClassHolder extends SerializeClassHolder{

    static {
	serialMap.put(Point.class, PointJSONSerializer.class);
	serialMap.put(Circle.class, CircleJSONSerializer.class);
	serialMap.put(Group.class, GroupJSONSerializer.class);
	serialMap.put(Square.class, SquareJSONSerializer.class);
	serialMap.put(Triangle.class, TriangleJSONSerializer.class);
    }
    

}
