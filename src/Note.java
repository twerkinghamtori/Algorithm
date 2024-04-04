
import java.util.*;
import java.io.*;

public class Note {

	static int[] X = {1,-1,0,0};
	static int[] Y = {0,0,1,-1};
	static int n,m;
	static int[][] arr;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		
		Queue<int[]> q = new LinkedList<>(); //빙하가 있는 위치를 담을 큐
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0) {
					q.add(new int[] {i,j});
				}				
			}
		}
		//입력 끝
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			
			//덩어리 개수가 2개 이상이면 exit
			if(calSection(arr) >= 2) {
				break;
			}
			
			int size = q.size();
			
			List<int[]> zerocnt = new ArrayList<>(); //인접한 면의 0의 개수를 저장할 리스트
			
			for(int i=0; i<size; i++) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int zero = 0;
				
				for(int j=0; j<4; j++) {
					int newx = x + X[j];
					int newy = y + Y[j];
					
					if(newx<0 || newy<0 || newx>=n || newy>=m) continue;
					
					if(arr[newx][newy] == 0) {
						zero++;
					}
				}
				zerocnt.add(new int[] {x,y,zero});
			}			
			
			//0의 개수만큼 arr 배열 수정(빙하 높이)
			for(int[] a : zerocnt) {
				if(arr[a[0]][a[1]] - a[2] < 0) {
					arr[a[0]][a[1]] = 0;
				} else {
					arr[a[0]][a[1]] -= a[2];
				}
			}
			
			//아직 녹지 않은 빙하의 위치 큐 삽입
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[i][j] > 0) {
						q.add(new int[] {i,j});
					}
				}
			}
			
			//빙하가 다 녹았을 때,
			if(q.isEmpty()) {
				//덩어리가 2개 이상으로 나누어지지 않는다면 0 출력
				if(calSection(arr) < 2) {
					cnt = 0;
				}
				break;
			}
			cnt++;
			
		}
		
		System.out.println(cnt);
	}
	
	//덩어리 계산
	private static int calSection(int[][] arr) {
		int cnt = 0;
		boolean[][] visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] > 0 && !visited[i][j]) {
					dfs(i,j, visited);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	private static void dfs(int x, int y, boolean[][] visited) {
		
		if(!visited[x][y]) {
			visited[x][y] = true;
			
			for(int i=0; i<4; i++) {
				int newx = x + X[i];
				int newy = y + Y[i];
				
				if(newx<0 || newy<0 || newx>=n || newy>=m) continue;
				
				if(arr[newx][newy] > 0) {
					dfs(newx, newy, visited);
				}
			}
		}
	}
	
}

