package ua.goit.serializers;

import ua.goit.model.*;
import java.util.Iterator;
import java.util.Map;

public class JSONSerializer implements Serializer {

    @Override
    public String serialize(ContainerShapes object) {
      Iterator iterator = AdapterMaps.getIterator(SerializerType.JSON);
      while (iterator.hasNext()) {
        Map.Entry pair = (Map.Entry) iterator.next();
        if (object.getType() == pair.getKey()) {
          Serializer serializer = (Serializer) pair.getValue();
          return serializer.serialize(object);
        }
      }
      return null;
    }
}
