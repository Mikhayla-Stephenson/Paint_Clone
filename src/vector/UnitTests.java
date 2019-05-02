package vector;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.Point;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class VectorPointTest {

    VectorPoint createSubject(double x, double y) {
        try {
            return new VectorPoint(x, y);
        } catch (PointError error) {
            fail("exception when creating VectorPoint");
            return null;
        }
    }

    @Test
    void exceptionTest() {
        assertThrows(PointError.class, () -> new VectorPoint(1.1, 0.2), "Invalid point");
    }

    @Test
    void testToString() {
        VectorPoint subject = createSubject(0.232, 0.5343);
        assertEquals("0.2 0.5", subject.toString());
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
        assertThrows(ShapeError.class, () -> subject.addPoint(1.1,1.1), "Invalid Shape size");
        subject.addPoint(0,0);
        subject.addPoint(0.2,0.3);
        assertThrows(ShapeError.class, () -> subject.addPoint(0.2,0.2), "Exceeded max VectorPoints");
    }

    @Test
    void addPoint() {
        VectorShape subject = new Ellipse();
        try {
            subject.addPoint(0.2,0.3);
        } catch (ShapeError error) { fail("Exception when adding point");}

        testPoints(0.2, 0.3, subject);
    }

    @Test
    void editPoints() {
        VectorShape subject = new Ellipse();
        try {
            subject.addPoint(0.2, 0.3);
        } catch (ShapeError error) {
            fail("Exception when adding point");
        }

        try { subject.editPoint(0, new VectorPoint(0.6, 0.3)); }
        catch (PointError error) { }

        testPoints(0.6, 0.3, subject);
    }

    @Test
    void asList() {
        VectorShape subject = new Ellipse();
        try {
            subject.addPoint(0.2,0.3);
            subject.addPoint(0.5, 0.2);
        } catch (ShapeError error) { fail("Exception when adding point");}

        assertEquals(Arrays.asList(0.2, 0.3, 0.5, 0.2), subject.asList());
    }

    @Test
    void testGetVec() {
        VectorShape subject = new Ellipse();
        try {
            subject.addPoint(0.2,0.3);
            subject.addPoint(0.5, 0.2);
        } catch (ShapeError error) { fail("Exception when adding point");}

        try {
            assertEquals("ELLIPSE 0.2 0.3 0.5 0.2", subject.getVec(false, false));
        } catch (ShapeError error) { fail(error.getMessage()); }
    }

    @Test
    void testGetPenRGB() {
        VectorShape subject = new Ellipse();
        subject.setFill(Color.BLUE);
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

}