package vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


abstract class VectorShape  {
    private VectorColor fillColor;
    private VectorColor penColor;
    private LinkedList<VectorPoint> vectorPoints;

    private void init(VectorColor fillColor, VectorColor penColor) {
        this.fillColor = fillColor;
        this.penColor = penColor;
        vectorPoints = new LinkedList<>();
    }

    VectorShape() {
        init(VectorColor.CLEAR, new VectorColor(0));
    }

    VectorShape(Point startingPoint, VectorColor penColor, VectorColor fillColor)  {
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

    void setFill(VectorColor color) {
        fillColor = color;
    }

    VectorColor getFill() {
        return fillColor;
    }

    void setPen(VectorColor color) {
        penColor = color;
    }

    VectorColor getPen() {
        return penColor;
    }

    String getPenRGB() { return getPen().toString(); }

    String getFillRGB() {
        return getFill().toString();
    }

    String getVec(boolean includePenColor, boolean includeFillColor) throws ShapeError {
        if (vectorPoints.size() != getMaxPoints()) {
            throw new ShapeError("Invalid number of vectorPoints");
        }
        StringBuilder output = new StringBuilder();

        if (includePenColor) {
            output.append("PEN ");
            output.append(getPenRGB());
            output.append('\n');
        }
        if (includeFillColor) {
            output.append("FILL ");
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

    public String toString() {
        return getVec(true, true);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VectorShape) {
            VectorShape shape = (VectorShape) obj;
            return getVectorPoints().containsAll(shape.getVectorPoints());
        } else {
            return false;
        }
    }
}
