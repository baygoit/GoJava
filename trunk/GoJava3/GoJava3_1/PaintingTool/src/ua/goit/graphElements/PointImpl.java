package ua.goit.graphElements;

public class PointImpl implements Point {
    private int x;
    private int y;

    /** 
     * Point constructor
     * @param x point x coordinate
     * @param y point y coordinate
     */
    public PointImpl(int x, int y) {
	this.x = x;
	this.y = y;
    }

    /** 
     * Return x coordinate
     * @return x coordinate
     */
    public int getX() {
	return x;
    }

    /**
     * Return y coordinate
     * @return y coordinate
     */
    public int getY() {
	return y;
    }
}