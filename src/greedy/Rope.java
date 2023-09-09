package greedy;

import java.util.*;

//백준 2217 로프 그리디 알고리즘 연습
public class Rope {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int[] weight = new int[n];
		
		for(int i=0; i<n; i++) {
			weight[i] = scan.nextInt();
		}
		
		Arrays.sort(weight);
		
		int[] sum = new int[n];
		sum[0] = weight[n-1];
		for(int i=1; i<n; i++) {
			sum[i] = sum[i-1] + weight[n-i-1];
		}
		
		for(int i : sum) {
			System.out.println(i);
		}
		
		int answer = sum[0]/1;
		for(int i=1; i<n; i++) {
			if(sum[i]/(i+1) >= sum[i] - sum[i-1]) {
				answer = Math.max(answer, (sum[i] - sum[i-1])*(i+1));
			}
		}
		
		System.out.println(answer);

	}

}
