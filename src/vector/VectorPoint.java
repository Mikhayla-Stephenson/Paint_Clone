package vector;

import java.util.Arrays;
import java.util.List;

/**
 * The x and y points of a key point of a shape. Must be between 0 and 1
 */
public class VectorPoint implements Point {
    private double x;
    private double y;

    public double getX() { return x; }
    public double getY() { return y; }

    VectorPoint(double x, double y) throws IllegalArgumentException {
        if (x > 1 || x < 0 || y > 1 || y < 0) { throw new IllegalArgumentException("Invalid point"); }
        this.x = x;
        this.y = y;
    }

    VectorPoint(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    /**
     * Updates this point with the values of newPoint
     * @param newPoint
     */
    void update(Point newPoint) {
        x = newPoint.getX();
        y = newPoint.getY();
    }

    /**
     * Updates point with x and y
     * @param x
     * @param y
     * @throws IllegalArgumentException Throws error if point is not between 0 and 1
     */
    void update(double x, double y) throws IllegalArgumentException {
        if (x > 1 || x < 0 || y > 1 || y < 0) { throw new IllegalArgumentException("Invalid point"); }
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the window coordinates of this point given the side length of the window. (Assuming window is a square)
     * @param canvasSideLength side length of sideLength of canvas
     * @return awt.Point object
     */
    public java.awt.Point getAbsPoint(int canvasSideLength) {
        return new java.awt.Point((int) (x * canvasSideLength), (int) (y * canvasSideLength));
    }

    /**
     * get this point as a list containing [x, y]
     * @return
     */
    public List<Double> asList() {
        return Arrays.asList(x, y);
    }

    /**
     * Returns this point as a string. Eg, x = 0.2 and y = 0.5 becomes "0.20 0.50"
     * @return
     */
    public String toString() {
        return String.format("%.2f %.2f", this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VectorPoint) {
            VectorPoint point = (VectorPoint) obj;
            return point.getX() == getX() && point.getY() == getY();
        } else {
            return false;
        }
    }
}
