package App;

import Point.*;
import Point.Point;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends JFrame {
	private Canvas canvas;
	private JPanel jp;
/*	void move() throws InterruptedException {
		while (true) {
			p.move();
			//canvas.update(getGraphics());
			System.out.println(p.pos.getX() + " " + p.pos.getY());

			Thread.sleep(10);
		}
	}*/
	
	public Display()
	{
		super("MyGame");
		jp = new JPanel(new BorderLayout());
		canvas = new Canvas();
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		canvas.setPreferredSize(new Dimension(400, 400));
        canvas.setMaximumSize(new Dimension(400, 400));
        canvas.setMinimumSize(new Dimension(400, 400));
		
        jp.add(canvas, BorderLayout.CENTER);
        add(jp);
        pack();
        setVisible(true);
       
        
		
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public void paint(Graphics g, Point p) {
		//Graphics2D g2 = (Graphics2D)g;
		g.fillOval(p.getPos().getX(), p.getPos().getY(), 50, 50);
		System.out.println("Draw");
	}
	
}
