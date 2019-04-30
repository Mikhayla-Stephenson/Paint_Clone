package vector;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coord {

    public double x;
    public double y;

    public Coord(double x, double y) {
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
