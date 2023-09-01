package complete;
import java.util.*;
import java.io.*;

/*
삼성 SW 역량 테스트 기출 문제
백준 13485 시험감독
 */
public class TestSupervisor {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long answer = 0;
		
		answer += n;
		
		for(int i=0; i<n; i++) {
			arr[i] -= b;
			if(arr[i]<=0) continue;
			if(arr[i]%c != 0) {
				answer += arr[i]/c +1;
			} else {
				answer += arr[i]/c;
			}			
		}
		System.out.println(answer);
	}

}
