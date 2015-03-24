package ua.goit.graphElements;

import java.util.ArrayList;

public interface IElement {

    public void addPoint(Point point);
    public ArrayList<Point> getPoints();
    public void setName();
    public String getName();
    public String getType();
  }
