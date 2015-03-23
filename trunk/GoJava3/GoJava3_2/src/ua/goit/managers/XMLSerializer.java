package ua.goit.managers;

import ua.goit.adapter.*;
import ua.goit.model.*;

public class XMLSerializer implements Serializer {

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
    GroupAdapterXML adapter = new GroupAdapterXML();
    return adapter.serialize(object);
  }

  public String serialize(Triangle object) {
    TriangleAdapterXML adapter = new TriangleAdapterXML();
    return adapter.serialize(object);
  }

  public String serialize(Circle object) {
    CircleAdapterXML adapter = new CircleAdapterXML();
    return adapter.serialize(object);
  }

  public String serialize(Square object) {
    SquareAdapterXML adapter = new SquareAdapterXML();
    return adapter.serialize(object);
  }

}
