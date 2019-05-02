package vector;

import java.awt.*;
import java.util.List;

public interface Point {
    double getX();
    double getY();

    List<Double> asList();
    java.awt.Point getAbsPoint(int canvasSideLength);
}
