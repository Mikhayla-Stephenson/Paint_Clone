package vector;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class CoordTest {
    @Test
    void testToString() {
        Coord subject = new Coord(0.232, 0.5343);
        assertEquals("0.2 0.5", subject.toString());
    }
}

class ShapeTests {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void addPoint() {
        VectorShape subject = new VectorShape(Type.ELIPS);
        try {
            subject.addPoint(0.2,0.3);
        }
        catch (ShapeError error) { fail("Exception when adding point");}

        assertEquals(0.2, subject.getPoint(0).x);
        assertEquals(0.3, subject.getPoint(0).y);

    }

    void editPoints() {

    }
}