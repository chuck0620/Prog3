import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Point.Generation;
import Point.Vector;

class GenerationTest {

	@BeforeEach
	void setUp() throws Exception {
		Vector a, b;
		a = new Vector(100, 350);
		b = new Vector(300, 400);
		Generation testGen = new Generation(50, a, b);
		
	}

	@Test
	void testCalculateFitnessSum() {
		fail("Not yet implemented");
	}

	@Test
	void testCalculateFitness() {
		fail("Not yet implemented");
	}

	@Test
	void testGetGen() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMinStep() {
		fail("Not yet implemented");
	}

}
