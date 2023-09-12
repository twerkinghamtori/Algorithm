package search;

import java.util.*;
import java.io.*;

//백준 2606 바이러스 dfs
//연결된 요소 개수 구하는 문제와 거의 동일, 카운트 하는 지점만 다름
public class Virus {
	
	static boolean visited[];
	static ArrayList<Integer> list[];
	static int cnt = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int computer = Integer.parseInt(br.readLine());
		int node = Integer.parseInt(br.readLine());
		
		visited = new boolean[computer+1];
		list = new ArrayList[computer+1];
		
		for(int i=1; i<computer+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<node+1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		dfs(1);
		System.out.println(cnt);
	}
	
	static void dfs(int v) {
		if(!visited[v]) {
			visited[v] = true;
			cnt++;
			for(int i : list[v]) {
				dfs(i);
			}
		} else return;
	}

}
