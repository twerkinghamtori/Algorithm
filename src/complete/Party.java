package complete;

import java.util.*;
import java.io.*;

//백준 1238 파티 다익스트라
//X를 정점으로 왔다가 돌아가는 최단 경로를 탐색하기 위해서 입력값을 반대로 받는 reverse_arrList를 활용
class Town implements Comparable<Town> {
    int end;
    int weight;
 
    Town(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
 
    @Override
    public int compareTo(Town t) {
        return weight - t.weight;
    }
}


public class Party {
	static final int INF = 987654321;
    static ArrayList<ArrayList<Town>> arrList, reverse_arrList;
    static int N, X;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());	
		X = Integer.parseInt(st.nextToken());
		
		arrList = new ArrayList<>(); //문제 입력 그대로 (X -> 모든 정점의 최단 거리)
		reverse_arrList = new ArrayList<>(); //문제 입력을 반대로 (모든 정점 -> X 의 최단 거리, 출발점을 X로 해서 다익스트라로 풀기 위해서 입력을 반대로)
		
		for(int i=0; i<=N; i++) {
			arrList.add(new ArrayList<>());
			reverse_arrList.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			arrList.get(start).add(new Town(end, weight));
			reverse_arrList.get(end).add(new Town(start, weight));
		}
		
		int[] dist1 = dijkstra(arrList); //X에서 시작점 까지의 최단거리
		int[] dist2 = dijkstra(reverse_arrList); //시작점들에서 X까지의 최단거리
		
		for(int i : dist1) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i : dist2) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			ans = Math.max(ans, dist1[i] + dist2[i]);
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int[] dijkstra(ArrayList<ArrayList<Town>> a) {
		PriorityQueue<Town> pq = new PriorityQueue<>();
		pq.offer(new Town(X,0));
		
		boolean[] check = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[X] = 0;
		
		while(!pq.isEmpty()) {
			Town curTown = pq.poll();
			int cur = curTown.end;
			
			if(!check[cur]) {
				check[cur] = true;
				
				for(Town t : a.get(cur)) {
					if(!check[t.end] && dist[t.end] > dist[cur] + t.weight) {
						dist[t.end] = dist[cur] + t.weight;
						pq.add(new Town(t.end, dist[t.end]));
					}
				}
			}
		}
		
		return dist;
	}
}
