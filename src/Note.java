import java.util.*;
import java.io.*;

public class Note {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[] answer = new int[t];	
		for(int i=0; i<t; i++) {
			int a = Integer.parseInt(br.readLine());
			int[][] arr = new int[a][2];
			for(int j=0; j<a; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, (o1,o2) -> o1[0] - o2[0]); //서류 기준 정렬
			int cnt = 1;
			int min = arr[0][1];
			for(int j=1; j<arr.length; j++) {				
				if(min > arr[j][1]) {
					cnt++;
					min = arr[j][1];
				} 
			}	
			answer[i] = cnt;
		}
		
		for(int i : answer) {
			System.out.println(i);
		}
	}

}
