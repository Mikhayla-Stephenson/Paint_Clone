package vector;

public enum Type {
    RECTANGLE,
    ELLIPSE,
    POLYGON,
    LINE,
    PLOT;


    public VectorShape getCls() {
        switch (this) {
            case RECTANGLE:
                return new Rectangle();
            case ELLIPSE:
                return new Ellipse();
//            case POLYGON:
//                return new Polygon();
            case LINE:
                return new Line();
//            case PLOT:
//                return new Plot();
            default:
                assert (true);
                return null;
        }
    }
}
