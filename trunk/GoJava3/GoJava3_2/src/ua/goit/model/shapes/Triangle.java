package ua.goit.model.shapes;

import ua.goit.model.Shape;
import java.awt.*;

public class Triangle implements Shape {
    private Point point1;
    private Point point2;
    private Point point3;

    Triangle() {

    }

    Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }


}
