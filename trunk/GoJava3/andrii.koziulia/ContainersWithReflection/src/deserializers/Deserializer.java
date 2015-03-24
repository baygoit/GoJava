package deserializers;

import serializers.SerializerType;
import serializers.StringSerializable;

/**
 * Created by Alex on 25.03.2015.
 */
public interface Deserializer {

  StringSerializable deserialize(String serialized, SerializerType type);
}
