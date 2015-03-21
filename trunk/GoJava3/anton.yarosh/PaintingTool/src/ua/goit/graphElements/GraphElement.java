package ua.goit.graphElements;

public abstract class GraphElement {
    protected String name;
    public GraphElement(String name) {
	this.name = name;
    }

    public abstract void add(GraphElement element);
    public abstract String getName(String toReturn);
}
