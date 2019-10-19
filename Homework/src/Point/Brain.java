package Point;
import Point.*;
import java.util.Random;
public class Brain {
	Vector[] directions;
	int step;
	Brain(int num){
		directions = new Vector[num];
		step = 0;
		for(int i = 0; i < directions.length; i++) {
			directions[i] = new Vector();
		}
		randomize();
	}
	
	void randomize() {									//Randomizing the vectors
		for(int i = 0; i < directions.length; i++) {
			double angle = Math.random() * 2 * Math.PI; //Random number from 0 to 2*PI
			directions[i].fromAngle(angle);
		}
	}
//test
}
