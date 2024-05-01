import java.io.*;
import java.util.*;

public class Note1 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] location = new int[n];
		
		for(int i=0; i<n; i++) {
			location[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(location);
		
		int answer = 0;
		int left = 1; //최소 인접 거리
		int right = location[n-1]-location[0]; //최대 인접 거리
		
		while(left <= right) {
			int mid = (left+right)/2;
			if(getPossibleCnt(location, mid) >= c) {
				answer = Math.max(answer, mid);
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		
		System.out.println(answer);
		br.close();
		
	} 
	
	private static int getPossibleCnt(int[] location, int mid) {
		int cnt = 1;
		int before = location[0];
		for(int i=0; i<location.length; i++) {
			if(location[i]-before >= mid) {
				before = location[i];
				cnt++;
			}
		}
		return cnt;
	}
}
