
import java.util.*;
import java.io.*;

public class Note {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s.equals("end")) break;
			boolean can = true;
			int cnt = 0;
			int v = 0;
			int w = 0;
			for(int i=0; i<s.length(); i++) {
				if(isVowel(s.charAt(i))) {
					v++;
					w=0;
					cnt++;
				} 
				else {
					w++;
					v=0;
				}
//				System.out.println(v + " " + w);
				if(w>=3 || v>=3) {
					can = false;
					break;
				}
			}
			for(int i=0; i<s.length()-1; i++) {
				if(s.charAt(i) == s.charAt(i+1)) {
					if(s.charAt(i) != 'e' && s.charAt(i) != 'o') can = false;
				}
			}
			if(cnt == 0) can = false;
			if(can) {
				System.out.println("<" + s + "> is acceptable.");
			} else {
				System.out.println("<" + s + "> is not acceptable.");
			}
		}
		
	}
	
	private static boolean isVowel(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
		else return false;
	}

}
