package vector;

import java.awt.*;

class FileIO {

    static String getString(VectorCanvas canvas) {
        StringBuilder output = new StringBuilder();
        VectorColor penColor, fillColor;
        boolean includePen, includeFill;
        penColor = new VectorColor(0);
        fillColor = VectorColor.CLEAR;
        for (VectorShape shape: canvas.getShapes() ) {
            includePen = !penColor.isEquals(shape.getPen());
            includeFill = !fillColor.isEquals(shape.getFill());
            penColor = shape.getPen();
            fillColor = shape.getFill();
            output.append(shape.getVec(includePen, includeFill));
            output.append('\n');
        }
        return output.toString();
    }
}
