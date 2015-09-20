package ua.goit.shapes;


import ua.goit.graphElements.Element;
import ua.goit.graphElements.Point;

import java.util.ArrayList;
import java.util.List;

public class Square implements Element {

  private List<Point> pointsList = new ArrayList();
  private String name;

  public Square(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void addPoint(Point point) {
    pointsList.add(point);
  }

  @Override
  public List<Point> getPoints() {
    return pointsList;
  }
}
