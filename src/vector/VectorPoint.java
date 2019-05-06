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

    VectorPoint(double x, double y) throws PointError {
        if (x > 1 || x < 0 || y > 1 || y < 0) { throw new PointError("Invalid point"); }
        this.x = x;
        this.y = y;
    }

    VectorPoint(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    //Updates the point with values from any class the implements the Point interface
    void update(Point newPoint) {
        x = newPoint.getX();
        y = newPoint.getY();
    }

    void update(double x, double y) throws PointError {
        if (x > 1 || x < 0 || y > 1 || y < 0) { throw new PointError("Invalid point"); }
        this.x = x;
        this.y = y;
    }

    public java.awt.Point getAbsPoint(int canvasSideLength) {
        return new java.awt.Point((int) (x * canvasSideLength), (int) (y * canvasSideLength));
    }

    public List<Double> asList() {
        return Arrays.asList(x, y);
    }

    public String toString() {
        return String.format("%.1f %.1f", this.x, this.y);
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
