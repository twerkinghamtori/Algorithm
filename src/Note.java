
import java.util.*;
import java.io.*;

public class Note {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		while(n>0) {
			n--;
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			
			int result = 0;
			
			int[] arr = new int[20];
			for(int i=0; i<arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<20; i++) {
				for(int j=i-1; j>=0; j--) {
					if(arr[j]>arr[i]) {
						result++;
					}
				}
			}
			
			System.out.println(t + " " + result);
		}
	}
}
