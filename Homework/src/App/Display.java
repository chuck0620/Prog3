package App;

import Point.*;
import Point.Point;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display extends JFrame {
	private Canvas canvas;
	private JPanel jp;
	JButton saveButton;
	JComboBox jcb;
	JButton startButton;
	JTextField jtf;
	JLabel label1, label2;
	boolean savePressed;
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
        savePressed = false;
        jp = new JPanel(new FlowLayout());
        
		
	}
	public void initMenu() {
		label1 = new JLabel("Pontok száma: ");
		label2 = new JLabel("Pálya: ");
		startButton = new JButton("Start");
		jtf= new JTextField(3);
		jcb = new JComboBox();
		
		
		jp.add(label1);
		jp.add(jtf);
		jp.add(label2);
		jp.add(jcb);
		jp.add(startButton);
		add(jp);
		pack();
	}
	public boolean getSavePressed() {
		return savePressed;
	}
	private class SaveButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(savePressed)
				savePressed = false;
			else 
				savePressed = true;
			
			
		}
		
	}
	public void initGame() {
		canvas = new Canvas();

		saveButton = new JButton("Save and Exit");
		
		
		canvas.setPreferredSize(new Dimension(401, 401));
        canvas.setMaximumSize(new Dimension(401, 401));
        canvas.setMinimumSize(new Dimension(401, 401));
		saveButton.addActionListener(new SaveButtonActionListener());

        jp.add(canvas);
		jp.add(saveButton);
        add(jp);
        pack();
	}
	
	public void stopGame() {
		jp.remove(canvas);
		jp.remove(saveButton);
		pack();
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
