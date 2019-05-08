package tests;

import org.junit.jupiter.api.Test;
import vector.shape.Rectangle;
import vector.shape.VectorShape;
import vector.util.VectorColor;
import vector.util.VectorPoint;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeTests {
    void testPoints(double expectedX, double expectedY, VectorShape subject){
        assertEquals(expectedX, subject.getPoint(0).getX());
        assertEquals(expectedY, subject.getPoint(0).getY());
    }

    @Test
    void exceptionTest(){
        VectorShape subject = new Rectangle();
        assertThrows(IllegalArgumentException.class, () -> subject.addPoint(1.1,1.1), "Invalid Shape size");
        subject.addPoint(0,0);
        subject.addPoint(0.2,0.3);
        assertThrows(IllegalStateException.class, () -> subject.addPoint(0.2,0.2), "Exceeded max VectorPoints");
    }

    @Test
    void equalsTest() {
        Rectangle subject1 = new Rectangle();
        subject1.addPoint(0.2,0.6);
        subject1.addPoint(0.8,0.7);
        Rectangle subject2 = new Rectangle();
        subject2.addPoint(0.2,0.6);
        subject2.addPoint(0.8,0.7);
        assertEquals(subject1, subject2);
    }

    @Test
    void addPoint() {
        VectorShape subject = new Rectangle();
        try {
            subject.addPoint(0.2,0.3);
        } catch (IllegalArgumentException error) { fail("Exception when adding point");}

        testPoints(0.2, 0.3, subject);
    }

    @Test
    void editPoints() {
        VectorShape subject = new Rectangle();
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
        VectorShape subject = new Rectangle();
        try {
            subject.addPoint(0.2,0.3);
            subject.addPoint(0.5, 0.2);
        } catch (IllegalArgumentException error) { fail("Exception when adding point");}

        assertEquals(Arrays.asList(0.2, 0.3, 0.5, 0.2), subject.asList());
    }

    @Test
    void testGetVec() {
        VectorShape subject = new Rectangle();
        try {
            subject.addPoint(0.2,0.3);
            subject.addPoint(0.5, 0.2);
        } catch (IllegalArgumentException error) { fail("Exception when adding point");}

        try {
            assertEquals("RECTANGLE 0.20 0.30 0.50 0.20", subject.getVec(false, false));
        } catch (IllegalArgumentException error) { fail(error.getMessage()); }
    }

    @Test
    void testGetPenRGB() {
        VectorShape subject = new Rectangle();
        subject.setFill(new VectorColor(0xFF));
        assertEquals("#0000FF", subject.getFillRGB());
    }
}
