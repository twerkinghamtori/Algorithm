package complete;
import java.util.*;
import java.io.*;

//백준 2606 바이러스
//DFS, BFS연습

public class Virus {
	static List<int[]> network = new ArrayList<>();
	static List<int[]> first = new ArrayList<>();
	static int n;
	static List<Integer> virus = new ArrayList<>();
	static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			if(left == 1) first.add(new int[] {left, right});
			else network.add(new int[] {left,right });
		}
		
		for(int i=0; i<first.size(); i++) {
			dfs(0,first.get(i)[1]);
		}
//		for(int i : virus) {
//			System.out.println(i);
//		}
		System.out.println(virus.size());

	}
	
	static void dfs(int depth, int end) {
		if(depth == n) return;
		
		for(int i=0; i<network.size(); i++) {
			if(network.get(i)[0] == end) {
				if(!virus.contains(network.get(i)[0])) {
					virus.add(network.get(i)[0]);
				}			
				if(!virus.contains(network.get(i)[1])) {
					virus.add(network.get(i)[1]);
				}
				dfs(depth+1, network.get(i)[0]);
			}
		}
	}

}
