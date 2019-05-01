package vector;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Canvas {
    private List<VectorShape> shapes;  // List of all shapes on the canvas
    private Type selectedTool;
    private Color currentPenColor;
    private Color currentFillColor;
    private boolean leftMouse;  // True if the left mouse key is down
    private CanvasMouse MouseObserver;
    private int sideWidth;

    public Canvas() {
        shapes = new LinkedList<>();
        selectedTool = Type.LINE;
        MouseObserver = new CanvasMouse();
        MouseObserver.attachCanvas(this);
    }

    public int getSideWith() {
        return sideWidth;
    }

    public VectorShape addShape(Type type, VectorPoint startingVectorPoint) {
        VectorShape shape = new VectorShape(type, startingVectorPoint, currentPenColor, currentFillColor);
        shapes.add(shape);
        return shape;
    }

    public void drag(VectorShape shape, int point) {
        while (leftMouse) {
            shape.editPoint(point, MouseObserver);
            try {
                Thread.sleep((long) 60);
            } catch (InterruptedException error) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class CanvasMouse implements MouseListener, MouseMotionListener, Coord {

    Canvas canvas;

    public void attachCanvas(Canvas c) {
        canvas = c;
    }

    public void mouseClicked(MouseEvent mouseEvent) { }

    public void mousePressed(MouseEvent mouseEvent) { }

    public void mouseReleased(MouseEvent mouseEvent) { }

    public void mouseEntered(MouseEvent mouseEvent) { }

    public void mouseExited(MouseEvent mouseEvent) { }

    public void mouseDragged(MouseEvent mouseEvent) { }

    public void mouseMoved(MouseEvent mouseEvent) { }

    public double getX() {
        return MouseInfo.getPointerInfo().getLocation().x / canvas.getSideWith();
    }
    public double getY() {
        return MouseInfo.getPointerInfo().getLocation().y / canvas.getSideWith();
    }
    public List<Double> asList() {
        return Arrays.asList(getX(), getY());
    }
    public Point asPoint(int canvasSideLength) {
        return new Point((int) getX() * canvasSideLength, (int) getY() * canvasSideLength);
    }
    public Point asPoint() {
        return asPoint(canvas.getSideWith());
    }
}
