package Point;

import java.util.ArrayList;

public class Generation {
	private ArrayList<Point> points;
	private int numberOfPoints;
	private Vector finishA;
	private Vector finishB;
	
	public Generation(int num, Vector a, Vector b){
		numberOfPoints = num;
		points = new ArrayList<Point>();
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
	
	
	public int getSize() {
		return points.size();
	}
	
	public void movePoints() {
		for(int i = 0; i<numberOfPoints; i++) {
			points.get(i).move();
		}
	}
	
	public void calculateFitness() {
		for(int i = 0; i < numberOfPoints; i++) {
			points.get(i).calculateFitness(finishA, finishB);
		}
	}
	public boolean isEverythingDed() {
		for(int i = 0; i < numberOfPoints; i++) {
			if(!points.get(i).getDidFinish() && !points.get(i).getIsDed())
				return false;
		}
		return true;
	}
	
	public void generateChildren() {
		ArrayList<Point> newPoints = new ArrayList<Point>();
		
	}
	
	
	public void findBest() {
		int id = 0;
		int bestValue = -9999;
		for(int i = 0; i<numberOfPoints; i++) {
			if(bestValue < points.get(i).getFitness()) {
				bestValue = points.get(i).getFitness();
				id = i;
			}
		}
		points.get(id).setisBest();
	}
	void mutateChildren() {
		
	}

	public Point getPoint(int i) {
		return points.get(i);
	}
}
