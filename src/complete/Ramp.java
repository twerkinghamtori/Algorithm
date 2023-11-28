package complete;

import java.util.*;
import java.io.*;

//삼성 SW 역량 테스트 기출 문제
//백준 14890 경사로 구현
public class Ramp {
	
	static int n,l;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		int answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			if(row(i)) answer++;
			if(col(i)) answer++;	
		}
		
		System.out.println(answer);
	}
	
	private static boolean row(int row) {
		
		boolean[] isIncline = new boolean[n]; //경사면 설치 여부를 확인하는 배열
		
		for(int i=0; i<n-1; i++) {
			//경사 차이가 1 이상인 경우 false 반환
			if(Math.abs(map[row][i] - map[row][i+1]) > 1) return false;
			//다음이 더 높은 경우
			if(map[row][i] - map[row][i+1] == -1) {
				//왼쪽에 올라가는 경사를 설치할 수 있는지 확인
				for(int j=0; j<l; j++) {
					//범위를 벗어나거나 이미 설치되어 있다면 false 반환
					if(i-j <0 || isIncline[i-j]) return false;
					//계단 높이가 달라지는 경우 false 반환
					if(map[row][i] != map[row][i-j]) return false;
					isIncline[i - j] = true; //경사면 설치
				}
			}
			//다음이 더 낮은 경우
			else if(map[row][i] - map[row][i+1] == 1) {
				//오른쪽에 내려가는 경사를 설치할 수 있는지 확인
				for(int j=1; j<=l; j++) {
					//범위를 벗어나거나 이미 설치되어 있다면 false 반환
					if(i + j >= n || isIncline[i + j]) return false;
					//계단 높이가 달라지는 경우 false 반환
                    if(map[row][i] - 1 != map[row][i + j]) return false;
                    isIncline[i + j] = true; //경사면 설치
				}
			}
		}
		return true;
	}

	private static boolean col(int col) {
		boolean[] isIncline = new boolean[n]; 
		
		for(int i=0; i<n-1; i++) {
			if(Math.abs(map[i][col] - map[i+1][col]) > 1) return false;
			//다음이 더 높은 경우
			if(map[i][col] - map[i+1][col] == -1) {
				for(int j=0; j<l; j++) {
					if(i-j <0 || isIncline[i-j]) return false;
					if(map[i][col] != map[i-j][col]) return false;
					isIncline[i - j] = true; 
				}
			}
			//다음이 더 낮은 경우
			else if(map[i][col] - map[i+1][col] == 1) {
				for(int j = 1; j <= l; j++) { 
                    if(i + j >= n || isIncline[i + j]) return false;
                    if(map[i][col] - 1 != map[i + j][col]) return false;
                    isIncline[i + j] = true; 
                }
			}
		}
		return true;
	}

}
