package complete;

import java.util.*;
import java.io.*;

//백준 2304 창고 다각형
//가장 높은 높이를 구하고, 그 기준으로 왼쪽, 오른쪽을 탐색하면서 현재보다 높은 기둥을 만날 때 마다 직사각형 넓이를 구해 더해줌
public class WarehouseShape {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); //기둥 개수
		
		int[][] board = new int[n][2]; //위치, 높이를 입력받을 배열
		
		int max = 0;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
			
			max = Math.max(board[i][1], max); //가장 높은 기둥의 높이
		}
		
		//좌표(위치) 순서대로 정렬
		Arrays.sort(board, (o1,o2) -> o1[0] - o2[0]);
		
		int start = 0;
		for(int i=0; i<n; i++) {
			if(board[i][1] == max) {
				start = i;
			}
		}
		
		//가장 높은 기둥은 직사각형 1개로 치고, 높이 처음에 더해줌
		int answer = max; 
		
		int curL = board[0][0]; //초기 위치
		int curH = board[0][1]; //초기 높이
		
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

