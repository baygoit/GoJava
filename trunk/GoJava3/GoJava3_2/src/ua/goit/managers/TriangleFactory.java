package ua.goit.managers;

import ua.goit.model.*;

public class TriangleFactory implements ContainerShapesFactory {

    @Override
    public Triangle getShapeContainer() {
        return new Triangle();
    }

}
