
import java.util.*;
import java.io.*;

public class Note {
	static boolean[] visited;
	static int n;
	static StringBuilder sb = new StringBuilder();
	static int[][] board;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		board = new int[n+1][n+1];
		
		while(m>0) {
			m--;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			board[a][b] = 1;
			board[b][a] = 1;
		}
		visited = new boolean[n+1];
		
		dfs(v, 0);
		
		sb.append("\n");
		visited = new boolean[n+1];
		bfs(v,0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int v, int depth) {
		if(depth == n) {
			return;
		}
		
		if(!visited[v]) {
			visited[v] = true;
			sb.append(v + " ");
			for(int i=0; i<n+1; i++) {
				if(board[v][i] == 1 && !visited[i]) {
					dfs(i, depth+1);
				}
			}
		}
	}

	private static void bfs(int v, int depth) {
		if(!visited[v]) {
			q.add(v);
			visited[v] = true;
			
			while(!q.isEmpty()) {
				v = q.poll();
				sb.append(v + " ");
				
				for(int i=1; i<n+1; i++) {
					if(board[v][i] == 1 && !visited[i]) {
						q.add(i);
						visited[i]=true;
					}
				}
			}
		}
		
	}
	
}

