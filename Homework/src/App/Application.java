package App;
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

import Point.*;
import Point.Point;
public class Application extends JFrame{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setSize(400, 400);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Point p = new Point();
		f.add(p);
		p.setVisible(true);
		Map m = new Map();
		f.add(m);
		while (true) {
			p.move();
			System.out.println(p.pos.getX() + " " + p.pos.getY());

			Thread.sleep(10);
		}

	}

}
