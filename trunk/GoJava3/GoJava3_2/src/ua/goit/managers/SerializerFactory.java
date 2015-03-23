package ua.goit.managers;

public class SerializerFactory {

  public static Serializer getSerializer(String serializer) {
    if (serializer.toLowerCase().equals("xml")){
      return new XMLSerializer();
    } else if (serializer.toLowerCase().equals("json")){
      return new JSONSerializer();
    } else {
      return new XMLSerializer(); 
    }

  }
}