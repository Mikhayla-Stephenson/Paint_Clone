package vector;

import vector.shape.VectorShape;
import vector.util.CanvasMouse;
import vector.util.Tool;
import vector.util.VectorColor;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

/**
 * Contains all data to be displayed to be displayed on the window. Extends Canvas.
 * Contains all shapes created by user, the currently selected tool and the dimensions of the window.
 * Example use.
 * <pre>
 * {@code
 * VectorCanvas canvas = new VectorCanvas();
 * canvas.selectTool(Tool.RECTANGLE);
 * canvas.createShape();
 * }
 * </pre>
 */
public class VectorCanvas extends Canvas{
    /** List of all shapes */
    private List<VectorShape> shapes;
    private Tool selectedTool;
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

    public VectorCanvas() {
        selectedFillColor = new VectorColor(0xffffff);
        selectedPenColor = new VectorColor(0);
        shapes = new LinkedList<>();
        selectedTool = Tool.LINE;
        MouseObserver = new CanvasMouse();
        MouseObserver.attachCanvas(this);
    }

    public int getSideWith() {
        return sideWidth;
    }

    public void setSideWidth(int sideWidth) {
        this.sideWidth = sideWidth;
    }

    /**
     * Creates a shape given the value of {@link Tool selectedTool} and adds it to the canvas
     */
    public VectorShape createShape() {
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
    public void addShape(VectorShape shape) {
        shapes.add(shape);
    }

    /**
     * Gets a list of {@link VectorShape shapes} on the canvas
     * @return
     */
    public List<VectorShape> getShapes() {
        return shapes;
    }

    public VectorColor getSelectedPenColor() {
        return selectedPenColor;
    }

    public void setSelectedPenColor(VectorColor color) {
        selectedPenColor.update(color);
    }

    public VectorColor getSelectedFillColor() {
        return selectedFillColor;
    }

    public void setSelectedFillColor(VectorColor color) {
        selectedFillColor.update(color);
    }

    /**
     * gets {@link Tool currently selected tool}
     * @param tool
     */
    public void selectTool(Tool tool) { selectedTool = tool;}

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

