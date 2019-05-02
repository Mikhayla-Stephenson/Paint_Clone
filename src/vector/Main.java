package vector;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        try {
            VectorShape e = new Rectangle();
            e.addPoint(0, 0);
            e.addPoint(0.2, 0.3);
            e.setFill(Color.BLUE);
            e.setPen(Color.RED);
            gui.canvas.addShape(e);
        } catch (ShapeError error) { System.out.println("error"); }


    }
}