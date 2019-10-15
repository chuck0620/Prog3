package BeerRegister;
import java.io.*;

public class Beer implements Serializable{
	public String name;
	public String style;
	public double strength;
	
	Beer(String nev, String stilus, double ero){
		name = nev;
		style = stilus;
		strength = ero;
	}
	
	public String getName(){
		return name;
	}
	
	public String getStyle(){
		return style;
	}
	
	public double getStrength(){
		return strength;
	}
	
	public String toString(){
		return name + " " + style + " " + strength;
	}
}
