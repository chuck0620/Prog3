package Point;

import java.util.ArrayList;

public class Generation {
	private ArrayList<Point> points;
	private int numberOfPoints;
	private Vector finishA;
	private Vector finishB;
	private double fitnessSum;
	private int bestPointID;
	private int gen;
	private int minStep;
	
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
		fitnessSum = 0;
		bestPointID = -1;
		gen = 1;
		minStep = 10000;
	}
	
	public void calculateFitnessSum() {
		for(int i = 0; i < points.size(); i++)
			fitnessSum += points.get(i).getFitness();
	}
	public int getSize() {
		return points.size();
	}
	
	public void movePoint(int i) {
			points.get(i).move();
			if(points.get(i).getBrain().getStep() > minStep)
				points.get(i).setDed();
		
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
	public int getGen() {
		return gen;
	}
	public void generateChildren() {
		ArrayList<Point> newPoints = new ArrayList<Point>();
		findBest();
		calculateFitnessSum();
		
		newPoints.add(points.get(bestPointID).getChild());
		for(int i = 1; i < points.size(); i++) {
			Point pont = selectParent();
			newPoints.add(pont.getChild());
		}
		
		for(int i = 1; i < numberOfPoints; i++) {
			points.set(i, newPoints.get(i).clone());
		}
		gen++;
		fitnessSum = 0;
		System.out.println(minStep);
	}
	Point selectParent() {
		double rand = Math.random() * fitnessSum;
		double temp = 0;
		for(int i = 0; i < points.size(); i++) {
			temp += points.get(i).getFitness();
			if(temp > rand)
				return points.get(i);
			
		}
		
		
		return null;
	}
	
	
	public void findBest() {
		int id = 0;
		double bestValue = -9999;
		for(int i = 0; i<numberOfPoints; i++) {
			if(bestValue < points.get(i).getFitness()) {
				bestValue = points.get(i).getFitness();
				id = i;
			}
		}
		if(points.get(id).getDidFinish())
			minStep = points.get(id).getBrain().getStep();
		points.get(id).setisBest();
		bestPointID = id;
	}
	public void mutateChildren() {
		for(int i = 0; i<numberOfPoints; i++) {
			points.get(i).getBrain().mutate();
		}
	}

	public Point getPoint(int i) {
		return points.get(i);
	}
}
