package App;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;

import javax.swing.*;

import Map.Map;
import Map.Obstacle;
import Point.*;
import Point.Point;
public class Application{
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Map m;
		BufferStrategy bs;
		Generation gen;
		Display dp;
		Vector a, b;
		a = new Vector(100, 350);
		b = new Vector(300, 400);
		m = new Map(a, b);
		m.addObstacle(new Obstacle(0, 200, 150, 210));
		m.addObstacle(new Obstacle(250, 200, 400, 210));
		m.addObstacle(new Obstacle(50, 100, 350, 120));
		int x = 0;
		boolean fut = true;
		dp = new Display();
		dp.initGame();
		
		Graphics g = null;
		gen = new Generation(10000, m.getObstacle(0).getPos1(), m.getObstacle(0).getPos2());
		boolean isDone = false;
		bs = dp.getCanvas().getBufferStrategy();
		while(fut) {
			if(!gen.isEverythingDed()) {
			if(bs == null) {
				dp.getCanvas().createBufferStrategy(3);
				bs = dp.getCanvas().getBufferStrategy();
			}
			
			do {
				for(int i = 0; i < gen.getSize(); i++) {
						gen.movePoint(i);
						if(gen.getPoint(i).contains(m.getObstacle(0).getPos1().getX(), m.getObstacle(0).getPos1().getY(), m.getObstacle(0).getPos2().getX(), m.getObstacle(0).getPos2().getY())) {
							gen.getPoint(i).setDidFinish();
							System.out.println("Finished!");
						}
						if(m.getSize() > 1)
							for(int j = 1; j < m.getSize(); j++)
								if(gen.getPoint(i).contains(m.getObstacle(j).getPos1().getX(), m.getObstacle(j).getPos1().getY(), m.getObstacle(j).getPos2().getX(), m.getObstacle(j).getPos2().getY())) {
									gen.getPoint(i).setDed();
								}
					}
				try {
					g = bs.getDrawGraphics();
					g.clearRect(0, 0, 400, 400);
					drawObstacles(g, m);
					g.drawRect(0, 0, dp.getCanvas().getWidth()-1, dp.getCanvas().getHeight()-1);
					for(int i = 0; i < gen.getSize(); i++)
						dp.paint(g, gen.getPoint(i));
					
				} finally {
					bs.show();
					g.dispose();
				}
				
			}while (bs.contentsLost());
			
			}
			else {
			gen.calculateFitness();
			gen.generateChildren();
			gen.mutateChildren();
			
			}
			Thread.sleep(10);
		
		}
		dp.stopGame();
		dp.initMenu();
		System.out.println("DONE!");

		
	}
	
	void render() {
		
	}
	
	static void drawObstacles(Graphics g, Map m) {
		int i = 0;
		g.setColor(Color.GREEN);
		g.fillRect(m.getObstacle(i).getPos1().getX(), m.getObstacle(i).getPos1().getY(), m.getObstacle(i).getPos2().getX()-m.getObstacle(i).getPos1().getX(), m.getObstacle(i).getPos2().getY()-m.getObstacle(i).getPos1().getY());
		g.setColor(Color.red);
		for(i = 1; i < m.getSize(); i++)
			g.fillRect(m.getObstacle(i).getPos1().getX(), m.getObstacle(i).getPos1().getY(), m.getObstacle(i).getPos2().getX()-m.getObstacle(i).getPos1().getX(), m.getObstacle(i).getPos2().getY()-m.getObstacle(i).getPos1().getY());
		g.setColor(Color.black);
	}

}
