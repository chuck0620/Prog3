package App;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import Map.Map;
import Map.Obstacle;
import Point.*;
import Point.Point;
public class Application{
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Map m;
		BufferStrategy bs;
		Generation gen;
		Display dp;
		Vector a, b;
		BufferedReader br = new BufferedReader(new FileReader("testin.txt"));
		int numberOfPoints = Integer.parseInt(br.readLine());
		int numberOfObstacles = Integer.parseInt(br.readLine());
		int c, d;
		c = Integer.parseInt(br.readLine());
		d = Integer.parseInt(br.readLine());
		a = new Vector(c, d);
		c = Integer.parseInt(br.readLine());
		d = Integer.parseInt(br.readLine());
		b =new Vector(c, d);
		m = new Map(a, b);
		for(int i = 0; i < numberOfObstacles; i++) {
			int x, y;
			c = Integer.parseInt(br.readLine());
			d = Integer.parseInt(br.readLine());
			x = Integer.parseInt(br.readLine());
			y = Integer.parseInt(br.readLine());
			m.addObstacle(new Obstacle(c, d, x, y));
		}
		
		boolean fut = true;
		dp = new Display();
		dp.initGame();
		
		Graphics g = null;
		gen = new Generation(numberOfPoints, m.getObstacle(0).getPos1(), m.getObstacle(0).getPos2());
		boolean isDone = false;
		bs = dp.getCanvas().getBufferStrategy();
		while(fut) {
			System.out.println(gen.getGen() + ". generáció");
			while(!gen.isEverythingDed()) {
				
			if(bs == null) {
				dp.getCanvas().createBufferStrategy(3);
				bs = dp.getCanvas().getBufferStrategy();
			}
			
			do {
				for(int i = 0; i < gen.getSize(); i++) {
						gen.movePoint(i);
						if(gen.getPoint(i).contains(m.getObstacle(0).getPos1().getX(), m.getObstacle(0).getPos1().getY(), m.getObstacle(0).getPos2().getX(), m.getObstacle(0).getPos2().getY())) {
							gen.getPoint(i).setDidFinish();
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
					
					for(int i = 1; i < gen.getSize(); i++) {
						dp.paint(g, gen.getPoint(i));
					}
						
					
				} finally {
					bs.show();
					g.dispose();
				}
				
			}while (bs.contentsLost());
			Thread.sleep(20);
			}
			
				if(dp.getSavePressed()) {
					BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt", true));
					bw.append("Generation: " + gen.getGen() + " Legjobb lepesszam: " + gen.getMinStep() + "\n");
					bw.close();}
				
			gen.calculateFitness();
			gen.generateChildren();
			gen.mutateChildren();
			
			
			Thread.sleep(10);
		
		}

		
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
