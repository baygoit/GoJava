package ua.goit.testProject.data;

import javax.print.attribute.standard.PDLOverrideSupported;
import java.util.ArrayList;

/**
 * Created by kossovec on 24.03.2015.
 */
public interface Element {
  public void addPoint(Point point);
  public ArrayList<Point> getPoints();
  public void setType();
  public void setName();
  public String getName();
  public String getType();

}
