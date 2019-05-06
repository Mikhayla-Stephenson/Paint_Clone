package vector;

import java.awt.*;
import java.util.List;

public class Rectangle extends BoxLikeShape {

    Rectangle() { }

    Rectangle(Point startingPoint, VectorColor penColor, VectorColor fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    public Rectangle(List<VectorPoint> points) {
        super(points);
    }

    String getName() { return "RECTANGLE"; }

    void drawFill(Graphics g, int startX, int startY, int width, int height) {
        g.fillRect(startX, startY, width, height);
    }

    void drawPen(Graphics g, int startX, int startY, int width, int height) {
        g.drawRect(startX, startY, width, height);
    }
}
