package ua.goit.graphElements;

import java.io.IOException;
import java.util.ArrayList;

public abstract class GraphElement implements Iterable <GraphElement> {
    protected String name;
    public GraphElement(String name) {
	this.name = name;
    }

    public abstract void add(GraphElement element);
    public abstract String getName();
    public abstract boolean isElement();
    public abstract String getType();
    public abstract ArrayList <Point> getPoints();
    public abstract void setPoints(ArrayList <Point> pointsList);
}