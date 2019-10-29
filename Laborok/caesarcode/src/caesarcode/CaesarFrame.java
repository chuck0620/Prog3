package caesarcode;
import caesarcode.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CaesarFrame extends JFrame{
	private final JComboBox jcb;
	private final JPanel p1, p2;
	private final JTextField f1, f2;
	private final JButton jb;
	
	private boolean decode = false;
	
	CaesarFrame(){
		super("SwingLab");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 110);
		setResizable(true);
		
		GridLayout gl = new GridLayout();
		gl.setRows(2);
		gl.setColumns(1);
		setLayout(gl);
		p1 = new JPanel(new FlowLayout());
		add(p1);
		Object ch[] = new Object[26];
		for(int i = (int)'A'; i<= (int)'Z'; i++)
			ch[i-(int)'A'] = (char)i;
		jcb=new JComboBox(ch);
		p1.add(jcb);
		f1 = new JTextField(20);
		f1.setEnabled(true);
		f1.addFocusListener(new FocusLoseListener(false));
		f1.getDocument().addDocumentListener(new InputKeyListener());
		p1.add(f1);
		jb = new JButton();
		jb.setText("Code!");
		jb.addActionListener(new OkButtonActionListener());
		p1.add(jb);
		
		p2 = new JPanel(new BorderLayout());
		add(p2);
		p2.add(new JLabel("Output:"), BorderLayout.WEST);
		f2 = new JTextField(20);
		f2.setEditable(true);
		f2.addFocusListener(new FocusLoseListener(true));
		p2.add(f2);
		setVisible(true);
		
	}
	private class OkButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(decode)
				f1.setText(CaesarCode.caesarDecode(f2.getText(), (char)jcb.getSelectedItem()));
			else
				f2.setText(CaesarCode.caesarCode(f1.getText(), (char)jcb.getSelectedItem()));
		}
		
	}
	private class FocusLoseListener implements FocusListener{
		private boolean bo;
		public FocusLoseListener(boolean b){
			bo = b;
		}
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			decode = bo;
		}
		
	}
	private class InputKeyListener implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			f2.setText(CaesarCode.caesarCode(f1.getText(), (char)jcb.getSelectedItem()));

		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			f2.setText(CaesarCode.caesarCode(f1.getText(), (char)jcb.getSelectedItem()));
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			f2.setText(CaesarCode.caesarCode(f1.getText(), (char)jcb.getSelectedItem()));

		}
		
	}
}
