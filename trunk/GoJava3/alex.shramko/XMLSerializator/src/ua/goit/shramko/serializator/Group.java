package ua.goit.shramko.serializator;

import java.util.ArrayList;
import java.util.List;

public class Group extends HavingID implements Groupable {
  
  private List<Groupable> values;
  int size;
  
  public void add(Groupable value) {
    values.add(value);
    size++;
  }
  
  public void add(List<Groupable> list) {
    values.addAll(list);
    size+=list.size();
  }
  
  public void removeValue(int id) {
    if (size < id) {
      values.remove(id);
      size--;
    } else {
      throw new IndexOutOfBoundsException();
    }
  }
  
  public Groupable get(int id) {
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
    values = new ArrayList<Groupable>();
    size = 0;
    setID();
  }
  
  public Group(List<Groupable> list) {
    super();
    values = new ArrayList<Groupable>(list);
    size = list.size();
    setID();
  }

}
