package greedy;

import java.util.*;
import java.io.*;

//백준 1946 신입사원
//시간 복잡도 유의
public class NewEmployee {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //테스트케이스 개순
		
		StringTokenizer st;
		
		int[] answer = new int[t];	
		
		for(int i=0; i<t; i++) {
			int a = Integer.parseInt(br.readLine()); //지원자의 수
			//배열에 저장
			int[][] arr = new int[a][2];
			for(int j=0; j<a; j++) { 
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			//서류 기준 정렬
			Arrays.sort(arr, (o1,o2) -> o1[0] - o2[0]);
			
			int cnt = 1; //서류 순위 가장 높은 사람은 무조건 채용
			int min = arr[0][1]; //면접 기준 가장 높은 순위 저장
			
			for(int j=1; j<arr.length; j++) {				
				if(min > arr[j][1]) { //j번째 배열의 면접 순위가 최고 면접 순위보다 높다면
					cnt++; //채용
					min = arr[j][1]; //가장 높은 면접 순위 재정의
				} 
			}	
			answer[i] = cnt;
		}
		
		for(int i : answer) {
			System.out.println(i);
		}
	}

}
