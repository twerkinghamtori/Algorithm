package complete;

import java.util.*;
import java.io.*;

//삼성 SW 역량 테스트 기출 문제
//백준 14891 톱니바퀴 구현
public class Gear {

	public static void main(String[] args) throws IOException {
		int answer = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] gears = new String[5];
		for(int i=1; i<=4; i++) {
			st = new StringTokenizer(br.readLine());
			gears[i] = st.nextToken();
		}
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); //움직일 톱니 번호
			int direction = Integer.parseInt(st.nextToken()); //움직일 방향
			int[] dirs = new int[5]; //각 톱니들의 이동 방향을 저장할 배열
			dirs[num] = direction;
			
			//지정된 톱니 오른쪽
			for(int j=num; j<dirs.length-1; j++) {
				if(gears[j].charAt(2) != gears[j+1].charAt(6)) {
					dirs[j+1] = dirs[j]*-1;
				} else {
					dirs[j+1] = 0;
				}
			}
			//지정된 톱니 왼쪽
			for(int t=num; t>=2; t--) {
				if(gears[t].charAt(6) != gears[t-1].charAt(2)) {
					dirs[t-1] = dirs[t]*-1;
				} else {
					dirs[t-1] = 0;
				}
			}
			
			//각 움직일 방향에 대해서 회전
			for(int z=1; z<dirs.length; z++) {				
				if(dirs[z] == -1) {
					String newG = gears[z].substring(0,1);
					gears[z] = gears[z].substring(1,8) + newG;
				} else if(dirs[z] == 1) {
					String newG = gears[z].substring(7,8);
					gears[z] = newG + gears[z].substring(0,7);
				} else if(dirs[z] == 0) continue;
			}
			
		}
		
		for(int i=1; i<gears.length; i++) {
			if(gears[i].charAt(0) == '1') answer+=Math.pow(2, i-1);
		}
		System.out.println(answer);
	}

}
