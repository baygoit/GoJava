package ua.goit.managers;

import ua.goit.adapter.*;
import ua.goit.model.*;

public class JSONSerializer implements Serializer {

    @Override
    public String serialize(ContainerShapes object) {
      if (object.getType() == Types.GROUP) {
        return serialize((GroupShapes)object);
      } else if (object.getType() == Types.CIRCLE) {
        return serialize((Circle)object);
      } else if (object.getType() == Types.SQUARE) {
        return serialize((Square) object);
      } else if (object.getType() == Types.TRIANGLE) {
        return serialize((Triangle) object);
      }
      return null;
     }
   
    public String serialize(GroupShapes object) {
      GroupAdapterJSON adapter = new GroupAdapterJSON();
      return adapter.serialize(object);
    }

    public String serialize(Triangle object) {
      TriangleAdapterJSON adapter = new TriangleAdapterJSON(object);
      return adapter.serialize();
    }

    public String serialize(Circle object) {
      CircleAdapterJSON adapter = new CircleAdapterJSON(object);
      return adapter.serialize();
    }

    public String serialize(Square object) {
      SquareAdapterJSON adapter = new SquareAdapterJSON(object);
      return adapter.serialize();
    }


}
