package vector;

public enum Type {
    RECTANGLE("RECTANGLE", 2),
    ELLIPSE("ELLIPSE", 2),
    POLYGON("Polygon", 0),
    LINE("LINE", 2),
    PLOT("PLOT", 1);


    public final String name;
    public final int maxPoints;

    Type(String text, int maxPoints) {
        this.name = text;
        this.maxPoints = maxPoints;
    }
 }
