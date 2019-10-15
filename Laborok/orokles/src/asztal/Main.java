package asztal;
import asztal.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Asztal asztal = new Asztal();
		Kezdo p1 = new Kezdo(), p2 = new Kezdo();
		Robot p3 = new Robot();
		asztal.addJatekos(p1);
		asztal.addJatekos(p2);
		asztal.addJatekos(p3);
		asztal.kor();
		asztal.kor();
		asztal.kor();
		
		
	}

}
