package App;

import Point.*;
import Point.Point;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
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
		super("My Game");
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
       
        
		
	}
	
	public void initGame() {
		jp = new JPanel(new FlowLayout());
		canvas = new Canvas();

		JButton saveButton = new JButton("Save and Exit");
		
		
		canvas.setPreferredSize(new Dimension(401, 401));
        canvas.setMaximumSize(new Dimension(401, 401));
        canvas.setMinimumSize(new Dimension(401, 401));
        jp.add(canvas);
		jp.add(saveButton);
        add(jp);
        pack();
	}
	
	public void stopGame() {
		remove(jp);
	}
	
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public void paint(Graphics g, Point p) {
		//Graphics2D g2 = (Graphics2D)g;
		g.fillOval(p.getPos().getX(), p.getPos().getY(), 5, 5);
		//System.out.println("Draw");
	}
	
}
