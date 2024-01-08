
import java.util.*;
import java.io.*;

class Path implements Comparable<Path> {
	int end;
	int weight;
	
	Path(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Path p) {
		return weight - p.weight;
	}
}
public class Note {
	static final int INF = 987654321;
	static ArrayList<ArrayList<Path>> list;
	static int V,E,K;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(start).add(new Path(end, weight));
		}
		
		int[] dist = dijkstra(list);
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == INF) {
				bw.write("INF" + "\n");
			} else {
				bw.write(dist[i] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] dijkstra(ArrayList<ArrayList<Path>> a) {
		PriorityQueue<Path> pq = new PriorityQueue<>();
		pq.add(new Path(K,0));
		
		boolean[] check = new boolean[V+1];
		int[] dist = new int[V+1];
		Arrays.fill(dist, INF);
		dist[K] = 0;
		
		while(!pq.isEmpty()) {
			Path curPath = pq.poll();
			int cur = curPath.end;
			
			if(!check[cur]) {
				check[cur] = true;
				
				for(Path p : a.get(cur)) {
					if(!check[p.end] && dist[p.end] > dist[cur] + p.weight) {
						dist[p.end] = dist[cur] + p.weight;
						pq.add(new Path(p.end, dist[p.end]));
					}
				}
			}
		}
		return dist;
	}
}

