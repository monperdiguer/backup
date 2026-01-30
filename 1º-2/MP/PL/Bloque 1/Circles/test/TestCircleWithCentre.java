import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCircleWithCentre {

	@Test
	void testCircleWithCentre() {

		CircleWithCentre c1 = new CircleWithCentre(1, 2, 3.4);

		// Constructor and getter
		assertEquals(3.4, c1.getRadius());
		assertEquals(1, c1.getCentre().getX());
		assertEquals(2, c1.getCentre().getY());

		// setters
		c1.setRadius(2.3);
		assertEquals(2.3, c1.getRadius());

		c1.setCentre(new Point(4, 5));
		assertEquals(4, c1.getCentre().getX());
		assertEquals(5, c1.getCentre().getY());

		c1.setCentre(1, 2);
		assertEquals(1, c1.getCentre().getX());
		assertEquals(2, c1.getCentre().getY());
	}

	@Test
	void testPerimeter() {
		CircleWithCentre c1 = new CircleWithCentre(1, 2, 2.3);

		// check perimeter()
		assertEquals(14.45, c1.perimeter(), 0.01, "incorrect perimeter() result");
	}

	@Test
	void testArea() {
		CircleWithCentre c1 = new CircleWithCentre(1, 2, 2.3);


		// check area()
		assertEquals(16.61, c1.area(), 0.01, "incorrect area() result");
	}

	@Test
	void testOverlaps() {
		CircleWithCentre c1 = new CircleWithCentre(1, 1, 10);
		CircleWithCentre c2 = new CircleWithCentre(20, 1, 10);
		CircleWithCentre c3 = new CircleWithCentre(20, 1, 8.9);

		// check overlaps()
		assertTrue(CircleWithCentre.overlaps(c1, c2));
		assertFalse(CircleWithCentre.overlaps(c1, c3));
	}

	@Test
	void testToString() {
		CircleWithCentre c1 = new CircleWithCentre(1, 2, 3.4);
		// check toString()
		assertFalse(c1.toString().contains("CircleWithCentre@"), "not (re)defined CircleWithCentre.toString() ");
	}


}