package ua.goit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupShapes implements ContainerShapes {
  private Types type = Types.GROUP;
  private List<ContainerShapes> shapesList = new ArrayList<ContainerShapes>();

  public void add(ContainerShapes containerShapes) {
    shapesList.add(containerShapes);
  }

  public void addAll(ContainerShapes... objects) {
    Collections.addAll(shapesList, objects);
  }

  public ContainerShapes get(int index) {
    return shapesList.get(index);
  }

  public int size() {
    return shapesList.size();
  }

  @Override
  public Types getType() {
    return type;
  }
}
