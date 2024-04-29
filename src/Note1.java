import java.io.*;
import java.util.*;

public class Note1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());

		ArrayList<int[]> a;
		ArrayList<ArrayList<Integer>> graph;
		
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0) {

			int storeNum = Integer.parseInt(br.readLine());
			
			a = new ArrayList<>();
			
			for(int i=0; i<storeNum+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				a.add(new int[] {x,y});
			}
			
			graph = new ArrayList<>();
			
			for(int i=0; i<storeNum+2; i++) {
				graph.add(new ArrayList<>());
			}
			
			//맨해튼 거리 1000m이하를 만족하는 두 정점 찾음
			//graph에 양방향 그래프로 이어줌
			for(int i=0; i<storeNum+2; i++) {
				for(int j=i+1; j<storeNum+2; j++) {
					if(Manhattan(a.get(i),a.get(j)) <= 1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			
			sb.append((bfs(graph, storeNum) ? "happy" : "sad") + "\n");
		}	
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	} 
	
	private static int Manhattan(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
	
	private static boolean bfs(ArrayList<ArrayList<Integer>> graph, int N) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		
		boolean[] visited = new boolean[N+2];
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == N+1) {
				return true;
			}
			
			for(int next : graph.get(now)) {
				if(!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		return false;
	}
}
