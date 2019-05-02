package vector;

import java.awt.*;

public class Line extends BoxLikeShape {

    Line() { }

    Line(Point startingPoint, VectorColor penColor, VectorColor fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    String getName() {
        return "LINE";
    }

    void drawFill(Graphics g, int startX, int startY, int width, int height) { /*No nothing here */ }

    void drawPen(Graphics g, int startX, int startY, int width, int height) {
        g.drawLine(startX, startY, height, width);
    }
}
