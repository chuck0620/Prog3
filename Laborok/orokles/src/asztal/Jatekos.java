package asztal;
import asztal.Asztal;
abstract class Jatekos {
	protected Asztal asztal;
	public static int sorszam = 0;
	protected int id;
	public Jatekos() {
		// TODO Auto-generated constructor stub
		asztal = new Asztal();
	}
	public void lep(){
		
	}
	public void setAsztal(Asztal a){
		asztal = a;
	}
}
