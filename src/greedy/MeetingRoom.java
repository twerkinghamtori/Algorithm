package greedy;

import java.util.*;
import java.io.*;

//시작시간 빠른 기준으로 정렬해서 2중 for문 => 계속 시간초과남ㅠㅠ
//종료시간이 빠른 기준으로 정렬 => 다음 시작 시간이 종료시간보다 크거나 같은 경우로 반복
//정렬 시 종료시간이 같은 경우, 시작시간이 더 빠른 순서로 정렬
public class MeetingRoom {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] time = new int[n][2];
		for(int i=0; i<time.length; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//정렬
		Arrays.sort(time, (o1,o2)-> {
			if (o1[1] == o2[1]) { //종료시간이 같은 경우
		        return o1[0] - o2[0]; //시작시간이 빠른 순서대로
		    } else {
		        return o1[1] - o2[1];
		    }
		});
		
		int cnt = 1;
		int end = time[0][1];
		for(int i=1; i<n; i++) {	
			if(time[i][0] == time[i][1]) { //시작시간과 종료시간이 같은 경우
				cnt++;
				continue;
			} 
			if(time[i][0] >= end) {
				cnt++;
				end = time[i][1];
			}
		}
		System.out.println(cnt);
	}

}
