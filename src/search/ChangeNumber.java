package search;
import java.util.*;

//프로그래머스 숫자 변환하기
//최소 연산 횟수 보장 -> bfs -> 시간초과 -> visited 방문 hashset으로 해결

public class ChangeNumber {
	//bfs
	public int solution(int x, int y, int n) {
        int answer = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(new int[] {x,0});
        visited.add(x);
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int value = cur[0];
            int cnt = cur[1];
            if(value == y) {
                answer = cnt;
                break;
            } 
            if(value+n<=y && !visited.contains(value + n)) {
                q.offer(new int[]{value+n, cnt+1});   
                visited.add(value+n);
            }
            if(value*2<=y && !visited.contains(value * 2)) {
                q.offer(new int[]{value*2, cnt+1});   
                visited.add(value * 2);
            }
            if(value*3<=y && !visited.contains(value * 3)) {
                q.offer(new int[]{value*3, cnt+1});
                visited.add(value * 3);
            }            
        }
        return answer == Integer.MAX_VALUE?-1:answer;
    }
	
	int[] dp;
	//dp
	public int solution2(int x, int y, int n) {
        dp = new int[y+1];
        
        for(int i=0; i<=y; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[x] = 0;
        for(int i=x; i<=y; i++) {
            if(dp[i]==Integer.MAX_VALUE) continue;
            if(i+n<=y) {
                dp[i+n] = Math.min(dp[i+n], dp[i]+1);
            }
            if(i*2<=y) {
                dp[i*2] = Math.min(dp[i*2], dp[i]+1);
            }
            if(i*3<=y) {
                dp[i*3] = Math.min(dp[i*3], dp[i]+1);
            }
        }
        
        return dp[y] == Integer.MAX_VALUE?-1:dp[y];
    }
}
