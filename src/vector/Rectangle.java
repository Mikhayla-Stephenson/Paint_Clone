package vector;

import java.awt.*;

public class Rectangle extends BoxLikeShape {

    Rectangle() { }

    Rectangle(Point startingPoint, Color penColor, Color fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    String getName() { return "RECTANGLE"; }

    void drawFill(Graphics g, int startX, int startY, int width, int height) {
        g.fillRect(startX, startY, width, height);
    }

    void drawPen(Graphics g, int startX, int startY, int width, int height) {
        g.drawRect(startX, startY, width, height);
    }
}
