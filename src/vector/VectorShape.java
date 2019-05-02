package vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


abstract class VectorShape  {
    private Color fillColor;
    private Color penColor;
    private LinkedList<VectorPoint> vectorPoints;

    private void init(Color fillColor, Color penColor) {
        this.fillColor = fillColor;
        this.penColor = penColor;
        vectorPoints = new LinkedList<>();
    }

    VectorShape() {
        init(null, Color.BLACK);
    }

    VectorShape(Point startingPoint, Color penColor, Color fillColor)  {
        init(fillColor, penColor);
        addPoint(startingPoint);
    }

    abstract void draw(Graphics g, int size);

    void addPoint(Point vectorPoint) throws ShapeError {
        if (getMaxPoints() != 0 && vectorPoints.size() >= getMaxPoints() ) { throw new ShapeError("Exceeded max VectorPoints"); }

        vectorPoints.add(new VectorPoint(vectorPoint));
    }

    void addPoint(double x, double y) throws ShapeError{
        try {
            addPoint(new VectorPoint(x, y));
        } catch (PointError error) {
            throw new ShapeError("Invalid Shape size");
        }
    }

    void editPoint(int i, Point point) {
        vectorPoints.get(i).update(point);
    }

    void remove(int i) {
        vectorPoints.remove(i);
    }

    List<Double> asList() {
        ArrayList<Double> output = new ArrayList<>();
        for (Point vectorPoint : vectorPoints) {
            output.addAll(vectorPoint.asList());
        }
        return output;
    }

    List<VectorPoint> getVectorPoints() {
        return this.vectorPoints;
    }

    VectorPoint getPoint(int i) { return this.vectorPoints.get(i); }

    abstract int getMaxPoints();

    abstract String getName();

    void setFill(Color color) {
        fillColor = color;
    }

    Color getFill() {
        return fillColor;
    }

    void setPen(Color color) {
        penColor = color;
    }

    Color getPen() {
        return penColor;
    }

    String getPenRGB() { return Util.getColorRGB(getPen()); }

    String getFillRGB() {
        return Util.getColorRGB(getFill());
    }

    String getVec(boolean includePenColor, boolean includeFillColor) throws ShapeError {
        if (vectorPoints.size() != getMaxPoints()) {
            throw new ShapeError("Invalid number of vectorPoints");
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

        output.append(getName());

        for (VectorPoint vectorPoint : getVectorPoints() ) {
            output.append(" ");
            output.append(vectorPoint.toString());
        }

        return output.toString();
    }
}
