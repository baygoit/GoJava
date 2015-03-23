/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.JSONserializers;

import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Triangle;
import ua.goit.shapeserializer.serializers.XMLserializers.ShapeXMLSerializer;
import ua.goit.shapeserializers.SerializeJSONClassHolder;

public class TriangleJSONSerializer  extends ShapeXMLSerializer{
    
    @Override
    public String serialize(Shape shape) {
      StringBuilder result = new StringBuilder();
      Triangle triangle = (Triangle) shape;
      result.append("\"Triangle\" : [{ ");
      result.append(new SerializeJSONClassHolder().getSerializator(triangle.getA()).serialize(triangle.getA()));
      result.append("},{");
      result.append(new SerializeJSONClassHolder().getSerializator(triangle.getB()).serialize(triangle.getB()));
      result.append("},{");
      result.append(new SerializeJSONClassHolder().getSerializator(triangle.getC()).serialize(triangle.getC()));
      result.append("}]\n");
      return result.toString();
}
}