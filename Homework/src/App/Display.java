package App;

import Point.*;
import Point.Point;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends JFrame {
	private Canvas canvas;
	private JPanel jp;
	Point p;
	void move() throws InterruptedException {
		while (true) {
			p.move();
			
			System.out.println(p.pos.getX() + " " + p.pos.getY());

			Thread.sleep(10);
		}
	}
	
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
		
       
        p = new Point();
		setVisible(true);
	}
	
}
