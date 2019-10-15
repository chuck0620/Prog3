package BeerRegister;
import java.io.*;
public class BeerRegister {

	public static void main(String[] args) {
		try{
			Reader r = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(r);
			String line = new String();
			BeerList lista = new BeerList();
			while(true){
				line = br.readLine();
				if(line.equals(null) || line.equals("")){
					break;
				}
				String cmd[] = line.split(" ");
				if(cmd[0].equals("add")){
					lista.add(new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3])));
				}
				else if(cmd[0].equals("list")){
					lista.list(cmd);
				}
				else if(cmd[0].equals("save")){
					FileOutputStream fos = new FileOutputStream(cmd[1]);
					ObjectOutputStream out = new ObjectOutputStream(fos);
					out.writeObject(lista);
					out.close();
				}
				else if(cmd[0].equals("load")){
					File from = new File(cmd[1]);
					if(from.exists()){
						FileInputStream fis = new FileInputStream(cmd[1]);
						ObjectInputStream ois = new ObjectInputStream(fis);
						lista = (BeerList) ois.readObject();
						ois.close();
					}
					else {System.out.println("Nincs ilyen nevu file!");}
				}
				else if (cmd[0].equals("delete")) {
					lista.delete(cmd);
				}
				}
				br.close();
			
		}catch(Exception e){System.out.println(e.getMessage());}

	}

}
