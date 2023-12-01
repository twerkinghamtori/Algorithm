package complete;

import java.io.*;
import java.util.*;

public class TeenShark {
	static int[][] fish;
	static int[][] dirs;
	static int[] X = {0,-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] Y = {0,0, -1, -1, -1, 0, 1, 1, 1};
	static int x = 0;
	static int y = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		fish = new int[4][4];
		dirs = new int[4][4];
		
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				fish[i][j] = Integer.parseInt(st.nextToken());
				dirs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println("input 끝");
		
		int cur = 1;
		move(cur);
		
		

		
//		for(int i=0; i<4; i++) {
//			for(int j=0; j<4; j++) {
//				System.out.print(fish[i][j] + "\t");
//			}
//			System.out.println();
//		}
		
		
	}
	
	private static void find(int cur) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(fish[i][j] == cur) {
					x = i;
					y = j;
				}
			}
		} 
	}
	
	private static void move(int cur) {
		while(cur <= 16) {
			find(cur);
			if(cur == fish[0][0]) {
				cur++;
				continue;
			}
			int dir = dirs[x][y];
			for(int i=dir; i<dir+8; i++) {
				
				int n = i%9==0?1:i%9;
				int newx = x + X[n];
				int newy = y + Y[n];
				if(newx < 0 || newy <0 || newx>=4 || newy>=4) continue;
				else if(newx == 0 && newy == 0) continue;
				else {
					//System.out.println(cur + " : " + newx + " " + newy + " dir :  " + n);
					dirs[x][y] = n;
					int temp = fish[x][y];
					fish[x][y] = fish[newx][newy];
					fish[newx][newy] = temp;
					temp = dirs[x][y];
					dirs[x][y] = dirs[newx][newy];
					dirs[newx][newy] = temp;
					break;
				}				
			}
			
			cur++;
		}
	}
	
}
