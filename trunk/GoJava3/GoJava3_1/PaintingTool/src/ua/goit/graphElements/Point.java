package ua.goit.graphElements;

public class Point implements IPoint {
    private int x;
    private int y;

    public Point(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public String getCoordinate() {
	return "(" + x + ", " + y + ")";
    }
}
