package ua.goit.shapeserializer;

import ua.goit.shapeserializer.basicobjects.*;
import ua.goit.shapeserializer.json.*;

public class SerializeJSONClassHolder extends SerializeClassHolder {

  static {
    serialMap.put(Point.class, PointJSONSerializer.class);
    serialMap.put(Circle.class, CircleJSONSerializer.class);
    serialMap.put(Group.class, GroupJSONSerializer.class);
    serialMap.put(Square.class, SquareJSONSerializer.class);
    serialMap.put(Triangle.class, TriangleJSONSerializer.class);
  }


}
