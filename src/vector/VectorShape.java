package vector;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;


public class VectorShape {
    private Type type;
    private boolean fillOn;
    private Color fillColor;
    private Color penColor;
    private LinkedList<Coord> coords;

    public VectorShape() {
        setFill(null);
        setPen(Color.BLACK);
        fillOn = false;
    }

    public void addPoint(double x, double y) throws ShapeError{
        if (coords.size() >= type.maxPoints) { throw new ShapeError("Exceeded max points"); }

        coords.push(new Coord(x, y));
    }

    public void editPoint(int i, double x, double y) throws IndexOutOfBoundsException {
        coords.get(i).x = x;
        coords.get(i).y = y;
    }

    public void remove(int i) throws IndexOutOfBoundsException{
        coords.remove(i);
    }

    public List<Coord> getPoints() {
        return this.coords;
    }

    public boolean getFillOn() {
        return fillOn;
    }

    public void setFillON(boolean state) {
        fillOn = state;
    }

    public void setFill(Color color) {
        fillColor = color;
    }

    public Color getFill() {
        return fillColor;
    }

    public void setPen(Color color) {
        penColor = color;
    }

    public Color getPen() {
        return penColor;
    }
}
