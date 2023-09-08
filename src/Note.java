import java.util.*;
import java.io.*;

public class Note {

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
		
		Arrays.sort(time, (o1,o2)-> {
			if (o1[1] == o2[1]) {
		        return o1[0] - o2[0];
		    } else {
		        return o1[1] - o2[1];
		    }
		});
		
		int cnt = 1;
		int end = time[0][1];
		for(int i=1; i<n; i++) {	
			if(time[i][0] == time[i][1]) {
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
