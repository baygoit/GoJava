package ua.goit.graphElements;

import java.util.ArrayList;

public interface IGroup {
    public ArrayList<IElement> getElements();
    public ArrayList<IGroup> getGroups();
    public void setElement(IElement element);
    public void setGroup(IGroup group);
    public String getName();
    public String getType();

}
