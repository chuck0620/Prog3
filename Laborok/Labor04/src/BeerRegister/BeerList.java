package BeerRegister;
import java.io.*;
import java.util.*;
import BeerRegister.*;

public class BeerList implements Serializable{
	public List<Beer> lista= new ArrayList<Beer>();
	public void add(Beer b){
		lista.add(b);
	}
	public void list(String[] cmd){
		if(cmd.length == 2){
			if(cmd[1].equals("name")){
				NameComparator c = new NameComparator<Beer>();
				lista.sort(c);
			}
			if(cmd[1].equals("style")){
				StyleComparator c = new StyleComparator<Beer>();
				lista.sort(c);
			}
			if(cmd[1].equals("strength")){
				StrengthComparator c = new StrengthComparator<Beer>();
				lista.sort(c);
			}
		}
		for(int i = 0; i<lista.size();i++){
			System.out.println(lista.get(i).toString());
		}
	}
	public void delete(String[] cmd){
		Beer tmp = new Beer(cmd[1], "", 0);
		NameComparator c = new NameComparator<Beer>();
		int index = Collections.binarySearch(lista, tmp, c);
		if(index >= 0){
			lista.remove(index);
		}
		else{
			System.out.println("Nincs ilyen nevu elem!");
		}
	}
}
