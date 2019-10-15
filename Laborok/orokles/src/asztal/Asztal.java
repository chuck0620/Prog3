package asztal;
import asztal.Jatekos;
public class Asztal {
private Jatekos jatekosok[];
private double tet;
private int korok;
	public Asztal() {
		// TODO Auto-generated constructor stub
		jatekosok = new Jatekos[10];
		tet = 0;
		korok = 1;
	}
	public void ujJatek(){ //TODO reset everything
		for(int i = 0; i < jatekosok.length; i++){
			jatekosok[i]= null;
		}
		tet = 0;
		korok = 1;
	}
	public void addJatekos(Jatekos j){ //TODO add new jatekos to the array
		j.asztal = this;
		while(true){
			for(int i = 0; i < 10; i++){
				if(jatekosok[i] == null){
					jatekosok[i] = j;
					break;
				}
			}
			break;
		}
	}
	public int getKor(){
		return korok;
	}
	public void emel(double d){
		tet += d;
	}
	public void kor(){ //TODO lep() every jatekosok[i]
		for(int i = 0; i < 10; i++){
			if(jatekosok[i] != null){
			jatekosok[i].lep();
			}
		}
		korok += 1;
	}

}
