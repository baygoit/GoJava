package ua.goit.graphElements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Group implements IGroup {
    private ArrayList <IElement> alElement = new ArrayList <IElement>();
    private ArrayList <IGroup> alGroup = new ArrayList <IGroup>();
    private String toReturn = "";
    private String name;

    public Group(String name) {
	this.name = name;	
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public String getType() {
	return "Group";
    }

    @Override
    public ArrayList<IElement> getElements() {
	return alElement;
    }

    @Override
    public ArrayList<IGroup> getGroups() {
	return alGroup;
    }

    @Override
    public void setElement(IElement element) {
	alElement.add(element);

    }

    @Override
    public void setGroup(IGroup group) {
	alGroup.add(group);
    }
}
