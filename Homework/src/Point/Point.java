package Point;
import Point.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;
public class Point extends Container{
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
	public void move() {
		if(brain.directions.length > brain.step) {
			acc.modifyX(acc.getX() + brain.directions[brain.step].getX());
			acc.modifyY(acc.getY() + brain.directions[brain.step].getY());
			brain.step++;
		}
		else {
			isDed= true;
		}
		
		vel.modifyXY(acc.getX(), acc.getY());
		if(!isDed) {
		pos.modifyX(pos.getX() + vel.getX());
		pos.modifyY(pos.getY() + vel.getY());
		if(pos.getX() >= 400 || pos.getY() >= 400 || pos.getX() <= 0 || pos.getY() < 0) {
			isDed = true;
		}
		else {
		repaint();
		}	
		}	
	}
	public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			g2.fill(new Ellipse2D.Double(pos.getX(), pos.getY(), 5, 5));
			//g2.drawOval(pos.getX(), pos.getY(), 1, 1);
	}
	
}
