package Point;

import java.util.ArrayList;

public class Generation {
	private ArrayList<Point> points;
	private int numberOfPoints;
	static final double mutationRate = 0.01;
	private Vector finishA;
	private Vector finishB;
	
	Generation(int num, Vector a, Vector b){
		numberOfPoints = num;
		for (int i = 0; i<numberOfPoints; i++) {
			points.add(new Point());
		}
		//-----------------------
		//A célterület két meghatározó vektora
		finishA = new Vector();
		finishA = a;
		finishB = new Vector();
		finishB = b;
	}
	
	public void movePoints() {
		for(int i = 0; i<numberOfPoints; i++) {
			points.get(i).move();
		}
	}
	
	public void generateChildren() {
		
	}
	
	void findBest() {
		int id = 0;
		int bestValue = 0; 
		for(int i = 0; i<numberOfPoints; i++) {
			if(points.get(i).contains(finishA.getX(), finishA.getY(), finishB.getX(), finishB.getY()))
				bestValue += 1000;
			bestValue -= points.get(i).getBrain().step;
			
			
		}
	}
	void mutateChildren() {
		
	}

	public Point getPoint(int i) {
		return points.get(i);
	}
}
