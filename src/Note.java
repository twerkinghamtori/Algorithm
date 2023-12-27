
import java.util.*;
import java.io.*;

public class Note {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][2];
		
		int max = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
			
			max = Math.max(board[i][1], max);
		}
		
		Arrays.sort(board, (o1,o2) -> o1[0] - o2[0]);
		
		//가장 큰 기둥 중 가장 왼쪽에 있는 기둥
		int start = 0;
		for(int i=0; i<n; i++) {
			if(board[i][1] == max) {
				start = i;
			}
		}
		
		//가장 높은 기둥은 직사각형 1개로 치고, 높이 처음에 더해줌
		int answer = max; 
		
		int curL = board[0][0];
		int curH = board[0][1];
		
		//처음부터 가장 큰 기둥까지 탐색 (왼쪽)
		for(int i=0; i<=start; i++) {
			//이전 기둥보다 큰 기둥이 나타나면 사각형 넓이 구하기
			if(board[i][1] >= curH) {
				answer += (board[i][0]-curL)*curH;
				//현재 기둥 갱신
				curL = board[i][0];
				curH = board[i][1];
			}
		}
		
		curL = board[n-1][0];
		curH = board[n-1][1];
		
		//오른쪽부터 가장 큰 기둥까지 역으로 탐색 (오른쪽)
		for(int i=n-1; i>=start; i--) {
			if(board[i][1] >= curH) {
				answer += (curL - board[i][0])*curH;
				curL = board[i][0];
				curH = board[i][1];
			}
		}
		
		System.out.println(answer);
	}
}

