package vector;

import java.awt.*;

public abstract class BoxLikeShape extends VectorShape {

    public BoxLikeShape() {
    }

    public BoxLikeShape(Point startingPoint, Color penColor, Color fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    public int getMaxPoints() { return 2; }

    abstract void drawPen(Graphics g, int startX, int startY, int width, int height);

    abstract void drawFill(Graphics g, int startX, int startY, int width, int height);

    public void draw(Graphics g, int size) {
        java.awt.Point p1 = getPoint(0).getAbsPoint(size);
        java.awt.Point p2 = getPoint(1).getAbsPoint(size);
        int width = p2.x - p1.x;
        int height = p2.y - p1.y;
        if (getPen() != null) {
            drawPen(g, p1.x, p1.y, width, height);
        }
        if (getFill() != null) {
            drawFill(g, p1.x, p1.y, width, height);
        }
    }
}
