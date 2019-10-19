package Point;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Map extends JPanel {
	private int x;
	private int y;
	{
		x = 400;
		y = 400;
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		Rectangle2D rect= new Rectangle2D.Double(0,0,400,400);
		g2.draw(rect);
	}

}
