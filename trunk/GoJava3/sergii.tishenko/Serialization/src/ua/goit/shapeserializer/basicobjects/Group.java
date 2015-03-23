package ua.goit.shapeserializer.basicobjects;

import java.util.ArrayList;
import java.util.List;

public class Group implements Shape {

  private List<Shape> values;

  public Group() {
    super();
    values = new ArrayList<Shape>();
  }

  public Group(List<Shape> list) {
    super();
    values = new ArrayList<Shape>(list);
  }

  public void add(Shape value) {
    values.add(value);
  }

  public void add(List<Shape> list) {
    values.addAll(list);
  }

  public void removeValue(int id) {
    if (values.size() > id) {
      values.remove(id);
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public Shape get(int id) {
    if (values.size() > id) {
      return values.get(id);
    } else {
      return null;
    }
  }

  public void clear() {
    values.clear();
  }

  public int size() {
    return values.size();
  }

public List<Shape> getValues() {
    return values;
}

public void setValues(List<Shape> values) {
    this.values = values;
}

}
