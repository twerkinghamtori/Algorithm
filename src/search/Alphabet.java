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
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static int answer = 1;
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

	private static void dfs(int x, int y, int cnt) {
		// 이미 방문한 알파벳을 만나거나, 최대 길이에 도달하면 종료
        if (visited[board[x][y]]) {
            answer = Math.max(answer, cnt); // cnt가 26일 때는 모든 알파벳을 다 사용한 경우이므로 25로 업데이트
            return;
        } else {
        	visited[board[x][y]] = true;
    		
    		// 상하좌우 이동 탐색
    		for(int i=0; i<4; i++) {				
    			int cx = x + dx[i];
    			int cy = y + dy[i];
    				
    			//보드 범위 내에서 이동 가능한 경우 재귀 호출
    			if(cx >= 0 && cy >=0 && cx<h && cy<w) {
    				dfs(cx, cy, cnt+1);
    			}				
    		}
    		//탐색 종료 후 방문 여부 초기화 (백트래킹)
    		visited[board[x][y]] = false;
        }
		
		
	}
}
