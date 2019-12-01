package Point;
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
	public int getStep() {
		return step;
	}
	
	void mutate() {
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
		Brain newBrain = new Brain(directions.length);
		for(int i = 0; i < directions.length; i++)
			newBrain.directions[i] = directions[i].copy();
		return newBrain;
	}
	
	void randomize() {									//Randomizing the vectors
		for(int i = 0; i < directions.length; i++) {
			double angle = Math.random() * 9;  
			directions[i].fromAngle(angle);
		}
	}
//test
}
