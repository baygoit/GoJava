package ua.goit.serializers;

import ua.goit.adapter.*;
import ua.goit.model.Types;
import java.util.HashMap;
import java.util.Map;

public final class MapService {
  private static Map<Types, Serializer> XMLMap = new HashMap<Types, Serializer>() {
    private static final long serialVersionUID = 4843687589214561824L;
    {
      put(Types.GROUP, new GroupAdapterXML());
      put(Types.CIRCLE, new CircleAdapterXML());
      put(Types.TRIANGLE, new TriangleAdapterXML());
      put(Types.SQUARE, new SquareAdapterXML());
    }
  };

  private static Map<Types, Serializer> JSONMap = new HashMap<Types, Serializer>()
 {
    private static final long serialVersionUID = 1L;
    {
      put(Types.GROUP, new GroupAdapterJSON());
      put(Types.CIRCLE, new CircleAdapterJSON());
      put(Types.TRIANGLE, new TriangleAdapterJSON());
      put(Types.SQUARE, new SquareAdapterJSON());
    }
  };

  private static Map<SerializerType, Serializer> serializerTypeMap = new HashMap<SerializerType, Serializer>() {
    private static final long serialVersionUID = 484368758921456L;
    {
      put(SerializerType.XML, new XMLSerializer());
      put(SerializerType.JSON, new JSONSerializer());
    }
  };

  public static Serializer getAdapter(Types type, SerializerType serializerType) {
    try {
      if (serializerType == SerializerType.XML) {
        return XMLMap.get(type);
      } else if (serializerType == SerializerType.JSON) {
        return JSONMap.get(type);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Serializer getSerializer(SerializerType type) {
    try {
      return serializerTypeMap.get(type);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}

