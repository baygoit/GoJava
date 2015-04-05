package ua.goit.graphElements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class for group of element
 */
public class GroupImpl implements Group {
    private List<Element> alElement = new ArrayList<Element>();
    private List<Group> alGroup = new ArrayList<Group>();
    private String name;

    /** 
     * Constructor to name group
     * 
     * @param name Group name
     */
    public GroupImpl(String name) {
	this.name = name;	
    }

    /**
     * Return group name
     * 
     * @return group name
     */
    @Override
    public String getName() {
	return name;
    }

    /**
     * Return list of inner elements
     * 
     * @return list of group elements
     */
    @Override
    public List<Element> getElements() {
	return alElement;
    }

    /** 
     * Return list of inner groups
     * 
     * @return list of inner groups
     */
    @Override
    public List<Group> getGroups() {
	return alGroup;
    }

    /** 
     * Add element to group
     * 
     * @param element single element
     */
    @Override
    public void setElement(Element element) {
	alElement.add(element);
    }

    /** Add inner group
     * 
     * @param group single group
     */
    @Override
    public void setGroup(Group group) {
	alGroup.add(group);
    }

    /** 
     * Return type
     * 
     * @return type of group
     */
    @Override
    public String getType() {
	return "group";
    }
}
