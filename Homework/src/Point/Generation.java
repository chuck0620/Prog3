package Point;

import java.util.ArrayList;

public class Generation {
	/*
	 * Egy generacio taroloosztalya
	 * points: Point tipusokat tarolo ArrayList
	 * numberOfPoints: igazabol points.size()
	 * finishA: A celterulet bal felso sarka
	 * finishB: A celterulet jobb felso sarka
	 * fitnessSum: fitnessek osszege, a szulo kivalasztasahoz kell
	 * bestPointID: A legjobb pont indexe
	 * gen: a generacio sorszama
	 * minStep: A legkevesebb lepes amibol befejezheto a palya
	 */
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
		//A fitnessek osszegenek szamolasa
		for(int i = 0; i < points.size(); i++)
			fitnessSum += points.get(i).getFitness();
	}
	public int getSize() {
		return points.size();
	}
	
	public void movePoint(int i) {
		//pont mozgatasa
			points.get(i).move();
			if(points.get(i).getBrain().getStep() > minStep) //Ha tobbet lepne mint a minstep, meghal
				points.get(i).setDed();
		
	}
	
	public void calculateFitness() {
		//fitnessek szamolasa
		for(int i = 0; i < numberOfPoints; i++) {
			points.get(i).calculateFitness(finishA, finishB);
		}
	}
	public boolean isEverythingDed() {
		//Meghalt-e/vegzett-e minden pont
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
		/*
		 * A genetikus algoritmus lelke
		 * Megkeresi a legjobb pontot, ami mindenképpen oroklodik,
		 * majd kiszamolja a fitnessSum-ot. Ez utan atadja a legjobbat
		 * az uj generacionak es megkezdi az uj generacio
		 * letrehozasat.
		 */
		ArrayList<Point> newPoints = new ArrayList<Point>();
		findBest();
		calculateFitnessSum();
		
		newPoints.add(points.get(bestPointID).getChild());
		newPoints.get(0).setisBest();
		for(int i = 1; i < points.size(); i++) {
			Point pont = selectParent();
			newPoints.add(pont.getChild());
		}
		
		for(int i = 0; i < numberOfPoints; i++) {
			points.set(i, newPoints.get(i).clone());
		}
		gen++;
		fitnessSum = 0;
		System.out.println(minStep);
	}
	Point selectParent() {
		/*
		 * Kivalasztja a pont oset, ahonnan az agyat fogja orokolni
		 * Minel nagyobb a fitnesse egy pontnak, annal valoszinubb, hogy o lesz valasztva
		 */
		double rand = Math.random() * fitnessSum;
		double temp = 0;
		for(int i = 0; i < points.size(); i++) {
			temp += points.get(i).getFitness();
			if(temp > rand)
				return points.get(i);
			
		}
		
		//Idaig nem juthat el a program
		return null;
	}
	
	public int getMinStep() {
		return minStep;
	}
	public void findBest() {
		/*
		 * Szimpla linearis kereses a legjobb pont megtalalasahoz
		 */
		int id = 0;
		double bestValue = -9999;
		for(int i = 0; i<points.size(); i++) {
			if(bestValue < points.get(i).getFitness()) {
				bestValue = points.get(i).getFitness();
				id = i;
			}
		}
		if(points.get(id).getDidFinish())
			minStep = points.get(id).getBrain().getStep();
		points.get(0).notBest();
		points.get(id).setisBest();
		bestPointID = id;
	}
	public void mutateChildren() {
		/*
		 * A leszarmazottak mutalasa
		 * Erre azert van szukseg, hogy a fejlodes ne akadjon be
		 */
		for(int i = 0; i<numberOfPoints; i++) {
			points.get(i).getBrain().mutate();
		}
	}

	public Point getPoint(int i) {
		return points.get(i);
	}

	public double getFitnessSum() {
		return fitnessSum;
	}
}
