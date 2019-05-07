package vector;

import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class VectorPointTest {

    VectorPoint createSubject(double x, double y) {
        try {
            return new VectorPoint(x, y);
        } catch (IllegalArgumentException error) {
            fail("exception when creating VectorPoint");
            return null;
        }
    }

    @Test
    void exceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new VectorPoint(1.1, 0.2), "Invalid point");
    }

    @Test
    void testToString() {
        VectorPoint subject = createSubject(0.232, 0.5343);
        assertEquals("0.23 0.53", subject.toString());
    }

    @Test
    void equalsTest() {
        VectorPoint subject1 = createSubject(0.2, 0.5);
        VectorPoint subject2 = createSubject(0.2, 0.5);
        assertEquals(subject1, subject2);
    }

    @Test
    void toList() {
        VectorPoint subject = createSubject(0.3, 0.5);
        assertEquals(Arrays.asList(0.3, 0.5), subject.asList());
    }

    @Test
    void absPointTest() {
        VectorPoint subject = createSubject(0.4, 0.1);
        assertEquals(new Point(40, 10), subject.getAbsPoint(100));
    }
}

class ShapeTests {
    void testPoints(double expectedX, double expectedY, VectorShape subject){
        assertEquals(expectedX, subject.getPoint(0).getX());
        assertEquals(expectedY, subject.getPoint(0).getY());
    }

    @Test
    void exceptionTest(){
        VectorShape subject = new Ellipse();
        assertThrows(IllegalArgumentException.class, () -> subject.addPoint(1.1,1.1), "Invalid Shape size");
        subject.addPoint(0,0);
        subject.addPoint(0.2,0.3);
        assertThrows(IllegalStateException.class, () -> subject.addPoint(0.2,0.2), "Exceeded max VectorPoints");
    }

    @Test
    void equalsTest() {
        Ellipse subject1 = new Ellipse();
        subject1.addPoint(0.2,0.6);
        subject1.addPoint(0.8,0.7);
        Ellipse subject2 = new Ellipse();
        subject2.addPoint(0.2,0.6);
        subject2.addPoint(0.8,0.7);
        assertEquals(subject1, subject2);
    }

    @Test
    void addPoint() {
        VectorShape subject = new Ellipse();
        try {
            subject.addPoint(0.2,0.3);
        } catch (IllegalArgumentException error) { fail("Exception when adding point");}

        testPoints(0.2, 0.3, subject);
    }

    @Test
    void editPoints() {
        VectorShape subject = new Ellipse();
        try {
            subject.addPoint(0.2, 0.3);
        } catch (IllegalArgumentException error) {
            fail("Exception when adding point");
        }

        try { subject.editPoint(0, new VectorPoint(0.6, 0.3)); }
        catch (IllegalArgumentException error) { }

        testPoints(0.6, 0.3, subject);
    }

    @Test
    void asList() {
        VectorShape subject = new Ellipse();
        try {
            subject.addPoint(0.2,0.3);
            subject.addPoint(0.5, 0.2);
        } catch (IllegalArgumentException error) { fail("Exception when adding point");}

        assertEquals(Arrays.asList(0.2, 0.3, 0.5, 0.2), subject.asList());
    }

    @Test
    void testGetVec() {
        VectorShape subject = new Ellipse();
        try {
            subject.addPoint(0.2,0.3);
            subject.addPoint(0.5, 0.2);
        } catch (IllegalArgumentException error) { fail("Exception when adding point");}

        try {
            assertEquals("ELLIPSE 0.20 0.30 0.50 0.20", subject.getVec(false, false));
        } catch (IllegalArgumentException error) { fail(error.getMessage()); }
    }

    @Test
    void testGetPenRGB() {
        VectorShape subject = new Ellipse();
        subject.setFill(new VectorColor(0xFF));
        assertEquals("#0000FF", subject.getFillRGB());
    }
}

class CanvasTests {
    @Test
    void testCreateShape() {
        VectorCanvas subject = new VectorCanvas();
        subject.selectTool(Type.RECTANGLE);
        assertEquals(subject.createShape().getClass(), Rectangle.class);
        subject.selectTool(Type.ELLIPSE);
        assertEquals(subject.createShape().getClass(), Ellipse.class);
        subject.selectTool(Type.LINE);
        assertEquals(subject.createShape().getClass(), Line.class);
    }

    VectorCanvas createEqualCanvas() {

        VectorCanvas output = new VectorCanvas();
        Ellipse shape1;
        Rectangle shape2;
        shape1 = new Ellipse();
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
        VectorShape shape = new Ellipse();
        shape.addPoint(0.2, 0.2);
        shape.addPoint(0.4, 0.4);
        subject.addShape(shape);
        subject.addShape(shape);
        assertEquals("ELLIPSE 0.20 0.20 0.40 0.40\nELLIPSE 0.20 0.20 0.40 0.40\n", FileIO.getString(subject));
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
    void parseShapeTest() {
        List<VectorPoint> subject;
        String testString = "RECTANGLE 0.20 0.20 0.20 0.20";
        subject = FileIO.parseShape(testString.split(" "));
        try {
            assertEquals(Arrays.asList(new VectorPoint(0.2, 0.2), new VectorPoint(0.2, 0.2)), subject);
        } catch (IllegalArgumentException e) {
            fail();
        }
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