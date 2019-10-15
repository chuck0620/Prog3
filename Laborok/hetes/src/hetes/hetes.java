package hetes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sample.calc.*;

public class hetes {

	public static void main(String[] args) throws IOException {
		int a, sum = 0;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Calculator c = new Calculator();
		while(true)
		{	
			String line = br.readLine();
			if(line == null || line.equals("")) break;
			a = Integer.parseInt(line);
			sum = c.add(a, sum);
			
		}
			System.out.println("sum=" + sum);
	}

}
