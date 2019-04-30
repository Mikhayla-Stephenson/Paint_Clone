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

    private void init(Type type, Color fillColor, Color penColor) {
        this.fillColor = fillColor;
        this.penColor = penColor;
        this.type = type;
        vectorPoints = new LinkedList<>();
    }

    public VectorShape(Type type) {
        init(type, null, Color.BLACK);
    }

    public VectorShape(Type type, VectorPoint startingVectorPoint) {
        init(type, null, Color.BLACK);
        addPoint(startingVectorPoint);
    }

    public VectorShape(Type type, Coord startingPoint, Color penColor, Color fillColor) {
        init(type, fillColor, penColor);
    }


    public void addPoint(VectorPoint vectorPoint) throws ShapeError {
        if (type.maxPoints != 0 && vectorPoints.size() >= type.maxPoints ) { throw new ShapeError("Exceeded max vectorPoints"); }

        vectorPoints.add(vectorPoint);
    }

    public void addPoint(double x, double y) throws ShapeError{
        addPoint(new VectorPoint(x, y));
    }

    public void editPoint(int i, Coord point) {
        vectorPoints.get(i).update(point);
    }

    public void remove(int i) {
        vectorPoints.remove(i);
    }

    public List<Double> asList() {
        ArrayList<Double> output = new ArrayList<>();
        for (VectorPoint vectorPoint : vectorPoints) {
            output.addAll(vectorPoint.asList());
        }
        return output;
    }

    public List<VectorPoint> getVectorPoints() {
        return this.vectorPoints;
    }

    public Coord getPoint(int i) { return this.vectorPoints.get(i); }

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
