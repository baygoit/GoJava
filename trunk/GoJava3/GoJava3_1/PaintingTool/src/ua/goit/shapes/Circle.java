package ua.goit.basics.painting;

import ua.goit.basics.painting.graphElements.*;

import java.util.ArrayList;

public class Circle implements IElement {

    private ArrayList<Point> pointsList = new ArrayList();
    private String name;

    public Circle(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Circle";
    }

    @Override
    public void addPoints(Point point) {
        pointsList.add(point);
    }

    @Override
    public ArrayList<Point> getPoints() {
        return pointsList;
    }
}
