package ua.goit.model;

import java.awt.Point;

public class Triangle implements Shape {
    private Types type = Types.TRIANGLE;
	
    public Point point1;
    public Point point2;
    public Point point3;
    
    public Types getType() {
        return type;
    }
}
