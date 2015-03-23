package serializers;

import java.util.HashSet;

/**
 * Created by Alex on 23.03.2015.
 */
public class FinalClasses extends HashSet<Class> {
  {
    this.add(Long.class);
    this.add(long.class);
    this.add(Integer.class);
    this.add(int.class);
    this.add(Short.class);
    this.add(short.class);
    this.add(Character.class);
    this.add(char.class);
    this.add(Byte.class);
    this.add(byte.class);
    this.add(Double.class);
    this.add(double.class);
    this.add(Float.class);
    this.add(float.class);
    this.add(Boolean.class);
    this.add(boolean.class);
  }
}
