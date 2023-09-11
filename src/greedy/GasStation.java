package greedy;

import java.util.*;
import java.io.*;

//백준 13305 주유소 
//2중 포문 사용 => 시간초과남 => 알고리즘 간소화
public class GasStation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] distance = new long[n-1];
		for(int i=0; i<distance.length; i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		long[] price = new long[n];
		for(int i=0; i<price.length; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}
		
		long sum = 0;
		long min = price[0];
		
		for(int i=0; i<distance.length; i++) {
			
			if(price[i] < min) {
				min = price[i];
			}
			
			sum += min * distance[i];
		}
		
		System.out.println(sum);		
		
	}

}
