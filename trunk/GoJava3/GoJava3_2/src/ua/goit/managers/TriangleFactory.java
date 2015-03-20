package ua.goit.managers;

import ua.goit.model.*;

public class TriangleFactory implements ShapeFactory {

    @Override
    public Triangle getShape() {
        return new Triangle();
    }

}
