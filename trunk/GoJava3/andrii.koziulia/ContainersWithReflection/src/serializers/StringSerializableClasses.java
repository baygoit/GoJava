package serializers;

import groups.Group;
import shapes.Circle;
import shapes.Combination;
import shapes.Rectangle;
import shapes.Triangle;

import java.util.HashSet;

/**
 * Created by Alex on 23.03.2015.
 */
public class StringSerializableClasses extends HashSet<Class> {
  {
    this.add(Group.class);
    this.add(Triangle.class);
    this.add(Rectangle.class);
    this.add(Circle.class);
    this.add(Combination.class);
  }
}
