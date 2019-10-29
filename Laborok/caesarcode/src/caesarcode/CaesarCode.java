package caesarcode;

public class CaesarCode {
	public final static String caesarCode(String input, char offset){
		String s = "";
		
		input = input.toUpperCase();
		offset = Character.toUpperCase(offset);
		int intoffset = (int)offset - (int)'A';
		for(int i=0; i<input.length(); i++){
			char c = (char)(input.charAt(i) + intoffset);
			if(c > 'Z')
				s+= (char)(input.charAt(i) - (26-intoffset));
			else
				s += c;
		}
		
		return s;
	}
	public final static String caesarDecode(String input, char offset){
		String s = "";
		
		input = input.toUpperCase();
		offset = Character.toUpperCase(offset);
		int intoffset = (int)offset - (int)'A';
		for(int i=0; i<input.length(); i++){
			char c = (char)(input.charAt(i) - intoffset);
			if(c < 'A')
				s+= (char)(input.charAt(i) + (26-intoffset));
			else
				s += c;
		}
		
		return s;
	}
}
