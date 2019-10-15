package lab5;
import java.lang.Thread;
import java.io.*;

import lab5.Fifo;

public class Producer extends Thread {
	private int num;
	private String str;
	private Fifo tar;
	private int sleepTime;
	Producer(Fifo f, String s, int t){
		str = s;
		tar = f;
		sleepTime = t;
		num = new Integer(0);
	}
	public void run(){
		try {
			this.go();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void go() throws InterruptedException{
		try {
		while(true){
			long temp = System.currentTimeMillis();
			tar.put(str + " " + num);
			System.out.println("produced " + str + " " + num + " " + Long.toString(temp).substring(Long.toString(temp).length() - 5));
			num++;
				Thread.sleep(sleepTime);
			
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
