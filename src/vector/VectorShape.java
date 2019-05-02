package vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class VectorShape {
    private Type type;
    private Color fillColor;
    private Color penColor;
    private LinkedList<VectorPoint> vectorPoints;

    private void init( Type type, Color fillColor, Color penColor) {
        this.fillColor = fillColor;
        this.penColor = penColor;
        this.type = type;
        vectorPoints = new LinkedList<>();
    }

    public VectorShape(Type type) {
        init(type, null, Color.BLACK);
    }

    public VectorShape(Type type, Point startingPoint, Color penColor, Color fillColor)  {
        init(type, fillColor, penColor);
        addPoint(startingPoint);
    }

    public void draw(Graphics g, int size) {
        type.draw(g, size, this);
    }

    public void addPoint(Point vectorPoint) throws ShapeError {
        if (type.maxPoints != 0 && vectorPoints.size() >= type.maxPoints ) { throw new ShapeError("Exceeded max vectorPoints"); }

        vectorPoints.add(new VectorPoint(vectorPoint));
    }

    public void addPoint(double x, double y) throws ShapeError{
        try {
            addPoint(new VectorPoint(x, y));
        } catch (PointError error) {
            throw new ShapeError("Invalid Shape size");
        }
    }

    public void editPoint(int i, Point point) {
        vectorPoints.get(i).update(point);
    }

    public void remove(int i) {
        vectorPoints.remove(i);
    }

    public List<Double> asList() {
        ArrayList<Double> output = new ArrayList<>();
        for (Point vectorPoint : vectorPoints) {
            output.addAll(vectorPoint.asList());
        }
        return output;
    }

    public List<VectorPoint> getVectorPoints() {
        return this.vectorPoints;
    }

    public VectorPoint getPoint(int i) { return this.vectorPoints.get(i); }


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
        if (vectorPoints.size() != type.maxPoints) {
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

        output.append(type.name);

        for (VectorPoint vectorPoint : getVectorPoints() ) {
            output.append(" ");
            output.append(vectorPoint.toString());
        }

        return output.toString();
    }
}
