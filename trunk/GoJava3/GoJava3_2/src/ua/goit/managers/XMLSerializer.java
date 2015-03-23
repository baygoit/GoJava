package ua.goit.managers;

import ua.goit.adapter.*;
import ua.goit.model.*;

public class XMLSerializer implements Serializer {

  @Override
  public String serialize(ContainerShapes object) {
    if (object instanceof GroupShapes) {
      return serialize((GroupShapes)object);
    } else if (object instanceof Circle) {
      return serialize((Circle)object);
    } else if (object instanceof Square) {
      return serialize((Square) object);
    } else if (object instanceof Triangle) {
      return serialize((Triangle) object);
    }
    return null;
   }
 
  public String serialize(GroupShapes object) {
    // TODO Auto-generated method stub
    return null;
  }

  public String serialize(Triangle object) {
    TriangleAdapterXML adapter = new TriangleAdapterXML(object);
    return adapter.serialize();
  }

  public String serialize(Circle object) {
    // TODO Auto-generated method stub
    return null;
  }

  public String serialize(Square object) {
    SquareAdapterXML adapter = new SquareAdapterXML(object);
    return adapter.serialize();
  }

}
