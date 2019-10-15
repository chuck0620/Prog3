package main;
import java.io.*;
import java.util.LinkedList;

public class Command {
	protected void exit(){
		System.exit(0);
	}
	protected String cd(String[] cmd, String wd) throws IOException{
		File f = new File(wd); 
		if(cmd.length == 1){
			File uj = new File(f.getPath());
			if(uj.exists()){
				String path = f.getPath();
				return path;
			}
		}
		if(cmd[1].equals("..")) return f.getParent();
		File uj = new File(f.getPath(), cmd[1]);
		if(uj.exists()){
			String path = f.getPath() + "\\" + cmd[1];
			return path;
		}
		else System.out.println("Nincs ilyen mappa!");
		return f.getPath();
	}
	protected void pwd(String wd) throws IOException{
		File f = new File(wd);
		System.out.println(f.getCanonicalPath());
	}
	protected void ls(String[] cmd, String wd){
		File f = new File(wd);
		String[] list = f.list();
		for(int i = 0; i<list.length; i++){
			if(cmd.length == 2){
				if(cmd[1].equals("-l")){
					File temp = new File(wd, list[i]);
					if(temp.isDirectory()) System.out.println(list[i] + "  d");
					if(temp.isFile()) System.out.println(list[i] + " f " + temp.length() + " byte");
				}
			}
			else System.out.println(list[i]);
		}
		
	}
	protected void length(String[] cmd, String wd){
		File f = new File(wd, cmd[1]);
		if(f.exists() && f.isFile()) System.out.println(f.length() + " byte");
		else System.out.println("Ez a fajl nem letezik!");
	}
	protected void tail(String[] cmd, String wd) throws IOException{
		int n = 0;
		int fajl = 0;
		if(cmd.length == 2){
			n = 10;
			fajl = 1;
			}
		else{ 
			fajl = 3;
			n = Integer.parseInt(cmd[2]);
		}
		
			File f = new File(wd, cmd[fajl]);
			if(f.exists() && f.isFile()){
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				LinkedList<String> l = new LinkedList<String>();
				while(true){
					String line = br.readLine();
					if(line != null) l.addFirst(line);
					else break;
				}
				for(int i = 0; i<n; i++){
					System.out.println(l.get(n-i));
				}
			}
			else System.out.println("A fajl nem letezik!");
		
	}
	protected void grep(String[] cmd, String wd) throws IOException{
		File f = new File(wd, cmd[2]);
		if(f.exists() && f.isFile()){
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			LinkedList<String> l = new LinkedList<String>();
			while(true){
				String line = br.readLine();
				if(line != null && line.matches(cmd[1])) System.out.println(line);
				else break;
			}
		}
		else System.out.println("A fajl nem letezik!");
	}
}

