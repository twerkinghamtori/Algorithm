import java.io.*;
import java.util.*;

public class Note1 {
	
	static int[] X = {0,0,1,-1};
	static int[] Y = {1,-1,0,0};
	
	static int max = Integer.MIN_VALUE;
	static int n,m;
	
	static boolean[][] visited;
	static int[][] board;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, board[i][j]);
				visited[i][j] = false;
				
				combi(0, 0, i, j, board[i][j]); //인접한 4칸 중 3칸 고르기(ㅗ,ㅓ,ㅏ,ㅜ);
			}
		}
		
		System.out.println(max);
		
		br.close();
		
	} 
	
	private static void dfs(int x, int y, int depth, int sum) {
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=-0; i<4; i++) {
			int newx = x + X[i];
			int newy = y + Y[i];
			
			if(newx<0 || newy<0 || newx>=n || newy>=m) continue;
			if(visited[newx][newy]) continue;
			
			visited[newx][newy] = true;
			dfs(newx, newy, depth+1, sum+board[newx][newy]);
			visited[newx][newy] = false;
		}
	}
	
	private static void combi(int depth, int start, int x, int y, int sum) {
		if(depth == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int d=start; d<4; d++) {
			int newx = x + X[d];
			int newy = y + Y[d];
			
			if(newx<0 || newy<0 || newx>=n || newy>=m) continue;
			
			combi(depth+1, d+1, x, y, sum+board[newx][newy]);	
		}
	}
	
	
}
