package ua.goit.testProject.data;

import java.util.ArrayList;

/**
 * Created by kossovec on 24.03.2015.
 */
public interface Group {
  public ArrayList<Element> getElements();
  public ArrayList<Group> getGroups();
  public void setElement(Element element);
  public void setGroup(Group group);

}
