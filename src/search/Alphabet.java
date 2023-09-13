package search;

import java.util.*;
import java.io.*;

//백준 1987 알파벳 dfs, 백트래킹

//visited로 방문 체크하고, list에 방문한 알파벳 저장하고 list.contains 이용하여 체크 => 시간초과남 (중복 확인)
//visited랑 list.contains 합침
//백트래킹....
public class Alphabet {
	
	static int[][] board;
	static boolean[] visited = new boolean[26]; //방문한 알파벳 체크
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int answer = 0;
	static int h,w;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		board = new int[h][w];
		
		for(int i=0; i<h; i++) {
			String temp = br.readLine();
			for(int j=0; j<w; j++) {
				//visit 배열의 index로 사용하기 위해 알파벳을 숫자로 변환하여 저장
				board[i][j] = temp.charAt(j)-'A';
			}
		}
		
		dfs(0,0,0);
		
		System.out.println(answer);

	}

	private static void dfs(int y, int x, int cnt) {
		// 이미 방문한 알파벳을 만나면 최대 길이를 업데이트하고 탐색을 종료
		if(visited[board[y][x]]) {
			answer = Math.max(answer , cnt);
			return;
		} else {
			visited[board[y][x]] = true;
			// 상하좌우 이동 탐색
			for(int i=0; i<4; i++) {
				int cy = y + dy[i];
				int cx = x + dx[i];
				
				//보드 범위 내에서 이동 가능한 경우 재귀 호출
				if(cy >= 0 && cx >=0 && cy<h && cx<w) {
					dfs(cy, cx, cnt+1);
				}				
			}
			//탐색 종료 후 방문 여부 초기화 (백트래킹)
			visited[board[y][x]] = false;
		}
	}


}
