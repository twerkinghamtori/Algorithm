
import java.util.*;
import java.io.*;

class Bus implements Comparable<Bus> {
	int end;
	int cost;
	
	Bus(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Bus b) {
		return cost - b.cost;
	}
}

public class Note {
	
	static final int INF = 10000000;
	static int N,M;
	static ArrayList<ArrayList<Bus>> bus;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		bus = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			bus.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			bus.get(start).add(new Bus(end, cost));			
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		bw.write(dijkstra(s,e) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.add(new Bus(start, 0));
		
		boolean[] check = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist,  INF);
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Bus curBus = pq.poll();
			int cur = curBus.end;
			
			if(!check[cur]) {
				check[cur]  = true;
				
				for(Bus b : bus.get(cur)) {
					if(!check[b.end] && dist[b.end] > dist[cur] + b.cost) {
						dist[b.end] = dist[cur] + b.cost;
						pq.add(new Bus(b.end, dist[b.end]));
					}
				}
			}
		}
		return dist[end];
	}
	
}

