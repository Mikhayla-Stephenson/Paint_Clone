package tests;

import org.junit.jupiter.api.Test;
import vector.util.VectorPoint;

import java.awt.Point;
import java.util.Arrays;

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

