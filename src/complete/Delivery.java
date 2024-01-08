package complete;

import java.util.*;

//프로그래머스 배달 다익스트라 알고리즘
//다익스트라 알고리즘 : DP를 이용한 단일 시작점 최단 경로 알고리즘

public class Delivery {
	
	static int cnt;
    static int[][] arr;
    static int[] dist;
    static boolean[] visited;
    
	public static void main(String[] args) {
		int N = 6;
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int K = 4;
		
		System.out.println(solution(N, road, K));

	}

	public static int solution(int N, int[][] road, int K) { 
        int answer = 0;
        
        cnt = 0;
        arr = new int[N+1][N+1];
        
        //인접 행렬 최대값으로 초기화
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                arr[i][j] = 500001;
            }
        }
        
        //인접 행렬 거리값 삽입
        for(int i=0; i<road.length; i++) {
            if(arr[road[i][0]][road[i][1]] > road[i][2]) {
                arr[road[i][0]][road[i][1]] = road[i][2];
                arr[road[i][1]][road[i][0]] = road[i][2];
            }
        }
        
        //거리 배열
        dist = new int[N+1];
        
        for(int i=2; i<N+1; i++) {
            dist[i] = 500001;
        }
        
        //방문 배열
        visited = new boolean[N+1];
        //첫번째 마을 체크
        visited[1] = true;
        
        //다익스트라 메서드 호출
        dijkstra(N,K);

        answer = cnt;
        return answer;
    }
	
	static void dijkstra(int n, int k) {
		
        for(int i=1; i<n; i++) {
            int min = 500001;
            int idx = 1;
            
            //가장 작은 거리에 있는 인덱스 값 찾기
            for(int j=2; j<=n; j++) {
            	
                if(!visited[j] && min > dist[j]) {
                    idx = j;
                    min = dist[j];
                }
            }
            
            //방문 처리
            visited[idx] = true;
            
            //돌아가는 루트가 더 빠른지 탐색
            for(int j=2; j<=n; j++) {
                if(dist[j] > dist[idx] + arr[idx][j]) {
                    dist[j] = dist[idx] + arr[idx][j];
                }
            }
        }
        
        //k이하의 값 카운트
        for(int i=1; i<=n; i++) {
            if(dist[i] <= k) {
                cnt++;
            }
        }
    }
}
