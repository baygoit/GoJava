package ua.goit.graphElements;

import java.util.List;

/**
 * Interface for group of element
 */
public interface Group {
    List<Element> getElements();
    List<Group> getGroups();
    void setElement(Element element);
    void setGroup(Group group);
    String getName();
    String getType();
}
