package vector.util;

import java.util.List;

/**
 * Implemented to classes that can map to a coordinate on the window.
 */
public interface Point {
    /**
     *
     * @return Value between 0 and 1
     */
    double getX();

    /**
     *
     * @return Value between 0 and 1
     */
    double getY();

    List<Double> asList();
    java.awt.Point getAbsPoint(int canvasSideLength);
}
