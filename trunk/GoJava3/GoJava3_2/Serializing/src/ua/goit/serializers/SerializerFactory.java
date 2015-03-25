package ua.goit.serializers;

public class SerializerFactory {

  public static Serializer getSerializer(SerializerType type) {
    return MapService.getSerializer(type);
  }
}