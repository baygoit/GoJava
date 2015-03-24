package ua.goit.graphElements;

public class Point implements IPoint {
    private int x;
    private int y;

    public void set(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public String getCoordinate() {
	return "(" + x + ", " + y + ")";
    }
}
