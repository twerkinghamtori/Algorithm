import java.util.*;
import java.io.*;

public class Note {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int cnt0 = 0;
		int cnt1 = 0;
		
		if(str.substring(0,1).equals("0")) cnt0++;
		else cnt1++;
		
		for(int i=1; i<str.length(); i++) {
			if(!str.substring(i,i+1).equals(str.substring(i-1,i))) {
				if(str.substring(i,i+1).equals("0")) cnt0++;
				else cnt1++;
			}
		}
		
		System.out.println(Math.min(cnt0, cnt1));
	}
}
