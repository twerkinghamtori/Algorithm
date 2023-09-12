package search;

import java.io.*;

//백준 10026 적록색약 dfs

public class RedGreenBlind {
	
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[][] paint = new String[n+2][n+2];
		String[][] blind = new String[n+2][n+2];
		
		visited = new boolean[n+2][n+2];
		
		for(int i=0; i<paint.length; i++) {
			for(int j=0; j<paint[i].length; j++) {
				paint[i][j] = "";
				blind[i][j] = "";
			}
		}
		
		for(int i=1; i<n+1; i++) {
			String[] temp = br.readLine().split("");
			for(int j=1; j<n+1; j++) {
				paint[i][j] = temp[j-1];
				if(temp[j-1].equals("G")) {
					blind[i][j] = "R";
				} else {
					blind[i][j] = temp[j-1];
				}
			}
		}
		
		int pcnt = 0;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(!visited[i][j]) {
					pcnt++;
					dfs(i,j,paint, paint[i][j]);
				}
			}
		}
		
		visited = new boolean[n+2][n+2];
		int bcnt = 0;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(!visited[i][j]) {
					bcnt++;
					dfs(i,j,blind, blind[i][j]);
				}
			}
		}
		System.out.println(pcnt + " " + bcnt);

	}
	
	private static void dfs(int y, int x, String[][] paint, String color) {
		if(!visited[y][x]) {
			visited[y][x] = true;
			
			if(paint[y-1][x].equals(color)) {
				dfs(y-1,x, paint, color);
			} 
			if(paint[y+1][x].equals(color)) {
				dfs(y+1, x, paint, color);
			} 
			if(paint[y][x+1].equals(color)) {
				dfs(y, x+1, paint, color);
			} 
			if(paint[y][x-1].equals(color)) {
				dfs(y, x-1, paint, color);
			} 
			else return;
		} else return;		
	}

}
