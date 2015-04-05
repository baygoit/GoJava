package ua.goit.graphElements;

import java.util.List;

/**
 * Interface for single element
 */
public interface Element {
    void addPoint(Point point);
    List<Point> getPoints();
    String getName();
}
