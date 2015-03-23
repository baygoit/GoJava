/**
 * Created by Aleksey Kurkov on 22.03.15.
 */

package ua.goit.shapeserializer.serializers.JSONserializers;

import ua.goit.shapeserializer.basicobjects.Circle;
import ua.goit.shapeserializer.basicobjects.Shape;
import ua.goit.shapeserializers.SerializeJSONClassHolder;

public class CircleJSONSerializer  extends ShapeJSONSerializer{
    @Override
    public String serialize(Shape shape) {
      StringBuilder result = new StringBuilder();
      Circle circle = (Circle) shape;
    
      result.append("\"Circle\": {");
      result.append("\"center\": {");
      result.append(new SerializeJSONClassHolder().getSerializator(circle.getCenter()).serialize(circle.getCenter()));
      result.append("}\n");
      result.append(",");
      result.append("\"radius\": ");
      result.append(circle.getRadius());    
      result.append("}\n");
      return result.toString();
    }
  }