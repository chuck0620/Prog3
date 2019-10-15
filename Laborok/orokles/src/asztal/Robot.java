package asztal;
import asztal.Jatekos;
public class Robot extends Jatekos{

	public Robot() {
		// TODO Auto-generated constructor stub
		id = sorszam++;
	}
	public void lep(){
		System.out.println(this.toString() + asztal.getKor() + ". kor");
	}
	public String toString(){
		return "Robot" + id + " ";
	}

}
