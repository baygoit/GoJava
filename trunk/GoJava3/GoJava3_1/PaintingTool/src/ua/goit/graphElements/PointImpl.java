package ua.goit.graphElements;

public class PointImpl implements Point {
    private int x;
    private int y;

    /* Point constructor*/
    public PointImpl(int x, int y) {
	this.x = x;
	this.y = y;
    }

    /*Return string with point coordinate*/
    public int getX() {
	return x;
    }
    
    public int getY() {
	return y;
    }
}
