package ua.goit.graphElements;

import java.util.List;

/**
 * Interface for group of element
 */
public interface Group {
    public List<Element> getElements();
    public List<Group> getGroups();
    public void setElement(Element element);
    public void setGroup(Group group);
    public String getName();
    public String getType();
}
