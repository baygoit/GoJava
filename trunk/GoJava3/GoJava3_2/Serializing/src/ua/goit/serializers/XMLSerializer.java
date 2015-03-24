package ua.goit.serializers;

import ua.goit.adapter.*;
import ua.goit.model.*;

public class XMLSerializer implements Serializer {

  @Override
  public String serialize(ContainerShapes object) {
    if (object.getType() == Types.GROUP) {
      return new GroupAdapterXML().serialize(object);
    } else if (object.getType() == Types.CIRCLE) {
      return new CircleAdapterXML().serialize(object);
    } else if (object.getType() == Types.SQUARE) {
      return new SquareAdapterXML().serialize(object);
    } else if (object.getType() == Types.TRIANGLE) {
      return new TriangleAdapterXML().serialize(object);
    }
    return null;
   }
}
