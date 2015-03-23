package shapes;

import serializers.SerializeManager;
import serializers.SerializerType;
import serializers.StringSerializable;

/**
 * Created by Alex on 22.03.2015.
 */
public abstract class Shape implements StringSerializable {

  @Override
  public String serialize(SerializerType type) {
    return new SerializeManager().getSerializedValue(this, type);
  }
}
