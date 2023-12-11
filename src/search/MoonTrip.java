package search;


import java.util.*;
import java.io.*;

//백준 17484 진우의 달 여행(Small) dfs
//같은 경로로 두 번 연속 움직이지 않도록 lastdir 매개변수 저장
public class MoonTrip {
	static int answer;
	static int m;
	static int n;
	static int[][] path;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		path = new int[m][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				path[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		answer = Integer.MAX_VALUE; 
		//첫째 줄 n개, 순서대로 dfs 시작
		for(int i=0; i<n; i++) {
			dfs(0,i, path[0][i], -2); //첫번째 줄에서 방향 없도록 하기 위해 lastdir에 -2 전달
		}
		System.out.println(answer);
	}
	
	private static void dfs(int x, int y, int sum, int lastdir) {
		//맨 아래 줄 까지 탐색하면 탐색 종료
		if(x == m-1) {
			answer = Math.min(answer, sum);
			return;
		} 		
		
		for(int i=0; i<=2; i++) {
			int nx = x+1; //한 줄 씩 아래로
			int ny = y+i-1; //-1, 0, 1 방향 탐색
			if(ny<0 || ny>=n || i-1 == lastdir) continue; //범위 벗어나거나 같은 방향으로 움직일 때, 탐색 x
			dfs(nx, ny, sum + path[nx][ny], i-1);
		}
	}
}
