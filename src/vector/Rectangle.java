package vector;

import java.awt.*;

public class Rectangle extends BoxLikeShape {

    public Rectangle() { }

    public Rectangle(Point startingPoint, Color penColor, Color fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    public String getName() { return "RECTANGLE"; }

    public void drawFill(Graphics g, int startX, int startY, int width, int height) {
        g.fillRect(startX, startY, width, height);
    }

    public void drawPen(Graphics g, int startX, int startY, int width, int height) {
        g.drawRect(startX, startY, height, width);
    }
}
