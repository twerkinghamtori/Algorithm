package search;

import java.util.*;
import java.io.*;

//백준 2252 줄세우기 위상정렬, bfs, 방향 비순환 그래프(DAG)
public class LineUp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //학생수
		int m = Integer.parseInt(st.nextToken()); //키를 비교한 횟수
		
		//진입차수 카운트에 사용할 배열
		int[] indegree = new int[n+1];
		//위상정렬에 사용할 2차원 배열
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i=0; i<m; i++) {
			String[] temp = br.readLine().split(" ");
			graph.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1]));
			indegree[Integer.parseInt(temp[1])]++;
		}
		
		//위상정렬에 쓸 큐
		Queue<Integer> q = new LinkedList<>();
		
		//진입차수가 0인 값 큐에 삽입
		for(int i=1; i<indegree.length; i++) {
			if(indegree[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int studentNo = q.poll();
			
			bw.write(String.valueOf(studentNo) + " ");
			
			List<Integer> list = graph.get(studentNo);
			
			for(int i=0; i<list.size(); i++) {
				int temp = list.get(i);
				//간선 삭제
				indegree[temp]--;
				if(indegree[temp] == 0) q.offer(temp);
			}
		}
		
		bw.flush();
	}

}
