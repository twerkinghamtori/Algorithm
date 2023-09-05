package complete;

import java.util.*;
import java.io.*;

//백준 11286 절댓값 힙
//우선순위 큐 : 우선순위가 가장 높은 값이 먼저 나옴
//데이터가 삽입될 때마다 정렬이 필요하므로 우선순위 큐를 이용
public class AbsHeap {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//우선순위 큐
		PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2) -> {						
			int a = Math.abs(o1);
			int b = Math.abs(o2);
			
			//절댓값이 같은 경우 음수 우선
			if(a==b) {
				return o1 > o2? 1 : -1; //비교자(Comparator)에서 -1(음수)을 반환하면 작은 값이 먼저 정렬됨
			}
			//절댓값 작은 데이터 우선
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
