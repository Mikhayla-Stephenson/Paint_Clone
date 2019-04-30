package vector;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class VectorPoint implements Coord {
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

    //Updates the point with values from any class the implements the Coord interface
    public void update(Coord newPoint) {
        x = newPoint.getX();
        y = newPoint.getY();
    }

    public Dimension asDimension(int canvasSideLength) {
        return new Dimension((int) x * canvasSideLength, (int) y * canvasSideLength);
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
