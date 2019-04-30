package vector;

import java.util.Arrays;
import java.util.List;

public class Point implements Coord {
    private double x;
    private double y;

    public double getX() { return x; }
    public double getY() { return y; }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(Coord newPoint) {
        this.x = newPoint.getX();
        this.y = newPoint.getY();
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
