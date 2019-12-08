package Point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenerationTest {
	Generation tesztGen;
	Vector a, b;
	@BeforeEach
	void setUp() throws Exception {
		a = new Vector(100,350);
		b = new Vector(300,400);
		tesztGen = new Generation(50, a, b);
	}

	@Test
	void testCalculateFitnessSum() {
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 50; j++)
				tesztGen.movePoint(j);
		}
		tesztGen.calculateFitness();
		tesztGen.calculateFitnessSum();
		assertTrue("FitnessSum teszt", tesztGen.getFitnessSum() > 0);
	}

	@Test
	void testGetSize() {
		assertEquals("GetSize teszt", 50, tesztGen.getSize());
	}

	@Test
	void testGetMinStep() {
		assertTrue("MinStep teszt", tesztGen.getMinStep() <= 10000);
	}

}
