package complete;

import java.util.*;
import java.io.*;

//백준 1504 특정한 최단 경로 다익스트라
class Route implements Comparable<Route> {
	int end;
	int weight;
	
	Route(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Route r) {
		return weight - r.weight;
	}
}
public class SpecificShortestPath {
	static final int INF = 200000000;
	static int N,E,u,v;
	static ArrayList<ArrayList<Route>> list;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(start).add(new Route(end, weight));
			list.get(end).add(new Route(start, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		int[] dist1 = dijkstra(list, 1);
		int[] dist2 = dijkstra(list, u);
		int[] dist3 = dijkstra(list, v);
		
		// 1 -> u -> v -> N으로 가는 경우
		int dir1 = dist1[u] + dist2[v] + dist3[N]; 
		
		// 1 -> v -> u -> N으로 가는 경우
		int dir2 = dist1[v] + dist3[u] + dist2[N];
		
		int answer = (dir1 >= INF && dir2 >= INF) ? -1 : Math.min(dir1, dir2);
		
		bw.write(answer + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] dijkstra(ArrayList<ArrayList<Route>> a, int first) {
		PriorityQueue<Route> pq = new PriorityQueue<>();
		pq.add(new Route(first, 0));
		
		boolean[] check = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[first] = 0;
		
		while(!pq.isEmpty()) {
			Route curRoute = pq.poll();
			int cur = curRoute.end;
			
			if(!check[cur]) {
				check[cur] = true;
				
				for(Route r : a.get(cur)) {
					if(!check[r.end] && dist[r.end] > dist[cur] + r.weight) {
						dist[r.end] = dist[cur] + r.weight;
						pq.add(new Route(r.end, dist[r.end]));
					}
				}
			}
		}
		return dist;
	}
	
}
