package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vector.VectorCanvas;
import vector.exception.UnknownCommandException;
import vector.shape.Rectangle;
import vector.shape.VectorShape;
import vector.util.FileIO;
import vector.util.Tool;
import vector.util.VectorColor;
import vector.util.VectorPoint;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CanvasTests {
    @Test
    void testCreateShape() {
        VectorCanvas subject = new VectorCanvas();
        subject.selectTool(Tool.RECTANGLE);
        assertEquals(subject.createShape().getClass(), Rectangle.class);
//        subject.selectTool(Tool.ELLIPSE);
//        assertEquals(subject.createShape().getClass(), Ellipse.class);
//        subject.selectTool(Tool.LINE);
//        assertEquals(subject.createShape().getClass(), Line.class);
    }

    VectorCanvas createEqualCanvas() {

        VectorCanvas output = new VectorCanvas();
        Rectangle shape1;
        Rectangle shape2;
        shape1 = new Rectangle();
        shape1.addPoint(0.2,0.6);
        shape1.addPoint(0.8,0.7);
        shape2 = new Rectangle();
        shape2.addPoint(0.1,0.9);
        shape2.addPoint(0.3,0.2);
        output.addShape(shape1);
        output.addShape(shape2);

        return output;
    }

    @Test
    void equalsTest() {
        VectorCanvas subject1 = createEqualCanvas();
        VectorCanvas subject2 = createEqualCanvas();

        assertEquals(subject1, subject2);
    }

    @Test
    void testWriteToFile() {
        VectorCanvas subject = new VectorCanvas();
        VectorShape shape = new Rectangle();
        shape.addPoint(0.2, 0.2);
        shape.addPoint(0.4, 0.4);
        subject.addShape(shape);
        subject.addShape(shape);
        Assertions.assertEquals("RECTANGLE 0.20 0.20 0.40 0.40\nRECTANGLE 0.20 0.20 0.40 0.40\n", FileIO.getString(subject));
    }

    @Test
    void writeToFileStarting() {
        VectorCanvas subject = new VectorCanvas();
        VectorShape shape = new Rectangle();
        shape.addPoint(0.1, 0.7);
        shape.addPoint(0.3,0.2);
        shape.setFill(new VectorColor(0x334499));
        shape.setPen(new VectorColor(0x005500));
        subject.addShape(shape);
        assertEquals("PEN #005500\nFILL #334499\nRECTANGLE 0.10 0.70 0.30 0.20\n", FileIO.getString(subject));
    }


    @Test
    void parseStringTest() {
        VectorCanvas expected = new VectorCanvas();
        VectorShape shape = new Rectangle();
        try {
            shape.addPoint(new VectorPoint(0.2, 0.2));
            shape.addPoint(new VectorPoint(0.3, 0.8));
            expected.addShape(shape);
            expected.addShape(shape);
        } catch (IllegalArgumentException e) {
            fail();
        }

        VectorCanvas subject;
        String testString = "RECTANGLE 0.20 0.20 0.30 0.80\n";
        try {
            subject = FileIO.parseString(Arrays.asList(testString, testString));
            assertEquals(expected, subject);
        } catch (UnknownCommandException error) {
            System.out.println("Did not load file: " + error.getMessage());
            fail("Command Error");
        }
    }

}
