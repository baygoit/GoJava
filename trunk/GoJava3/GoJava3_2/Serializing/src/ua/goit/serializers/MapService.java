package ua.goit.serializers;

import ua.goit.adapter.*;
import ua.goit.model.Types;
import java.util.HashMap;
import java.util.Map;

public final class MapService {
  private static Map<Types, Class<? extends Serializer>> XMLMap = new HashMap<Types, Class<? extends Serializer>>() {
    private static final long serialVersionUID = 4843687589214561824L;
    {
      put(Types.GROUP, GroupAdapterXML.class);
      put(Types.CIRCLE, CircleAdapterXML.class);
      put(Types.TRIANGLE, TriangleAdapterXML.class);
      put(Types.SQUARE, SquareAdapterXML.class);
    }
  };

  private static Map<Types, Class<? extends Serializer>> JSONMap = new HashMap<Types, Class<? extends Serializer>>()
 {
    private static final long serialVersionUID = 1L;
    {
      put(Types.GROUP, GroupAdapterJSON.class);
      put(Types.CIRCLE, CircleAdapterJSON.class);
      put(Types.TRIANGLE, TriangleAdapterJSON.class);
      put(Types.SQUARE, SquareAdapterJSON.class);
    }
  };

  private static Map<SerializerType, Class<? extends Serializer>> serializerTypeMap = new HashMap<SerializerType, Class<? extends Serializer>>() {
    private static final long serialVersionUID = 484368758921456L;
    {
      put(SerializerType.XML, XMLSerializer.class);
      put(SerializerType.JSON, JSONSerializer.class);
    }
  };

  public static Serializer getAdapter(Types type, SerializerType serializerType) {
    try {
      if (serializerType == SerializerType.XML) {
        return XMLMap.get(type).newInstance();
      } else if (serializerType == SerializerType.JSON) {
        return JSONMap.get(type).newInstance();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Serializer getSerializer(SerializerType type) {
    try {
      return serializerTypeMap.get(type).newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}

