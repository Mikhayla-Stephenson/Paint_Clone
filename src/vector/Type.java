package vector;

public enum Type {
    RECTANGLE("RECTANGLE", 2),
    ELIPS("ELLIPSE", 2),
    POLYGON("Polygon", 0);

    public final String text;
    public final int maxPoints;

    Type(String text, int maxPoints) {
        this.text = text;
        this.maxPoints = maxPoints;
    }
 }
