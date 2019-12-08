package Point;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * A pont osztály tarolja egy pontnak az adatait
 * brain: a pont "agya", lsd. Brain.java
 * vel: a pont sebessege
 * pos: a pont aktualis pozicioja
 * acc: a pont aktualis gyorsulasa
 * fitness: minel fittebb egy pont, annal valoszinubb, hogy tovabboroklodik
 * isDed: true - a pont nekiment a falnak/egy akadalynak
 * didFinish: true - a pont elérte a celt
 * isBest: true - a legjobb pont a generacioban (mindig oroklodik)
 */
public class Point implements Shape{
	private static final long serialVersionUID = 1L;

	Brain brain;
	
	public Vector vel;
	public Vector pos;
	private Vector acc;
	private double fitness;
	private boolean isDed;
	private boolean didFinish;
	private boolean isBest;
	{
		fitness = 0;
		brain = new Brain(400);
		pos = new Vector(200, 0);
		acc = new Vector();
		vel = new Vector();
		isDed = false; 
		didFinish = false;
		isBest  = false;
		vel.setLimit(5); //Sebesseget limitaljuk
	}
	
	public Point getChild() {
		//Egy pont "gyereke" igazabol az adott pont agyanak a klonja
		//Normal esetben tobb szulo is lehetne, de egy ilyen egyszeru programhoz folosleges
		Point child = new Point();
		child.brain = brain.clone();
		return child;
	}
	
	public void calculateFitness(Vector finishA, Vector finishB) {
		/*
		 * A pont fitness ertekenek szamolasa:
		 * 1.) ha elerte a celt, nagyon fitt lesz, minel kevesebb lepesbol eri el, annal fittebb
		 * egy kicsivel jobb lepesszam negyzetesen javitja a fitnesst
		 * 2.) ha nem erte el a celt, akkor a celtol valo vegso tavolsagat veszi
		 * egy kis lepes a cel fele negyzetesen javitja a fitnesst 
		 */
		if(didFinish)
			fitness = 20000.0/(double)(brain.getStep()*brain.getStep());
		
		//Calculate Distance to Goal
		else {
			fitness = 1.0 / (Math.pow(getDistance(finishA.getX(), finishA.getY(), finishB.getX(), finishB.getY()), 2) + 0.00001);
			//System.out.println(getDistance(finishA.getX(), finishA.getY(), finishB.getX(), finishB.getY()));
			}
	}
	public void setDed() {
		//a pont nekiment valaminek
		isDed = true;
	}
	public void setisBest() {
		//legjobb pont
		isBest = true;
	}
	public void notBest() {
		//mar nem a legjobb
		isBest = false;
	}
	public void move() {
		/*
		 * A pont mozgatasa
		 * 1.) az agyban levo vektorok alapjan a gyorsulast modositjuk
		 * ha kifogyott a vektorokbol az agy, meghal a pont
		 * 2.) a sebesseget modositjuk a gyorsulas ertekevel
		 * 3.) ha a pont nem halott, es meg nem ert celba
		 * noveljuk a pozicio erteket a sebesseg ertekevel (mozgatjuk)
		 * 4.) ha elerte a palya szelet, meghal
		 */
		if(brain.directions.length > brain.step && !didFinish) {
			acc.setX(brain.directions[brain.step].getX());
			acc.setY(brain.directions[brain.step].getY());
			brain.step++;
		}
		else if (!didFinish){
			isDed= true;
		}
		
		vel.setXY(vel.getX() + acc.getX(),vel.getY() + acc.getY());
		if(!isDed && !didFinish) {
		pos.setX(pos.getX() + vel.getX());
		pos.setY(pos.getY() + vel.getY());
		if(pos.getX() >= 400-5 || pos.getY() >= 400-5 || pos.getX() <= 0 || pos.getY() < 0) {
			isDed = true;
		}
		}	
	}
	public Brain getBrain() {
		return brain;
	}
	public Vector getPos() {
		return pos;
	}
	public Point clone() {
		Point clone = new Point();
		clone.brain = brain.clone();
		return clone;
	}
	
	public double getDistance(double x, double y, double w, double h) {
		/*
		 * A pont tavolsaga a celtol, ahol az (x, y) a cel bal felso sarkanak a koordinatai
		 * a (w, h) a jobb also sarka
		 * 5 eset van, attol fuggoen, hogy a pont a sik mely reszen tartozkodik ebben, a celhoz viszonyitva
		 */
		double distance = 9999;
		if(pos.getX() < x) {
			if(pos.getY() >= y) {
			distance = x - pos.getX();
			}
			else {
				double a, b;
				a = x - pos.getX();
				b = y - pos.getY();
				distance = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
			}
		}
		else if(pos.getX() >= x && pos.getX() <= w) {
			distance = y-pos.getY();
		}
		else if(pos.getX() > w) {
			if(pos.getY() >= y) {
				distance = pos.getX() - w;
			}
			else {
				double a, b;
				a = pos.getX() - w;
				b = y - pos.getY();
				distance = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
			}
		}
		
		
		return distance;
	}
	public void setDidFinish() {
		didFinish = true;
	}
	public boolean getDidFinish() {
		return didFinish;
	}
	public boolean getIsDed() {
		return isDed;
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Point2D p) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean intersects(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean intersects(Rectangle2D r) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean contains(double x, double y, double w, double h) {
		//A pont benne van-e a koordináták által határolt területen
		if(pos.getX() >= x && pos.getY() >= y && pos.getX() <= w && pos.getY() <= h) 
			return true;
		return false;
	}
	@Override
	public boolean contains(Rectangle2D r) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getFitness() {
		// TODO Auto-generated method stub
		return fitness;
	}

	public boolean getIsBest() {
		// TODO Auto-generated method stub
		return isBest;
	}
	
}
