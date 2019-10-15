package lab5;
import java.lang.*;
import java.util.*;

import lab5.*;

import java.io.*;
public class Consumer extends Thread{
	Fifo tar;
	String str;
	int num;
	Consumer(Fifo f, String s, int n){
		tar = f;
		str = s;
		num = n;
	}
	public void run(){
		try {
		while(true){
			
				System.out.println("consumed " + str + " " + tar.get() + " " + System.currentTimeMillis() % 100000);
				sleep(num);
			
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
