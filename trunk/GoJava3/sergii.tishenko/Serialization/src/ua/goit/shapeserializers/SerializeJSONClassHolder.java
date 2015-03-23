package ua.goit.shapeserializers;

import ua.goit.shapeserializer.basicobjects.Circle;
import ua.goit.shapeserializer.basicobjects.Group;
import ua.goit.shapeserializer.basicobjects.Point;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Square;
import ua.goit.shapeserializer.basicobjects.Triangle;
import ua.goit.shapeserializer.serializers.JSONserializers.CircleJSONSerializer;
import ua.goit.shapeserializer.serializers.JSONserializers.GroupJSONSerializer;
import ua.goit.shapeserializer.serializers.JSONserializers.PointJSONSerializer;
import ua.goit.shapeserializer.serializers.JSONserializers.SquareJSONSerializer;
import ua.goit.shapeserializer.serializers.JSONserializers.TriangleJSONSerializer;

public class SerializeJSONClassHolder extends SerializeClassHolder{

    static {
	serialMap.put(Point.class, PointJSONSerializer.class);
	serialMap.put(Circle.class, CircleJSONSerializer.class);
	serialMap.put(Group.class, GroupJSONSerializer.class);
	serialMap.put(Square.class, SquareJSONSerializer.class);
	serialMap.put(Triangle.class, TriangleJSONSerializer.class);
    }
    

}
