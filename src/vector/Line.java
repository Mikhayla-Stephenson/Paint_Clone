package vector;

import java.awt.*;

public class Line extends BoxLikeShape {

    public Line() { }

    public Line(Point startingPoint, Color penColor, Color fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    public String getName() {
        return "LINE";
    }

    public void drawFill(Graphics g, int startX, int startY, int width, int height) { /*No nothing here */ }

    public void drawPen(Graphics g, int startX, int startY, int width, int height) {
        g.drawLine(startX, startY, height, width);
    }
}
