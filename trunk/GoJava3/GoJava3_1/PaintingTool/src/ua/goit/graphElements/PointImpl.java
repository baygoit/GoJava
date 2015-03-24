package ua.goit.graphElements;

public class PointImpl implements Point {
    private int x;
    private int y;

    public PointImpl(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public String getCoordinate() {
	return "(" + x + ", " + y + ")";
    }
}
