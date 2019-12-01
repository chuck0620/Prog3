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
		Vector a, b;
		BufferStrategy bs;
		a = new Vector(100, 350);
		b = new Vector(300, 400);
		Map m = new Map(a, b);
		m.addObstacle(new Obstacle(0, 200, 200, 250));
		m.addObstacle(new Obstacle(300, 200, 400, 250));
		int x = 0;
		boolean fut = true;
		Display dp = new Display();
		dp.initGame();
		dp.getCanvas().createBufferStrategy(2);
		bs = dp.getCanvas().getBufferStrategy();
		Graphics g = null;
		Generation gen = new Generation(50, m.getObstacle(0).getPos1(), m.getObstacle(0).getPos2());
		boolean isDone = false;
		while(fut) {
		
			do {
				for(int i = 0; i < gen.getSize(); i++) {
						gen.getPoint(i).move();
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
					drawObstacles(dp.getCanvas().getGraphics(), m);
					g.drawRect(0, 0, dp.getCanvas().getWidth()-1, dp.getCanvas().getHeight()-1);
					for(int i = 0; i < gen.getSize(); i++)
						dp.paint(g, gen.getPoint(i));
					
				} finally {
					g.dispose();
				}
				bs.show();
			}while (bs.contentsLost());
			boolean temp = true;
			for(int i = 0; i < gen.getSize(); i++) {
				if(!gen.getPoint(i).getIsDed() && !gen.getPoint(i).getDidFinish())
					temp = false;
			}
			isDone = temp;
			if(isDone)
				fut = false;
				
			Thread.sleep(10);
		
		}
		System.out.println("DONE!");
		/*while(fut) {
			switch (x) {
			case 0:
				
			case 1:
				
			case 2:
				fut = false;
		
			}
		}*/
		
		
		/*Display dp = new Display();
		Point p = new Point();
		if(p.contains(0, 0, 300, 300))
			System.out.println("Contains!");
		//dp.move();
		double dist;
		dist = p.getDistance(100, 350, 200, 50);
		System.out.println("Distance: " + dist);
		while(true) {
			p.move();
			Graphics g = dp.getCanvas().getGraphics();
			g.clearRect(0, 0, dp.getWidth(), dp.getHeight());
			dp.paint(g, p);
			Thread.sleep(10);
			System.out.println("aa");
		}*/
		
	}
	
	static void drawObstacles(Graphics g, Map m) {
		int i = 0;
		g.setColor(Color.GREEN);
		g.fillRect(m.getObstacle(i).getPos1().getX(), m.getObstacle(i).getPos1().getY(), m.getObstacle(i).getPos2().getX()-m.getObstacle(i).getPos1().getX(), m.getObstacle(i).getPos2().getY()-m.getObstacle(i).getPos1().getY());
		g.setColor(Color.red);
		for(i = 1; i < m.getSize(); i++)
			g.fillRect(m.getObstacle(i).getPos1().getX(), m.getObstacle(i).getPos1().getY(), m.getObstacle(i).getPos2().getX()-m.getObstacle(i).getPos1().getX(), m.getObstacle(i).getPos2().getY()-m.getObstacle(i).getPos1().getY());
	}

}
