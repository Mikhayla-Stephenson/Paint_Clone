package vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class VectorShape {
    private Type type;
    private Color fillColor;
    private Color penColor;
    private LinkedList<Point> points;

    private void init(Type type, Color fillColor, Color penColor) {
        this.fillColor = fillColor;
        this.penColor = penColor;
        this.type = type;
        points = new LinkedList<>();
    }

    public VectorShape(Type type) {
        init(type, null, Color.BLACK);
    }

    public VectorShape(Type type, Point startingPoint) {
        init(type, null, Color.BLACK);
        addPoint(startingPoint);
    }

    public VectorShape(Type type, Coord startingPoint, Color penColor, Color fillColor) {
        init(type, fillColor, penColor);
    }


    public void addPoint(Point point) throws ShapeError {
        if (type.maxPoints != 0 && points.size() >= type.maxPoints ) { throw new ShapeError("Exceeded max points"); }

        points.add(point);
    }

    public void addPoint(double x, double y) throws ShapeError{
        addPoint(new Point(x, y));
    }

    public void editPoint(int i, Coord point) {
        points.get(i).update(point);
    }

    public void remove(int i) {
        points.remove(i);
    }

    public List<Double> asList() {
        ArrayList<Double> output = new ArrayList<>();
        for (Point point : points) {
            output.addAll(point.asList());
        }
        return output;
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public Coord getPoint(int i) { return this.points.get(i); }

    public Type getType() {
        return type;
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

    public String getPenRGB() {
        return "#" + penColor.toString();
    }

    public  String getFillRGB() {
        return "#" + fillColor.toString();
    }

    public String getVec(boolean includePenColor, boolean includeFillColor) throws ShapeError {
        if (points.size() != type.maxPoints) {
            throw new ShapeError("Invalid number of points");
        }
        StringBuilder output = new StringBuilder();

        if (includePenColor) {
            output.append(getPenRGB());
            output.append('\n');
        }
        if (includeFillColor) {
            output.append(getFillRGB());
            output.append('\n');
        }

        output.append(type.name);

        for (Point point : getPoints() ) {
            output.append(" ");
            output.append(point.toString());
        }

        return output.toString();
    }
}
