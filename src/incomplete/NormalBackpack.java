package incomplete;

import java.util.*;
import java.io.*;

//백준 12865 평범한 배낭
//Dynamic Programming, 배낭 알고리즘 미해결
public class NormalBackpack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[n];
		int[] value = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> valueList = new ArrayList<>();
		for(int i=0; i<n-1; i++) {
			System.out.println(i);
			int w = weight[i];
			int v = value[i];
			for(int j=i+1; j<n; j++) {	
				w += weight[j];
				System.out.println(w);
				if(w <= k) {					
					v += value[j];
				} else {
					w -= weight[j];
				}
			}
			System.out.println("v저장 : " + v);
			valueList.add(v);
			System.out.println("=============");
		}
		
		valueList.sort((o1,o2) -> o2-o1);
		System.out.println(valueList.get(0));
	}

}
