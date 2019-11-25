package App;
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

import Point.*;
import Point.Point;
public class Application extends JFrame{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Display dp = new Display();
		dp.move();
		
		/*JFrame f = new JFrame();
		JPanel jp = new JPanel(new BorderLayout());
		f.setVisible(true);
		f.setSize(400, 400);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Point p = new Point();
		jp.add(p, BorderLayout.CENTER);
		//Map m = new Map();
		//jp.add(m);
		jp.setVisible(true);
		f.add(jp);
		p.setVisible(true);
		while (true) {
			p.move();
			System.out.println(p.pos.getX() + " " + p.pos.getY());

			Thread.sleep(10);
		}
*/
	}

}
