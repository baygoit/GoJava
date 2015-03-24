package ua.goit.serializers;

import ua.goit.adapter.*;
import ua.goit.model.*;

public class JSONSerializer implements Serializer {

    @Override
    public String serialize(ContainerShapes object) {
      if (object.getType() == Types.GROUP) {
        return new GroupAdapterJSON().serialize(object);
      } else if (object.getType() == Types.CIRCLE) {
        return new CircleAdapterJSON().serialize(object);
      } else if (object.getType() == Types.SQUARE) {
        return new SquareAdapterJSON().serialize(object);
      } else if (object.getType() == Types.TRIANGLE) {
        return new TriangleAdapterJSON().serialize(object);
      }
      return null;
     }
}
