package vector;

import java.awt.*;

public abstract class BoxLikeShape extends VectorShape {

    BoxLikeShape() {
    }

    BoxLikeShape(Point startingPoint, Color penColor, Color fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    public int getMaxPoints() { return 2; }

    abstract void drawPen(Graphics g, int startX, int startY, int width, int height);

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
            g.setColor(getPen());
            drawPen(g, p1.x, p1.y, width, height);
        }
        if (getFill() != null) {
            g.setColor(getFill());
            drawFill(g, p1.x, p1.y, width, height);
        }
    }
}
