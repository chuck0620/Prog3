package main;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		String wd = new String();
		wd = System.getProperty("user.dir");
		try{
		while(true){
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			while(true){
				String sor = br.readLine();
				if(sor == null || sor == "") break;
				String[] cmd = sor.split(" ");
				Command c = new Command();
				if(cmd[0].equals("exit")){
					c.exit();
				}
				else if(cmd[0].equals("pwd")){
					c.pwd(wd);
				}
				else if(cmd[0].equals("cd")){
					wd = c.cd(cmd, wd);
				}
				else if(cmd[0].equals("ls")){
					c.ls(cmd, wd);
				}
				else if(cmd[0].equals("length")){
					c.length(cmd, wd);
				}
				else if(cmd[0].equals("tail")){
					c.tail(cmd, wd);
				}
				else if(cmd[0].equals("grep")){
					c.grep(cmd, wd);
				}
				}
			}
		} catch(IOException e)
		{
		}	
	}

}
