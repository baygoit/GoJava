package ua.goit.model.shapes;

import ua.goit.model.Shape;
import java.awt.*;

public class Circle implements Shape {
    private int radius;
    private Point center;

    Circle() {

    }

    Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

}
