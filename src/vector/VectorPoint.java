package vector;

import java.util.Arrays;
import java.util.List;

public class VectorPoint implements Point {
    // Vector points refer to key points used in VectorShape.

    // x and y points on the plane
    private double x;
    private double y;

    public double getX() { return x; }
    public double getY() { return y; }

    public VectorPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public VectorPoint(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    //Updates the point with values from any class the implements the Point interface
    public void update(Point newPoint) {
        x = newPoint.getX();
        y = newPoint.getY();
    }

    public java.awt.Point asPoint(int canvasSideLength) {
        return new java.awt.Point((int) x * canvasSideLength, (int) y * canvasSideLength);
    }

    public void update(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public List<Double> asList() {
        return Arrays.asList(x, y);
    }


    public String toString() {
        return String.format("%.1f %.1f", this.x, this.y);
    }
}
