package greedy;

import java.util.*;
import java.io.*; 

public class ATM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time);
		int[] sum = new int[n];
		sum[0] = time[0];
		for(int i=1; i<time.length; i++) {
			sum[i] = sum[i-1] + time[i];
		}
		int answer = 0;
		for(int i=0; i<sum.length; i++) {
			answer += sum[i];
		}
		System.out.println(answer);
	}

}
