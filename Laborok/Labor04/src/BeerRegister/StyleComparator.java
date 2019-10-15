package BeerRegister;
import java.util.*;
import BeerRegister.Beer;

public class StyleComparator<T> implements Comparator<Beer> {
	public int compare(Beer b1, Beer b2){
		return b1.getStyle().compareTo(b2.getStyle());
	}
}
