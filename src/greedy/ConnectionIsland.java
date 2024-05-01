package greedy;

import java.util.*;

//프로그래머스 섬 연결하기 그리디
//Krustal 알고리즘, Union-Find 알고리즘
public class ConnectionIsland {
	
	private static int[] parent;
	
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		System.out.println(solution(n,costs));
	}
	
	private static int solution(int n, int[][] costs) {
		int answer = 0;
		
		//자기 자신을 부모로, 독립된 노드로 초기 설정
		parent = new  int[n];
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
		
		Arrays.sort(costs, (o1,o2) -> o1[2] - o2[2]);
		
		//Krustal Algorithm
		//모든 간선의 가중치를 오름차순으로 정렬 -> 순서대로 모든 정점이 연결될 때까지 실행	
		for(int i=0; i<costs.length; i++) {
			//부모가 다른 경우
			if(find(costs[i][0]) != find(costs[i][1])) {
				//다리 연결
				union(costs[i][0], costs[i][1]);
				answer += costs[i][2];
			}
		}
		return answer;
	}
	
	//Union-Find 알고리즘
	//두개의 노드를 선택해서 같은 그래프에 속하는 지 판별하는 알고리즘
	//부모 찾기
	private static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]); //재귀를 통해서 부모 노드를 찾음
	}
	
	//부모 합침
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a; //집합을 합침
		}
	}
}
