import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BicycleTest {

    @Test
    void testDefaultConstructor() {
        Bicycle bicycle = new Bicycle();
        assertEquals(0, bicycle.getCadence());
        assertEquals(0, bicycle.getSpeed());
        assertEquals(1, bicycle.getGear());
    }

    @Test
    void testParameterizedConstructor() {
        Bicycle bicycle = new Bicycle(90, 25, 3);
        assertEquals(90, bicycle.getCadence());
        assertEquals(25, bicycle.getSpeed());
        assertEquals(3, bicycle.getGear());
    }

    @Test
    void testCopyConstructor() {
        Bicycle original = new Bicycle(100, 30, 4);
        Bicycle copy = new Bicycle(original);
        assertEquals(original.getCadence(), copy.getCadence());
        assertEquals(original.getSpeed(), copy.getSpeed());
        assertEquals(original.getGear(), copy.getGear());
        assertNotSame(original, copy); // Ensure objects are not the same
    }

    @Test
    void testSetAndGetMethods() {
        Bicycle bicycle = new Bicycle();
        bicycle.setCadence(70);
        bicycle.setSpeed(20);
        bicycle.setGear(2);

        assertEquals(70, bicycle.getCadence());
        assertEquals(20, bicycle.getSpeed());
        assertEquals(2, bicycle.getGear());
    }

    @Test
    void testInvalidSetters() {
        Bicycle bicycle = new Bicycle();

        bicycle.setCadence(-10); // Invalid cadence
        assertEquals(0, bicycle.getCadence()); // Cadence should remain unchanged

        bicycle.setSpeed(-5); // Invalid speed
        assertEquals(0, bicycle.getSpeed()); // Speed should remain unchanged

        bicycle.setGear(0); // Invalid gear
        assertEquals(1, bicycle.getGear()); // Gear should remain unchanged
    }

    @Test
    void testApplyBrake() {
        Bicycle bicycle = new Bicycle(60, 25, 3);
        bicycle.applyBrake(10);
        assertEquals(15, bicycle.getSpeed());
    }

    @Test
    void testSpeedUp() {
        Bicycle bicycle = new Bicycle(60, 25, 3);
        bicycle.speedUp(10);
        assertEquals(35, bicycle.getSpeed());
    }

    @Test
    void testToString() {
        Bicycle bicycle = new Bicycle(80, 20, 3);
        String expected = "Bicycle [cadence=80, speed=20, gear=3]";
        assertEquals(expected, bicycle.toString());
    }

}
