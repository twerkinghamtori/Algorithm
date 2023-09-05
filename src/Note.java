import java.util.*;
import java.io.*;

public class Note {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//우선순위 큐
		PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2) -> {						
			int a = Math.abs(o1);
			int b = Math.abs(o2);
			
			//절대값이 같은 경우 음수 우선
			if(a==b) {
				return o1 > o2? 1 : -1; //비교자(Comparator)에서 -1을 반환하면 작은 값이 먼저 정렬됨
			}
			//절대값 작은 데이터 우선
			return a-b;			
		});
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(q.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(q.poll());
				}
			} else {
				q.add(num);
			}
		}		
	}

}
