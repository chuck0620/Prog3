package Point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VectorTest {
	Vector tesztA;
	@BeforeEach
	void setUp() throws Exception {
		tesztA = new Vector(0, 0);
	}

	@Test
	void testSetLimit() {
		tesztA.setLimit(5);
		tesztA.setXY(10,30);
		assertEquals("Limit teszt X", 5, tesztA.getX());
		assertEquals("Limit teszt Y", 5, tesztA.getY());
	}

	@Test
	void testSetXY() {
		tesztA.setXY(10,30);
		assertEquals("setXY teszt X", 10, tesztA.getX());
		assertEquals("setXY teszt Y", 30, tesztA.getY());
	}

	@Test
	void testFromAngle() {
		for(double i = 0; i<9; i++) {
			tesztA.fromAngle(i);
			assertTrue("FromAngle teszt X", tesztA.getX() == 0 || tesztA.getX() == -1 || tesztA.getX() == 1);
			assertTrue("FromAngle teszt Y", tesztA.getY() == 0 || tesztA.getY() == -1 || tesztA.getY() == 1);
		}
	}

}
