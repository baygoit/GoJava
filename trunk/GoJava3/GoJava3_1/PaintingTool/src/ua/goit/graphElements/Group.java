package ua.goit.graphElements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Group extends GraphElement {
    ArrayList <GraphElement> al = new ArrayList <GraphElement>();
    String toReturn = "";
    public Group(String name) {
	super(name);	
    }

    @Override
    public void add(GraphElement element) {
	al.add(element);	
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public Iterator iterator() {
	return new InnerIter ();
    }

    private class InnerIter implements Iterator {
	private GraphElement current;
	private int i = 0;

	@Override
	public boolean hasNext() {
	    if (al.size() == 0) {
		return false;
	    }
	    else {
		return current != al.get(al.size() - 1);
	    }
	}

	@Override
	public GraphElement next() {
	    current = al.get(i);
	    GraphElement toReturn = current;
	    if (i < al.size() - 1) {
		current = al.get(i++);
	    }
	    return toReturn;
	}

	@Override
	public void remove() {
	    al.remove(i);
	}
    }

    @Override
    public boolean isElement() {
	return false;
    }

    @Override
    public String getType() {
	return "Group";
    }

    @Override
    public ArrayList<Point> getPoints() {
	return null;
    }

    @Override
    public void setPoints(ArrayList<Point> pointsList) {

    }
}
