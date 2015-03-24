package ua.goit.serializers;

import ua.goit.adapter.*;
import ua.goit.model.Types;
import java.util.HashMap;
import java.util.Map;

public final class AdapterMaps {
  private static Map<Types, Class<? extends Serializer>> XMLMap = new HashMap<Types, Class<? extends Serializer>>()
  {{
    put(Types.GROUP, GroupAdapterXML.class);
    put(Types.CIRCLE, CircleAdapterXML.class);
    put(Types.TRIANGLE, TriangleAdapterXML.class);
    put(Types.SQUARE, SquareAdapterXML.class);
  }};

  private static Map<Types, Class<? extends Serializer>> JSONMap = new HashMap<Types, Class<? extends Serializer>>()
  {{
    put(Types.GROUP, GroupAdapterJSON.class);
    put(Types.CIRCLE, CircleAdapterJSON.class);
    put(Types.TRIANGLE, TriangleAdapterJSON.class);
    put(Types.SQUARE, SquareAdapterJSON.class);
  }};

  public static Serializer getValue(Types type, SerializerType serializerType) {
    try {
      if (serializerType == SerializerType.XML) {
        return XMLMap.get(type).newInstance();
      } else if (serializerType == SerializerType.JSON) {
        return JSONMap.get(type).newInstance();
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    return null;
  }
}

