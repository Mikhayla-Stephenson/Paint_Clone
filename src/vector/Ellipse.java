package vector;

import java.awt.*;

public class Ellipse extends BoxLikeShape {

    public Ellipse() { }

    public Ellipse(Point startingPoint, Color penColor, Color fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    public String getName() { return "ELLIPSE"; }

    public void drawFill(Graphics g, int startX, int startY, int width, int height) {
        g.fillOval(startX, startY, width, height);
    }

    public void drawPen(Graphics g, int startX, int startY, int width, int height) {
        g.drawOval(startX, startY, height, width);
    }
}
