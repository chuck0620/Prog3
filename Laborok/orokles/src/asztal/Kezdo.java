package asztal;
import asztal.Jatekos;
public class Kezdo extends Jatekos{

	public Kezdo() {
		// TODO Auto-generated constructor stub
		id = sorszam++;
	}
	public void lep(){
		System.out.println(this.toString() + asztal.getKor() + ". kor");
	}
	public String toString(){
		return "Kezdo" + id + " ";
	}

}
