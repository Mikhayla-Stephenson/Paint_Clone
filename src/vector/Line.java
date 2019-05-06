package vector;

import java.awt.*;
import java.util.List;

public class Line extends BoxLikeShape {

    Line() { }

    Line(Point startingPoint, VectorColor penColor, VectorColor fillColor) {
        super(startingPoint, penColor, fillColor);
    }

    public Line(List<VectorPoint> points) {
        super(points);
    }

    String getName() {
        return "LINE";
    }

    void drawFill(Graphics g, int startX, int startY, int width, int height) { /*No nothing here */ }

    void drawPen(Graphics g, int startX, int startY, int width, int height) {
        g.drawLine(startX, startY, height, width);
    }
}
