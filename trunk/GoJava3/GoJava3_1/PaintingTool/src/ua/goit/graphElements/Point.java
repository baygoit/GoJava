package ua.goit.graphElements;

public class Point {
    private int x;
    private int y;

    public void set(int x, int y) {
	this.x = x;
	this.y = y;
    }

public String getCoordinates() {
    return "(" + x + ", " + y + ")";
}
}
