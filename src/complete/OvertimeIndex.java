package complete;

import java.util.*;

//프로그래머스 야근지수
//남은 일들의 편차를 최소화하는 순서 = 가장 많이 남은 일부터 처리 -> PriorityQueue, reverseOrder
public class OvertimeIndex {
	public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : works) {
            pq.add(i);
        }
        for(int i=0; i<n; i++) {
            int cur = pq.poll();
            if(cur==0) return 0;
            pq.add(cur-1);
        }
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(),2);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(10, new int[]{10,10,1}));
	}
}
