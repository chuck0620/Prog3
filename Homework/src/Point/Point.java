package Point;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
public class Point implements Shape{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Brain brain;
	
	public Vector vel;
	public Vector pos;
	private Vector acc;
	private int fitness;
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
		vel.setLimit(5);
	}
	
	public void show() {
		
	}
	public void calculateFitness() {
		
	}
	public void setDed() {
		isDed = true;
	}
	public void setisBest() {
		isBest = true;
	}
	public void move() {
		if(brain.directions.length > brain.step && !didFinish) {
			acc.modifyX(acc.getX() + brain.directions[brain.step].getX());
			acc.modifyY(acc.getY() + brain.directions[brain.step].getY());
			brain.step++;
		}
		else if (!didFinish){
			isDed= true;
		}
		
		vel.modifyXY(acc.getX(), acc.getY());
		if(!isDed && !didFinish) {
		pos.modifyX(pos.getX() + vel.getX());
		pos.modifyY(pos.getY() + vel.getY());
		if(pos.getX() >= 400 || pos.getY() >= 400 || pos.getX() <= 0 || pos.getY() < 0) {
			isDed = true;
		}
		/*else {
		repaint();
		}	*/
		}	
	}
	public Brain getBrain() {
		return brain;
	}
	public Vector getPos() {
		return pos;
	}
	/*public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			g2.fill(new Ellipse2D.Double(pos.getX(), pos.getY(), 5, 5));
	}*/
	public double getDistance(double x, double y, double w, double h) {
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
		else if(pos.getX() >= x && pos.getX() <= x+w) {
			distance = y-pos.getY();
		}
		else if(pos.getX() > x+w) {
			if(pos.getY() >= y) {
				distance = pos.getX() - x;
			}
			else {
				double a, b;
				a = pos.getX() - x;
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
	
	//A pont benne van-e a koordin�t�k �ltal hat�rolt ter�leten
	@Override
	public boolean contains(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
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
	
}
