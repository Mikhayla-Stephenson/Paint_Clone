package vector;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class VectorPointTest {
    @Test
    void testToString() {
        VectorPoint subject = new VectorPoint(0.232, 0.5343);
        assertEquals("0.2 0.5", subject.toString());
    }

    @Test
    void toList() {
        VectorPoint subject = new VectorPoint(1.5, 3.5);
        assertEquals(Arrays.asList(1.5, 3.5), subject.asList());
    }
}

class ShapeTests {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    void testPoints(double expectedX, double expectedY, VectorShape subject){
        assertEquals(expectedX, subject.getPoint(0).getX());
        assertEquals(expectedY, subject.getPoint(0).getY());
    }

    @Test
    void addPoint() {
        VectorShape subject = new VectorShape(Type.ELLIPSE);
        try {
            subject.addPoint(0.2,0.3);
        } catch (ShapeError error) { fail("Exception when adding point");}

        testPoints(0.2, 0.3, subject);
    }

    @Test
    void editPoints() {
        VectorShape subject = new VectorShape(Type.ELLIPSE);
        try {
            subject.addPoint(0.2, 0.3);
        } catch (ShapeError error) { fail("Exception when adding point"); }

        subject.editPoint(0, new VectorPoint(0.6, 1.6));

        testPoints(0.6, 1.6, subject);
    }

    @Test
    void asList() {
        VectorShape subject = new VectorShape(Type.ELLIPSE);
        try {
            subject.addPoint(0.2,0.3);
            subject.addPoint(3.5, 2.2);
        } catch (ShapeError error) { fail("Exception when adding point");}

        assertEquals(Arrays.asList(0.2, 0.3, 3.5, 2.2), subject.asList());
    }

    @Test
    void testToString() {
        VectorShape subject = new VectorShape(Type.ELLIPSE);
        try {
            subject.addPoint(0.2,0.3);
            subject.addPoint(3.5, 2.2);
        } catch (ShapeError error) { fail("Exception when adding point");}

        try {
            assertEquals("ELLIPSE 0.2 0.3 3.5 2.2", subject.getVec(false, false));
        } catch (ShapeError error) { fail(); }
    }
}