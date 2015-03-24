package ua.goit.graphElements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GroupImpl implements Group {
    private ArrayList <Element> alElement = new ArrayList <Element>();
    private ArrayList <Group> alGroup = new ArrayList <Group>();
    private String toReturn = "";
    private String name;

    public GroupImpl(String name) {
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
    public ArrayList<Element> getElements() {
	return alElement;
    }

    @Override
    public ArrayList<Group> getGroups() {
	return alGroup;
    }

    @Override
    public void setElement(Element element) {
	alElement.add(element);

    }

    @Override
    public void setGroup(Group group) {
	alGroup.add(group);
    }
}
