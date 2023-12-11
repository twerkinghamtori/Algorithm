
import java.util.*;
import java.io.*;

public class Note {
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
		for(int i=0; i<n; i++) {
			dfs(0,i, path[0][i], -2);
		}
		System.out.println(answer);
	}
	
	private static void dfs(int x, int y, int sum, int lastdir) {
		if(x == m-1) {
			answer = Math.min(answer, sum);
			return;
		} 		
		
		for(int i=0; i<=2; i++) {
			int nx = x+1;
			int ny = y+i-1;
			if(ny<0 || ny>=n || i-1 == lastdir) continue;
			dfs(nx, ny, sum + path[nx][ny], i-1);
		}
	}
}
