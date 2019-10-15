package BeerRegister;
import java.util.*;
import BeerRegister.Beer;

public class StrengthComparator<T> implements Comparator<Beer> {
	public int compare(Beer b1, Beer b2){
		if(b1.getStrength() > b2.getStrength()){
			return 1;
		}
		else {
			return -1;
		}
	}
}
