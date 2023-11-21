import java.io.*;
import java.util.*;

public class Note {
	static boolean[][] visited;
	static int cnt;
	int[] X = {0,0,1,-1};
	int[] Y = {1,-1,0,0};
	static String[][] map;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		map = new String[r][c];
		visited = new boolean[r][c];
		List<String> list = new ArrayList<>();
		
		dfs(0,0,list);
		System.out.println(cnt);
	}
	
	static void dfs(int x, int y, List<String> list) {
		if(!visited[x][y]) {
			visited[x][y] = true;
			if(!list.contains(map[x][y])) {
				cnt++;
				list.add(map[x][y]);
				for(int i=0; i<4; i++) {
					int newx = x+i;
					int newy = y+i;
					if(newx<0 || newy<0 || newx>=map.length || newy>=map[0].length) continue;
					else dfs(newx, newy, list);
				}
			}			
		}
	}
}
