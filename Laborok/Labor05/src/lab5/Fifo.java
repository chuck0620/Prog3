package lab5;
import java.util.*;
import java.lang.*;
public class Fifo {
	private ArrayList<String> list;
	{
		list = new ArrayList<String>(10);
	}
	public synchronized void put(String s) throws InterruptedException{
		while(list.size() >= 10){
			this.wait();
		}
		list.add(s);
		notify();
		
	}
	public synchronized String get() throws InterruptedException{
		while(list.isEmpty()){
			wait();
		}
		String temp = list.get(0);
		list.remove(temp);
		notify();
		return temp;
	}
}
