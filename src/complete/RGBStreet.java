package complete;

import java.io.*;
import java.util.*;

//백준 1149 RGB거리 dp, 재귀, 반복문
/*
 * RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 
각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

[입력예시] 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 
둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 
집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

[출력]
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

3           96
26 40 83
49 60 57
13 89 99

3          3
1 100 100
100 1 100
100 100 1

6          208
30 19 5
64 77 64
15 19 97
4 71 57
90 86 84
93 32 91
 */
public class RGBStreet {
	
	final static int RED = 0;
	final static int GREEN = 1;
	final static int BLUE = 2;
	
	static int[][] dp;
	static int[][] cost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		cost = new int[N][3];
		dp = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][RED] = Integer.parseInt(st.nextToken());
			cost[i][GREEN] = Integer.parseInt(st.nextToken());
			cost[i][BLUE] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(topDown(N, cost) + "\n");
		bw.write(bottomUp(N, cost) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	//top-down 재귀 방식(동적계획법)
	static int topDown(int N, int[][] cost) {
		dp[0][RED] = cost[0][RED];
		dp[0][GREEN] = cost[0][GREEN];
		dp[0][BLUE] = cost[0][BLUE];
		
		return Math.min(paintCost(N- 1, RED), Math.min(paintCost(N - 1, GREEN), paintCost(N - 1, BLUE)));
	}
	
	static int paintCost(int N, int color) {
		//만약 탐색하지 않은 배열이라면
		if(dp[N][color] == 0) {
			//color 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 dp에 저장
			switch(color) {
				case RED : dp[N][color] = Math.min(paintCost(N-1, GREEN), paintCost(N-1, BLUE)) + cost[N][RED];
					break;
				case GREEN : dp[N][color] = Math.min(paintCost(N-1, RED), paintCost(N-1, BLUE)) + cost[N][GREEN];
					break;
				case BLUE : dp[N][color] = Math.min(paintCost(N-1, RED), paintCost(N-1, GREEN)) + cost[N][BLUE];
					break;
			}
		}
		
		return dp[N][color];
	}
	
	//=====================================================================================================================
	
	//bottom-up 반복문 방식(직관적)
	static int bottomUp(int N, int[][] cost) {
		
		for(int i=1; i<N; i++) {
			cost[i][RED] += Math.min(cost[i-1][GREEN], cost[i-1][BLUE]);
			cost[i][GREEN] += Math.min(cost[i-1][RED], cost[i-1][BLUE]);
			cost[i][BLUE] += Math.min(cost[i-1][RED], cost[i-1][GREEN]);
		}
		
		return Math.min(Math.min(cost[N-1][RED], cost[N-1][GREEN]), cost[N-1][BLUE]);
	}
}