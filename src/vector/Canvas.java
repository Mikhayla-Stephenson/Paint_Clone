package vector;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Canvas {
    private List<VectorShape> shapes;
    private Type selectedTool;
    private Color currentPenColor;
    private Color currentFillColor;
    private boolean leftMouse;
    private Coord mouseLocation;

    public Canvas() {
        shapes = new LinkedList<>();
        selectedTool = Type.LINE;
    }

    public VectorShape addShape(Type type, VectorPoint startingVectorPoint) {
        VectorShape shape = new VectorShape(type, startingVectorPoint, currentPenColor, currentFillColor);
        shapes.add(shape);
        return shape;
    }

    public void drag(VectorShape shape, int point) {
        while (leftMouse) {
            shape.editPoint(point, mouseLocation);
            try {
                Thread.sleep((long) 60);
            } catch (InterruptedException error) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
