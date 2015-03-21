package ua.goit.shramko.serializator.basicobjects;

import java.util.ArrayList;
import java.util.List;

public class Group implements Shape {

  private List<Shape> values;
  int size;

  public void add(Shape value) {
    values.add(value);
    size++;
  }

  public void add(List<Shape> list) {
    values.addAll(list);
    size += list.size();
  }

  public void removeValue(int id) {
    if (size < id) {
      values.remove(id);
      size--;
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  public Shape get(int id) {
    if (size < id) {
      return values.get(id);
    } else {
      return null;
    }
  }

  public void clear() {
    values.clear();
    size = 0;
  }

  public Group() {
    super();
    values = new ArrayList<Shape>();
    size = 0;
  }

  public Group(List<Shape> list) {
    super();
    values = new ArrayList<Shape>(list);
    size = list.size();
  }

}
