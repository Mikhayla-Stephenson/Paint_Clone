package vector;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class VectorCanvas extends Canvas{
    private List<VectorShape> shapes;  // List of all shapes on the vectorCanvas
    private Type selectedTool;
    private Color currentPenColor;
    private Color currentFillColor;
    private boolean leftMouse;  // True if the left mouse key is down
    private CanvasMouse MouseObserver;
    private int sideWidth;

    public void paint(Graphics g) {

        for (VectorShape shape : shapes) {

        }
        g.drawString("Hello",40,40);
        setBackground(Color.WHITE);
        g.fillRect(130, 30,100, 80);
        g.drawOval(30,130,50, 60);
        setForeground(Color.RED);
        g.fillOval(130,130,50, 60);
        g.drawArc(30, 200, 40,50,90,60);
        g.fillArc(30, 130, 40,50,180,40);
    }

    public VectorCanvas() {
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

    VectorCanvas vectorCanvas;

    public void attachCanvas(VectorCanvas c) {
        vectorCanvas = c;
    }

    public void mouseClicked(MouseEvent mouseEvent) { }

    public void mousePressed(MouseEvent mouseEvent) { }

    public void mouseReleased(MouseEvent mouseEvent) { }

    public void mouseEntered(MouseEvent mouseEvent) { }

    public void mouseExited(MouseEvent mouseEvent) { }

    public void mouseDragged(MouseEvent mouseEvent) { }

    public void mouseMoved(MouseEvent mouseEvent) { }

    public double getX() {
        return MouseInfo.getPointerInfo().getLocation().x / vectorCanvas.getSideWith();
    }
    public double getY() {
        return MouseInfo.getPointerInfo().getLocation().y / vectorCanvas.getSideWith();
    }
    public List<Double> asList() {
        return Arrays.asList(getX(), getY());
    }
    public Point asPoint(int canvasSideLength) {
        return new Point((int) getX() * canvasSideLength, (int) getY() * canvasSideLength);
    }
    public Point asPoint() {
        return asPoint(vectorCanvas.getSideWith());
    }
}
