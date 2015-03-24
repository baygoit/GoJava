package ua.goit.serializers;

import ua.goit.adapter.*;
import ua.goit.model.Types;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Alex on 24.03.2015.
 */
public class AdapterMaps {
  private static HashMap<Types, Serializer> XMLMap = new HashMap<Types, Serializer>()
  {{
    put(Types.GROUP, new GroupAdapterXML());
    put(Types.CIRCLE, new CircleAdapterXML());
    put(Types.TRIANGLE, new TriangleAdapterXML());
    put(Types.SQUARE, new SquareAdapterXML());
  }};

  private static HashMap<Types, Serializer> JSONMap = new HashMap<Types, Serializer>()
  {{
    put(Types.GROUP, new GroupAdapterJSON());
    put(Types.CIRCLE, new CircleAdapterJSON());
    put(Types.TRIANGLE, new TriangleAdapterJSON());
    put(Types.SQUARE, new SquareAdapterJSON());
  }};

  public static Iterator getIterator(SerializerType type) {
    if (type==SerializerType.XML){
      return XMLMap.entrySet().iterator();
    } else if (type==SerializerType.JSON) {
      return JSONMap.entrySet().iterator();
    } else {
      return null;
    }
  }
}