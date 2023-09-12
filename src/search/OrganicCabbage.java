package search;

import java.util.*;
import java.io.*;

//백준 1012 유기농배추 dfs

public class OrganicCabbage {
	
	static boolean visited[][]; //방문 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); //가로
			int n = Integer.parseInt(st.nextToken()); //세로
			int k = Integer.parseInt(st.nextToken()); //배추 개수
			
			int[][] arr = new int[n+2][m+2]; //상하좌우 비교를 위해 테두리까지 배열 생성
			
			for(int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine());
				int right = Integer.parseInt(st.nextToken());
				int left = Integer.parseInt(st.nextToken());
				arr[left+1][right+1] = 1;
			}
			
			visited = new boolean[n+2][m+2]; //배열과 같은 크기로 방문배열 생성
			
			int cnt = 0;
			
			for(int y=1; y<n+1; y++) {
				for(int x=1; x<m+1; x++) {
					if(arr[y][x]==1) { //배추 o
						if(!visited[y][x]) { //방문 x
							cnt++; //카운트
							dfs(y,x, arr);
						}						
					} 
				}
			}
			
			System.out.println(cnt);
			
		}
	}

	private static void dfs(int y, int x, int[][] arr) {
		if(!visited[y][x]) {
			
			visited[y][x] = true;
			//상하좌우 판별
			
			if(arr[y-1][x] == 1) {
				dfs(y-1,x, arr);
			} 
			if(arr[y+1][x] == 1) {
				dfs(y+1, x, arr);
			} 
			if(arr[y][x-1] == 1) {
				dfs(y, x-1, arr);
			} 
			if(arr[y][x+1] == 1) {
				dfs(y, x+1, arr);
			} 
			else return;
		} else return;
		
	}
}
