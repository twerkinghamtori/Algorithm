package search;

import java.util.*;
import java.io.*;

//백준 11724 연결요소의 개수 구하기 dfs
public class ConnectedComponent {
	
	static boolean visited[]; //방문확인
	static ArrayList<Integer>[] list; //인접리스트
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //정점의 개수
		int m = Integer.parseInt(st.nextToken()); //간선의 개수
		
		visited = new boolean[n+1]; 
		list = new ArrayList[n+1];
		
		//인접리스트 생성
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<m+1; i++) {
			st = new StringTokenizer(br.readLine());
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    //무방향이기 때문에 인접리스트에 둘 다 저장
		    list[s].add(e);
		    list[e].add(s);
		}
		
		int cnt = 0;
		for(int i=1; i<n+1; i++) {
			//방문하지 않았다면 카운트
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int v) {
		//현재 노드 == 방문하지 않은 노드
		if(!visited[v]) {
			visited[v] = true; //방문처리
			//인접리스트에서 방문하지 않은 노드 탐색
			for(int i : list[v]) {
				dfs(i);
			}
		} else return;
	}

}
