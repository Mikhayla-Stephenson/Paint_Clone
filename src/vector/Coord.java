package vector;

import java.awt.*;
import java.util.List;

public interface Coord {
    double getX();
    double getY();

    List<Double> asList();
    Point asPoint(int canvasSideLength);
}
