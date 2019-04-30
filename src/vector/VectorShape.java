package vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class VectorShape {
    private Type type;
    private boolean fillOn;
    private Color fillColor;
    private Color penColor;
    private LinkedList<Coord> coords;

    public VectorShape(Type type) {
        this.fillColor = null;
        this.penColor = Color.BLACK;
        this.fillOn = false;
        this.type = type;
        coords = new LinkedList<>();
    }

    public void addPoint(double x, double y) throws ShapeError{
        if (coords.size() >= type.maxPoints) { throw new ShapeError("Exceeded max points"); }

        coords.add(new Coord(x, y));
    }

    public void editPoint(int i, double x, double y) throws IndexOutOfBoundsException {
        coords.get(i).x = x;
        coords.get(i).y = y;
    }

    public void remove(int i) throws IndexOutOfBoundsException{
        coords.remove(i);
    }

    public List<Double> asList() {
        ArrayList<Double> output = new ArrayList<>();
        for (Coord coord : coords) {
            output.addAll(coord.asList());
        }
        return output;
    }

    public List<Coord> getPoints() {
        return this.coords;
    }

    public Coord getPoint(int i) { return this.coords.get(i); }

    public Type getType() {
        return type;
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

    public String toString() {
        StringBuilder output = new StringBuilder(type.name);
        for (Coord coord : getPoints() ) {
            output.append(" ");
            output.append(coord.toString());
        }

        return output.toString();
    }
}
