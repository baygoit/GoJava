package ua.goit.basics.painting;

import ua.goit.basics.painting.graphElements.*;

import java.util.ArrayList;

public class Triangle implements IElement {

    private ArrayList<Point> pointsList = new ArrayList();
    private String name;

    public Triangle(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Triangle";
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
