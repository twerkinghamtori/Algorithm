
import java.util.*;
import java.io.*;

public class Note {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[2];
		for(int i=0; i<s.length(); i++) {
			arr[Integer.parseInt(s.substring(i,i+1))]++;
		}
		arr[0]/=2;
		arr[1]/=2;
		
		for(int i=0; i<s.length() && arr[1]!=0; i++) {
			if(s.charAt(i) == '1') {
																															
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=arr[0]/2; i++) {
			sb.append("0");
		}
		for(int i=1; i<=arr[1]/2; i++) {
			sb.append("1");
		}																
		System.out.println(sb.toString());
	}
}

