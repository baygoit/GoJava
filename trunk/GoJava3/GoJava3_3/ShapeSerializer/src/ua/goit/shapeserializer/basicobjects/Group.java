package ua.goit.shapeserializer.basicobjects;

import java.util.ArrayList;
import java.util.List;

public class Group extends Shape {

  private List<Shape> values;

  public Group() {
    super();
    values = new ArrayList<Shape>();
  }

  public Group(List<Shape> list) {
    super();
    values = new ArrayList<Shape>(list);
  }

  @Override
  public void add(Shape value) {
    values.add(value);
  }

  @Override
  public void add(List<Shape> list) {
    values.addAll(list);
  }

  @Override
  public void removeValue(int id) {
    if (values.size() > id) {
      values.remove(id);
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  @Override
  public Shape get(int id) {
    if (values.size() > id) {
      return values.get(id);
    } else {
      return null;
    }
  }

  @Override
  public void clear() {
    values.clear();
  }

  @Override
  public int size() {
    return values.size();
  }

  @Override
  public List<Shape> getValues() {
    return values;
  }

  @Override
  public void setValues(List<Shape> values) {
    this.values = values;
  }

}
