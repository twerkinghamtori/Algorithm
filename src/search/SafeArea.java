package search;

import java.util.*;
import java.io.*;

//백준 2468 안전 영역 dfs

public class SafeArea {
	
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] heights = new int[n+2][n+2];
		
		
		StringTokenizer st;
		int max = 0;
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				heights[i][j] = Integer.parseInt(st.nextToken());
				if(max < heights[i][j]) max = heights[i][j];
			}
		}
		
		int safe = -1;
		int index = 0;
		
		while(index <= max) {
			int temp[][] = new int[n+2][n+2];
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(heights[i][j]>index) {
						temp[i][j] = 1;
					}
				}
			}
			
			visited = new boolean[n+2][n+2];
			
			int cnt = 0;
			
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(temp[i][j]==1) {
						if(!visited[i][j]) {
							cnt++;
							dfs(i,j,temp);
						}
					}
				}
			}
			
			safe = Math.max(safe, cnt);
			index ++;
		}
		
		System.out.println(safe);
	}
	
	private static void dfs(int y, int x, int[][] temp) {
		if(!visited[y][x]) {
			visited[y][x] = true;
			
			if(temp[y-1][x] == 1) {
				dfs(y-1, x, temp);
			}
			if(temp[y+1][x] == 1) {
				dfs(y+1, x, temp);
			}
			if(temp[y][x-1] == 1) {
				dfs(y, x-1, temp);
			}
			if(temp[y][x+1] == 1) {
				dfs(y, x+1, temp);
			}
			else return;
		}
		else return;
	}

}
