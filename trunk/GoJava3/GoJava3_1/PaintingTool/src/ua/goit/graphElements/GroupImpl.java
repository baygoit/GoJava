package ua.goit.graphElements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class for group of element
 */
public class GroupImpl implements Group {
    private ArrayList<Element> alElement = new ArrayList<Element>();
    private ArrayList<Group> alGroup = new ArrayList<Group>();
    private String name;

    /** Constructor to name group*/
    public GroupImpl(String name) {
	this.name = name;	
    }

    /** Return group name*/
    @Override
    public String getName() {
	return name;
    }

    /** Return list of inner elements*/
    @Override
    public ArrayList<Element> getElements() {
	return alElement;
    }

    /** Return list of inner groups*/
    @Override
    public ArrayList<Group> getGroups() {
	return alGroup;
    }

    /** Add element to group*/
    @Override
    public void setElement(Element element) {
	alElement.add(element);
    }

    /** Add inner group*/
    @Override
    public void setGroup(Group group) {
	alGroup.add(group);
    }

    @Override
    public String getType() {
	return "group";
    }
}
