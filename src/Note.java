
import java.util.*;
import java.io.*;

public class Note {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int[] switches = new int[s+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=s; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		while(n>0) {
			n--;
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				for(int i=num; i<switches.length; i+=num) {
					if(switches[i] == 1) switches[i] = 0;
					else switches[i] = 1;
				}
			} else {
				int end_point = 0;
				for(int i=1; i<switches.length; i++) {
					if(num-i<1 || num+i>=switches.length) break;
					if(switches[num-i] == switches[num+i]) {
						end_point = i;
					} else {
						break;
					}
				}
				if(switches[num] == 1) switches[num] = 0;
				else switches[num] = 1;
				for(int i=1; i<=end_point; i++) {
					if(switches[num-i] == 1) switches[num-i] = 0;
					else switches[num-i] = 1;
					if(switches[num+i] == 1) switches[num+i] = 0;
					else switches[num+i] = 1;
				}
			}
//			for(int i=1; i<switches.length; i++) {
//				System.out.print(switches[i] + " ");
//			}
//			System.out.println();
		}
		
		for (int i = 1; i < switches.length; i++) {
		    System.out.print(switches[i] + " ");
		    if (i % 20 == 0) {
		        System.out.println();
		    }
		}
		
	}
}
