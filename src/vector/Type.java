package vector;

import java.awt.*;
import java.lang.reflect.Executable;
import java.util.concurrent.Executors;

public enum Type {
    RECTANGLE("RECTANGLE", 2),
    ELLIPSE("ELLIPSE", 2),
    POLYGON("Polygon", 0),
    LINE("LINE", 2),
    PLOT("PLOT", 1);


    public final String name;
    public final int maxPoints;

    public void draw(Graphics g, int size, VectorShape shape) {
        switch (this) {
            case RECTANGLE:
                drawRectangle(g, size, shape);
                break;
            case ELLIPSE:
                drawEllipse(g, size, shape);
                break;
            case POLYGON:
                drawPolygon(g, size, shape);
                break;
            case LINE:
                drawLine(g, size, shape);
                break;
            case PLOT:
                drawPlot(g, size, shape);
                break;
        }
    }


    Type(String text, int maxPoints) {
        this.name = text;
        this.maxPoints = maxPoints;
    }

    private void drawEllipse(Graphics g, int size, VectorShape shape) {
        java.awt.Point p1 = shape.getPoint(0).asPoint(size);
        java.awt.Point p2 = shape.getPoint(1).asPoint(size);
        g.drawOval(p1.x, p1.y, p2.x, p2.y);
    }


    private void drawRectangle(Graphics g, int size, VectorShape shape) {
        java.awt.Point p1 = shape.getPoint(0).asPoint(size);
        java.awt.Point p2 = shape.getPoint(1).asPoint(size);
        g.drawRect(p1.x, p1.y, p2.x, p2.y);
    }


    private void drawPolygon(Graphics g, int size, VectorShape shape) {
        java.awt.Point p1 = shape.getPoint(0).asPoint(size);
        java.awt.Point p2 = shape.getPoint(1).asPoint(size);
//        g.drawPolygon(p1.x, p1.y, p2.x, p2.y);
    }


    private void drawLine(Graphics g, int size, VectorShape shape) {
        java.awt.Point p1 = shape.getPoint(0).asPoint(size);
        java.awt.Point p2 = shape.getPoint(1).asPoint(size);
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }


    private void drawPlot(Graphics g, int size, VectorShape shape) {
        java.awt.Point p1 = shape.getPoint(0).asPoint(size);
        g.drawLine(p1.x, p1.y, p1.x, p1.y);
    }

}
