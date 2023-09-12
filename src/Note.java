import java.util.*;
import java.io.*;

public class Note {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;		
		
		List<Integer> list = new ArrayList<>();
		while(true) {					
			st = new StringTokenizer(br.readLine());;		
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(l==0 && p==0 && v==0) break;
			else {
				int answer = 0;
				if(v%p > l) {
					answer = v/p*l + l;
				} else {
					answer = v/p*l + v%p;
				}				
				list.add(answer);				
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("Case " + (i+1) + ": " + list.get(i));
		}
	}
}
