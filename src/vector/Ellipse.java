package vector;

import java.awt.*;

class Ellipse extends BoxLikeShape {

    Ellipse() { }

    Ellipse(Point startingPoint, VectorColor penColor, VectorColor fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    String getName() { return "ELLIPSE"; }

    void drawFill(Graphics g, int startX, int startY, int width, int height) {
        g.fillOval(startX, startY, width, height);
    }

    void drawPen(Graphics g, int startX, int startY, int width, int height) {
        g.drawOval(startX, startY, height, width);
    }
}
