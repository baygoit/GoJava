package ua.goit.managers;

import ua.goit.model.GroupShapes;

public class GroupShapesFactory implements ContainerShapesFactory {

    @Override
    public GroupShapes getShapeContainer() {
        return new GroupShapes();
    }

}
