package BeerRegister;
import java.util.*;
import BeerRegister.Beer;

public class NameComparator<T> implements Comparator<Beer> {
	public int compare(Beer b1, Beer b2){
		return b1.getName().compareTo(b2.getName());
	}
}
