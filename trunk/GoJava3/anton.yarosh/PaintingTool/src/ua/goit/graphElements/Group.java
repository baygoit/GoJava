package ua.goit.graphElements;
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

	private InnerIter() {
	    current = al.get(i);    
	}

	@Override
	public boolean hasNext() {
	    return current != al.get(al.size());
	}

	@Override
	public GraphElement next() {
	    GraphElement toReturn = current;
	    current = al.get(++i);
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
}
