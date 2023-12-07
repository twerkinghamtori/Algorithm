
import java.util.*;
import java.io.*;

public class Note {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //굴다리 길이
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); //가로등 개수
		st = new StringTokenizer(br.readLine());
		int[] dir = new int[m];
		for(int i=0; i<m; i++) {
			dir[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		int[] road = new int[n+1];
		for(int i=0; i<=n; i++) {
			road[i] = i;
		}
		List<Integer> interval = new ArrayList<>();
		interval.add(dir[0]-0);
		for(int i=0; i<dir.length-1; i++) {
			if(!interval.contains(dir[i+1]-dir[i])) {
				interval.add(dir[i+1]-dir[i]);
			}			
		}
		interval.add(n-dir[m-1]);
		Collections.sort(interval);

		for(int i=0; i<=n; i++) {
			boolean b = true;
			if(dir[0]-i>0) {
				b = false;
			} 
			else if(dir[m-1] + i <n) {
				b = false;
			}
			if(b) {
				for(int j=0; j<dir.length-1; j++) {
					if(dir[j] + i < dir[j+1] - i) {
						b = false;
						break;
					}
				}
			}			
			if(b) {
				System.out.println(i);
				break;
			} 
		}
	}
}
