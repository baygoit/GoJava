package serializers;

/**
 * Created by Alex on 22.03.2015.
 */
public class SerializeManager {

  public String getSerializedValue(StringSerializable object, SerializerType type) {
    if (type==SerializerType.XML) {
      return new XMLSerializer().serialize(object);
    } else if (type==SerializerType.JSON) {
      return new JsonSerializer().serialize(object);
    }
    throw new IllegalArgumentException("No such serializer type");
  }
}
