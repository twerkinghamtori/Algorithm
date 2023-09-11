package greedy;

import java.util.*;
import java.io.*;

//백준 1715 카드 정렬하기
//"중간 계산 결과까지 포함해서" 가장 작은 수 2개를 뽑아서 더해야함
//우선순위 큐 이용
public class SortingCards {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Long> q = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			q.add(Long.parseLong(br.readLine()));
		}
		long sum = 0;
		while(q.size()>1) {
			long temp = q.poll() + q.poll();
			sum += temp;
			q.add(temp);
		}
		System.out.println(sum);
	}

}

