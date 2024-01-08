
import java.util.*;
import java.io.*;

class Way implements Comparable<Way> {
	int end;
	int weight;
	
	Way(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Way w) {
		return weight - w.weight;
	}
}
public class Note {
	
	static final int INF = 200000000;
	static int n,m,t;
	static int s,g,h;
	static ArrayList<ArrayList<Way>> list;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		while(T>0) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); //교차로 수
			m = Integer.parseInt(st.nextToken()); //도로 수
			t = Integer.parseInt(st.nextToken()); //목적지 후보 수
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()); //출발 점
			g = Integer.parseInt(st.nextToken()); //지나간 교차로1
			h = Integer.parseInt(st.nextToken()); //지나간 교차로2
			
			list = new ArrayList<>();
			for(int i=0; i<=n; i++) {
				list.add(new ArrayList<>());
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list.get(start).add(new Way(end, weight));
				list.get(end).add(new Way(start, weight));
			}
			
			int[] destination = new int[t];
			for(int i=0; i<t; i++) {
				destination[i] = Integer.parseInt(br.readLine());
			}
			
			List<Integer> ansList = new ArrayList<>();
			
			for(int i=0; i<t; i++) {				
				int res1 = 0;
				res1 += dijkstra(s, g);
				res1 += dijkstra(g,h);
				res1 += dijkstra(h,destination[i]);
				
				int res2 = 0;
				res2 += dijkstra(s,h);
				res2 += dijkstra(h,g);
				res2 += dijkstra(g, destination[i]);
				
				//경유하지 않고 바로
				int res3 = 0;
				res3 += dijkstra(s,destination[i]);
				
				if(res1>=INF && res2>=INF) continue;
				else if(Math.min(res1, res2) != res3) {
					continue;
				} else {
					ansList.add(destination[i]);
				}
			}
			Collections.sort(ansList);
			for(int i : ansList) {
				bw.write(i + " ");
			}
			bw.write("\n");
			T--;
		}

		//bw.flush();
		bw.close();
		br.close();
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Way> pq = new PriorityQueue<>();
		pq.add(new Way(start, 0));
		
		boolean[] check = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Way curRoute = pq.poll();
			int cur = curRoute.end;
			
			if(!check[cur]) {
				check[cur] = true;
				
				for(Way w : list.get(cur)) {
					if(!check[w.end] && dist[w.end] > dist[cur] + w.weight) {
						dist[w.end] = dist[cur] + w.weight;
						pq.add(new Way(w.end, dist[w.end]));
					}
				}
			}
		}
		return dist[end];
	}
	
}

