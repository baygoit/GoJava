/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.JSONserializers;

import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializer.basicobjects.Triangle;
import ua.goit.shapeserializer.serializers.XMLserializers.ShapeXMLSerializer;
import ua.goit.shapeserializers.SerializeClassHolder;
import ua.goit.shapeserializers.SerializeJSONClassHolder;
import ua.goit.shapeserializers.SerializerFactory;

public class TriangleJSONSerializer  extends ShapeXMLSerializer{
    
    @Override
    public String serialize(Shape shape) {
      StringBuilder result = new StringBuilder();
      Triangle triangle = (Triangle) shape;
      
      SerializeClassHolder classHolder = SerializerFactory.getSerializerFor("json");
      
      result.append("\"Triangle\" : [{ ");
      result.append(classHolder.serialize(triangle.getA()));
      result.append("},{");
      result.append(classHolder.serialize(triangle.getB()));
      result.append("},{");
      result.append(classHolder.serialize(triangle.getC()));
      result.append("}]\n");
      return result.toString();
}
}