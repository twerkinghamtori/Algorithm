package search;

import java.util.*;
import java.io.*;

//백준 4963 섬의 개수 dfs
public class IslandCount {
	
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			String s = br.readLine();
			if(s.equals("0 0")) break;
			st = new StringTokenizer(s);
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int[][] arr = new int[h+2][w+2];
			visited = new boolean[h+2][w+2];
			for(int i=1; i<h+1; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<w+1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i=1; i<h+1; i++) {
				for(int j=1; j<w+1; j++) {
					if(arr[i][j] == 1) {
						if(!visited[i][j]) {
							cnt++;
							dfs(i,j,arr);
						}
					}					
				}
			}
			System.out.println(cnt);
			
		}
	}
	
	static void dfs(int y, int x, int[][] arr) {
		if(!visited[y][x]) {
			visited[y][x] = true;
			for(int i=y-1; i<=y+1; i++) {
				for(int j=x-1; j<=x+1; j++) {
					if(i==y&&j==x) continue;
					else {
						if(arr[i][j] == 1) {
							dfs(i,j,arr);
						}
					}
				}
			}
		} else return;
	}

}
