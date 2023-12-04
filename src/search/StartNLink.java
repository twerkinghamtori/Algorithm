package search;

import java.util.*;
import java.io.*;
//삼성 SW 역량 테스트 기출 문제
//백준 14889 스타트와 링크 dfs, 백트래킹
public class StartNLink {
	static int n;
	static int[][] s;
	static List<Integer> start = new ArrayList<>();
	static int answer;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		answer = Integer.MAX_VALUE;
		
		visited = new boolean[n];
		dfs(0,0);
		
		System.out.println(answer);
	}
	
	private static void dfs(int idx, int cnt) {
		if(cnt ==  n/2) {
			calculateDiff();
			return;
		} 
		for(int i=idx; i<n; i++) {
			visited[i] = true;
			dfs(i+1, cnt+1);
			visited[i] = false;
		}
	}
	
	private static void calculateDiff() {
		List<Integer> start = new ArrayList<>();
		List<Integer> link = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			if(visited[i]) start.add(i);
			else link.add(i);
		}
		
		int startSum = calculateSum(start);
		int linkSum = calculateSum(link);
		
		answer = Math.min(answer, Math.abs(startSum - linkSum));
	}
	
	private static int calculateSum(List<Integer> team) {
		int sum = 0;
		for(int i : team) {
			for(int j : team) {
				sum += s[i][j];
			}
		}
		return sum;
	}
}
