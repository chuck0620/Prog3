package Point;
public class Brain {
	/*
	 * A pontok "agya"
	 * directions: egy Vectorokat tartalmazo tomb
	 * amiben randomizalt vektorokat tarolunk, majd
	 * ezt orokli a kovetkezo generacio.
	 * A randomizalt vektorok a pontok gyorsulasat
	 * modositjak, igy modositva a mozgas iranyat.
	 */
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
	public int getStep() {
		return step;
	}
	
	void mutate() {
		/*
		 * Az agy mutalasa
		 * mutationRate: mekkora az esely egy mutacionak
		 * 0.01 --> 100-bol egy vektor fog atlagosan randomizalodni
		 */
		double mutationRate = 0.01;
		for(int i = 0; i<directions.length; i++) {
			double rand = Math.random();
			if(rand < mutationRate) {
				double angle = Math.random() * 9;  
				directions[i].fromAngle(angle);
			}
		}
	}
	public Brain clone() {
		//az agy masolasa
		Brain newBrain = new Brain(directions.length);
		for(int i = 0; i < directions.length; i++)
			newBrain.directions[i] = directions[i].copy();
		return newBrain;
	}
	
	void randomize() {
		//A vektorok randomizalasa
		for(int i = 0; i < directions.length; i++) {
			double angle = Math.random() * 9;  
			directions[i].fromAngle(angle);
		}
	}
}
