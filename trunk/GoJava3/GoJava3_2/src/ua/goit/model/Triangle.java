package ua.goit.model;

import java.awt.Point;

public class Triangle implements Shape {
    private Types type = Types.TRIANGLE;
    public Point point1;
    public Point point2;
    public Point point3;

    public Triangle() {
    }

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Types getType() {
        return type;
    }
}
