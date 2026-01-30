import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCircle {

	@Test
	void testCircle() {

		Circle c1 = new Circle(1.2);

		// Constructor and getter
		assertEquals(1.2, c1.getRadius());

		// setter
		c1.setRadius(2.3);
		assertEquals(2.3, c1.getRadius());
	}

	@Test
	void testPerimeter() {
		Circle c1 = new Circle(2.3);

		// check perimeter()
		assertEquals(14.45, c1.perimeter(), 0.01, "incorrect perimeter() result");
	}

	@Test
	void testArea() {
		Circle c1 = new Circle(2.3);


		// check area()
		assertEquals(16.61, c1.area(), 0.01, "incorrect area() result");
	}

}