package greedy;

import java.util.*;
import java.io.*;

public class Coin0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] money = new int[n];
		for(int i=0; i<n; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(money);
		int answer = 0;
		
		for(int i=n-1; i>=0; i--) {
			if(k/money[i]>0) {
				answer += k/money[i];
				k = k%money[i];
			}
		}
		System.out.println(answer);
	}

}
