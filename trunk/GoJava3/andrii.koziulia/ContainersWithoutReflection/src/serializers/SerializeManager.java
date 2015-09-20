package serializers;

import java.util.List;

/**
 * Created by Alex on 22.03.2015.
 */
public class SerializeManager {

  public String getSerializedValue(StringSerializable object, SerializerType type) {
    if (type==SerializerType.XML) {
      return new XMLSerializers().getSerializedValue(object);
    } else if (type==SerializerType.JSON) {
      return new JsonSerializers().getSerializedValue(object);
    }
    throw new IllegalArgumentException("No such serializer type");
  }
}
