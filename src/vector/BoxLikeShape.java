package vector;

import java.awt.*;
import java.util.List;

/** An extension of {@link VectorShape} with 2 points
 *
 */
public abstract class BoxLikeShape extends VectorShape {

    BoxLikeShape() {
    }

    BoxLikeShape(Point startingPoint, VectorColor penColor, VectorColor fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    public BoxLikeShape(List<VectorPoint> points) {
        super(points);
    }

    public int getMaxPoints() { return 2; }

    /**
     * Draws the shape outline to g
     * @param g
     * @param startX
     * @param startY
     * @param width
     * @param height
     */
    abstract void drawPen(Graphics g, int startX, int startY, int width, int height);

    /**
     * Draws the shape fill to g
     * @param g
     * @param startX
     * @param startY
     * @param width
     * @param height
     */
    abstract void drawFill(Graphics g, int startX, int startY, int width, int height);

    public void draw(Graphics g, int size) {
        if (getVectorPoints().size() != getMaxPoints()) {
            throw new ShapeError("Invalid number of points");
        }
        java.awt.Point p1 = getPoint(0).getAbsPoint(size);
        java.awt.Point p2 = getPoint(1).getAbsPoint(size);
        int width = p2.x - p1.x;
        int height = p2.y - p1.y;
        if (getPen() != null) {
            g.setColor(getPen().asColor());
            drawPen(g, p1.x, p1.y, width, height);
        }
        if (getFill() != null) {
            g.setColor(getFill().asColor());
            drawFill(g, p1.x, p1.y, width, height);
        }
    }
}
