package vector.shape;

import vector.util.*;
import java.awt.Graphics;
import java.util.List;
import vector.util.Point;

/**
 * A {@link VectorShape}
 */
public class Rectangle extends BoxLikeShape {

    public Rectangle() { }

    public Rectangle(Point startingPoint, VectorColor penColor, VectorColor fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    public Rectangle(List<VectorPoint> points) {
        super(points);
    }

    public String getName() { return "RECTANGLE"; }

    void drawFill(Graphics g, int startX, int startY, int width, int height) {
        g.fillRect(startX, startY, width, height);
    }

    void drawPen(Graphics g, int startX, int startY, int width, int height) {
        g.drawRect(startX, startY, width, height);
    }
}
