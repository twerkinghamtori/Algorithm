package search;

import java.util.*;
import java.io.*;

//백준 2667 단지번호 붙이기 dfs
//유기농 배추 문제와 거의 유사함, 인접한 요소 따로 카운트 하는 것만 추가
public class NumberingAPT {
	
	static boolean visited[][];
	static int apts;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][]arr = new int[n+2][n+2];
		visited = new boolean[n+2][n+2];
		
		for(int i=1; i<n+1; i++) {
			String[] s = br.readLine().split("");
			for(int j=1; j<n+1; j++) {
				arr[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		int cnt = 0;
		apts = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(arr[i][j]==1) {
					if(!visited[i][j]) {
						cnt++;
						dfs(i,j,arr);
						list.add(apts);
						apts=0;
					}
				}
			}
		}
		System.out.println(cnt);
		list.sort((o1,o2) -> o1-o2);
		for(int i : list) {
			System.out.println(i);
		}
	}

	private static void dfs(int y, int x, int[][] arr) {
		if(!visited[y][x]) {
			visited[y][x] = true;
			apts++;
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
