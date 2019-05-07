package vector;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Contains all data to be displayed to be displayed on the window. Extends Canvas.
 * Contains all shapes created by user, the currently selected tool and the dimensions of the window.
 * Example use.
 * <pre>
 * {@code
 * VectorCanvas canvas = new VectorCanvas();
 * canvas.selectTool(Type.RECTANGLE);
 * canvas.createShape();
 * }
 * </pre>
 */
public class VectorCanvas extends Canvas{
    /** List of all shapes */
    private List<VectorShape> shapes;
    private Type selectedTool;
    private VectorColor selectedPenColor, selectedFillColor;
    private CanvasMouse MouseObserver;
    private int sideWidth;

    /**
     * Method required by Canvas class to be able to be printed to the window
     * @param g Graphic
     */
    public void paint(Graphics g) {
        for (VectorShape shape : shapes) {
            shape.draw(g, sideWidth);
        }
    }

    VectorCanvas() {
        selectedFillColor = new VectorColor(0xffffff);
        selectedPenColor = new VectorColor(0);
        shapes = new LinkedList<>();
        selectedTool = Type.LINE;
        MouseObserver = new CanvasMouse();
        MouseObserver.attachCanvas(this);
    }

    int getSideWith() {
        return sideWidth;
    }

    void setSideWidth(int sideWidth) {
        this.sideWidth = sideWidth;
    }

    /**
     * Creates a shape given the value of {@link Type selectedTool} and adds it to the canvas
     */
    VectorShape createShape() {
        VectorShape s = selectedTool.getCls();
        s.setPen(selectedPenColor);
        s.setFill(selectedFillColor);
        addShape(s);
        return s;
    }

    /**
     * Add {@link VectorShape shape} to canvas
     * @param shape
     */
    void addShape(VectorShape shape) {
        shapes.add(shape);
    }

    /**
     * Gets a list of {@link VectorShape shapes} on the canvas
     * @return
     */
    List<VectorShape> getShapes() {
        return shapes;
    }

    VectorColor getSelectedPenColor() {
        return selectedPenColor;
    }

    void setSelectedPenColor(VectorColor color) {
        selectedPenColor.update(color);
    }

    VectorColor getSelectedFillColor() {
        return selectedFillColor;
    }

    void setSelectedFillColor(VectorColor color) {
        selectedFillColor.update(color);
    }

    /**
     * gets {@link vector.Type currently selected tool}
     * @param type
     */
    void selectTool(Type type) { selectedTool = type;}

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VectorCanvas) {
            VectorCanvas canvas = (VectorCanvas) obj;
            return canvas.getShapes().containsAll(getShapes());
        } else {
            return false;
        }
    }
}

class CanvasMouse implements MouseListener, MouseMotionListener, Point {

    private VectorCanvas vectorCanvas;

    void attachCanvas(VectorCanvas c) {
        vectorCanvas = c;
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        vectorCanvas.createShape();
    }

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
    public java.awt.Point getAbsPoint(int canvasSideLength) {
        return new java.awt.Point((int) getX() * canvasSideLength, (int) getY() * canvasSideLength);
    }
    public java.awt.Point asPoint() {
        return getAbsPoint(vectorCanvas.getSideWith());
    }
}
