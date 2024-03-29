package vector.shape;


import vector.util.*;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * VectorShapes are the shapes that appear on the window that the user can create and manipulate.
 * Each type of shape is an object of a class that extends this this class.
 * An example
 * <pre>
 *     {@code
 *      VectorShape shape = new Rectangle();
 *      shape.addPoint(0.2, 0.5);
 *      shape.addPoint(0.6,0.3);
 *      shape.setFillRGB("#ff0000");
 *      shape.setPenRGB("#00ff00");
 *     }
 * </pre>
 */
public abstract class VectorShape  {
    private VectorColor fillColor;
    private VectorColor penColor;
    private LinkedList<VectorPoint> vectorPoints;

    /**
     * A helper to initialise the class to minimise code duplication.
     * @param fillColor determines fill color
     * @param penColor determines pen color
     */
    private void init(VectorColor fillColor, VectorColor penColor) {
        this.fillColor = fillColor;
        this.penColor = penColor;
        vectorPoints = new LinkedList<>();
    }

    public VectorShape() {
        init(new VectorColor(0, false), new VectorColor(0));
    }

    public VectorShape(vector.util.Point startingPoint, VectorColor penColor, VectorColor fillColor)  {
        init(fillColor, penColor);
        addPoint(startingPoint);
    }

    public VectorShape(List<VectorPoint> points) {
        init(new VectorColor(0, false), new VectorColor(0));
        addPoints(points);
    }

    /**
     * Function implemented by subclasses to draw shape to g.
     * @param g graphic created by canvas in the paint phase. Shape will be drawn to this graphic.
     * @param size size of canvas.
     */
    public abstract void draw(Graphics g, int size);


    public void addPoints(List<VectorPoint> points) {
        for (vector.util.Point point: points ) {
            addPoint(point);
        }
    }

    public void addPoints(VectorPoint... points) {
        for (vector.util.Point point: points ) {
            addPoint(point);
        }
    }

    public void addPoint(vector.util.Point vectorPoint) throws IllegalStateException {
        if (getMaxPoints() != 0 && vectorPoints.size() >= getMaxPoints() ) {
            throw new IllegalStateException("Exceeded max VectorPoints");
        }

        vectorPoints.add(new VectorPoint(vectorPoint));
    }

    /**
     * Creates a new VectorPoint with points x and y
     * @param x horizontal component
     * @param y vertical component
     * @throws IllegalArgumentException
     */
    public void addPoint(double x, double y) throws IllegalArgumentException {
        addPoint(new VectorPoint(x, y));
    }

    /**
     * Updates the ith point with the x and y values of point.
     * @param i the index of the point to update
     * @param point Point object
     */
    public void editPoint(int i, vector.util.Point point) {
        vectorPoints.get(i).update(point);
    }

    /**
     * Removes the ith point
     * @param i index of the point to remove
     */
    public void remove(int i) {
        vectorPoints.remove(i);
    }

    /**
     * Converts x and y of all points into a list
     * @return ArrayList of doubles, [x1, y1, x2, y2, x3, y3...].
     */
    public List<Double> asList() {
        ArrayList<Double> output = new ArrayList<>();
        for (Point vectorPoint : vectorPoints) {
            output.addAll(vectorPoint.asList());
        }
        return output;
    }

    /**
     * VectorPoints getter
     * @return ArrayList of VectorPoints
     */
    public List<VectorPoint> getVectorPoints() {
        return this.vectorPoints;
    }

    /**
     * Gets the point at index i
     * @param i index of the point to get
     * @return the point at index i
     */
    public VectorPoint getPoint(int i) { return this.vectorPoints.get(i); }

    /**
     * The maximum number of points a shape can have, for example squares, ellipses and lines have two points,
     * however a polygon has no limit. (If there is no limit, this function returns 0.
     * @return Max number of points a shape can have
     */
    public abstract int getMaxPoints();

    /**
     * VEC command corresponding to this shape
     * @return name
     */
    public abstract String getName();


    public void setFill(VectorColor color) {
        fillColor.update(color);
    }
    public void setFill(int color) {fillColor.setRgb(color);}

    public VectorColor getFill() {
        return fillColor;
    }

    public boolean isFillActive() {
        return fillColor.isActive();
    }

    public void setFillActive(boolean fillActive) {
        fillColor.setActive(fillActive);
    }

    public void setPen(VectorColor color) {
        penColor.update(color);
    }
    public void setPen(int color) {fillColor.setRgb(color);}

    public boolean isPenActive() {
        return fillColor.isActive();
    }

    public void setPenActive(boolean fillActive) {
        fillColor.setActive(fillActive);
    }


    public VectorColor getPen() {
        return penColor;
    }

    /**
     * Returns a RGB string representation of the pen color.
     * For example if the pen color was red, this command would return "#ff0000"
     * @return rgb string of color
     */
    public String getPenRGB() { return getPen().toString(); }

    /**
     * Returns a RGB string representation of the pen color.
     * For example if the pen color was red, this command would return "#ff0000"
     * @return rgb string of color
     */
    public String getFillRGB() {
        return getFill().toString();
    }

    /**
     * Gets the VEC representation of the shape.
     * @param includePenColor Whether to include the PEN command
     * @param includeFillColor Whether to include the FILL command
     * @return String containing VEC
     * @throws IllegalStateException
     */
    public String getVec(boolean includePenColor, boolean includeFillColor) throws IllegalStateException {
        if (vectorPoints.size() != getMaxPoints()) {
            throw new IllegalStateException("Invalid number of VectorPoints");
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

    /**
     *
     * @return VEC representation including both pen and fill
     */
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
