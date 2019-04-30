package vector;

public enum Type {
    RECTANGLE("RECTANGLE", 2),
    ELIPS("ELLIPSE", 2),
    POLYGON("Polygon", 0);

    public final String name;
    public final int maxPoints;

    Type(String text, int maxPoints) {
        this.name = text;
        this.maxPoints = maxPoints;
    }
 }
