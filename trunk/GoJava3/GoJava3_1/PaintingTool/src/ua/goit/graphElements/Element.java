package ua.goit.graphElements;

import java.util.ArrayList;

/**
 * Interface for single element
 * @author Anton Yarosh
 *
 */
public interface Element {

    public void addPoint(Point point);
    public ArrayList<Point> getPoints();
    public String getName();
    public String getType();
}
