package complete;
import java.util.*;
import java.io.*;

/*
삼성 SW 역량 테스트 기출 문제
백준 15686 치킨배달
 */
public class ChickenDelivery {
	static int n,m;
	static int[][] map;
	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static List<int[]> chosenList = new ArrayList<>();
	static boolean[] visited;	
	static int answer = Integer.MAX_VALUE; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());		
		
		int[][] map = new int [n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					chicken.add(new int[] {i,j});
				}
				if(map[i][j] == 1) {
					house.add(new int[] {i,j});
				}
			}
		}
		
		visited = new boolean[chicken.size()];
		dfs(0,0);
		System.out.println(answer);
	}
	
	static void dfs(int depth, int start) {
		if(depth == m) {
			distance(chosenList, house);
			return;
		}
		
		for(int i=start; i<visited.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				chosenList.add(chicken.get(i));
				dfs(depth+1, i+1);
				visited[i] = false;
				chosenList.remove(chosenList.size()-1);
			}
		}		
	}
	
	static void distance(List<int[]> chosenList, List<int[]> house) {		
		int min_sum = 0;
		for(int[] h : house) {
			int min_distance = Integer.MAX_VALUE;
			for(int[] c : chosenList) {
				int d = Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]);
				min_distance = Math.min(min_distance, d);
			}
			min_sum += min_distance;
		}
		answer = Math.min(answer, min_sum);		
	}

}
