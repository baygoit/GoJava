package groups;

import serializers.SerializeManager;
import serializers.SerializerType;
import serializers.StringSerializable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Alex on 22.03.2015.
 */
public class Group extends ArrayList<StringSerializable> implements StringSerializable {

  @Override
  public String serialize(SerializerType type) {
    return new SerializeManager().getSerializedValue(this, type);
  }
}
