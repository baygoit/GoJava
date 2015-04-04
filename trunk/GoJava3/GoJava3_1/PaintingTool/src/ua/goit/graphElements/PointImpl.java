package ua.goit.graphElements;

public class PointImpl implements Point {
    private int x;
    private int y;

    /** Point constructor*/
    public PointImpl(int x, int y) {
	this.x = x;
	this.y = y;
    }

    /** Return x coordinate*/
    public int getX() {
	return x;
    }
    
    /** Return y coordinate*/
    public int getY() {
	return y;
    }
}