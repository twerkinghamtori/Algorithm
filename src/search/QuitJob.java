package search;

import java.util.*;
import java.io.*;

//삼성 SW 역량 테스트 기출 문제
//백준 14501 퇴사 dfs
public class QuitJob {
	static int n;
	static int[] t;
	static int[] p;	
	static int answer;
	public static void main(String args[]) throws IOException {
		//입력 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		t = new int[n];
		p = new int[n];																						
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		answer = 0;
		
		dfs(0,0);
		
		System.out.println(answer);
	}
	
	private static void dfs(int idx, int pay) {
		//탈출 포인트
		if(idx >= n) {
			answer = Math.max(answer, pay);
			return;
		}		
		if(idx + t[idx] <= n) { //상담을 끝 마칠 수 있는 경우
			dfs(idx + t[idx], pay + p[idx]); 
		} else { //상담을 끝 마칠 수 없는 경우
			dfs(idx + t[idx], pay);
		}
		
		//다음 날짜를 탐색
		dfs(idx+1, pay);
	}

//	dfs(0, 0)
//	  dfs(3, 10)
//	    dfs(4, 10)
//	      dfs(6, 50)
//	        dfs(7, 250)
//	    dfs(5, 20)
//	      dfs(7, 220)
//	  dfs(1, 10)
//	    dfs(2, 10)
//	      dfs(4, 50)
//	        dfs(5, 90)
//	          dfs(7, 290)
//	        dfs(6, 80)
//	          dfs(7, 290)
//	      dfs(3, 10)
//	        dfs(5, 40)
//	          dfs(7, 240)
//	        dfs(4, 20)
//	          dfs(6, 30)
//	            dfs(7, 230)
//	    dfs(3, 10)
//	      dfs(5, 40)
//	        dfs(7, 240)
//	      dfs(4, 20)
//	        dfs(6, 30)
//	          dfs(7, 230)
//	  dfs(2, 0)
//	    dfs(4, 40)
//	      dfs(5, 80)
//	        dfs(7, 280)
//	      dfs(6, 70)
//	        dfs(7, 280)
//	    dfs(3, 0)
//	      dfs(5, 30)
//	        dfs(7, 230)
//	      dfs(4, 0)
//	        dfs(6, 10)
//	          dfs(7, 220)
}
