import java.util.*;

public class Note {
	
	static int[] X = {0,0,1,-1};
	static int[] Y = {1,-1,0,0,};
	
	public static int solution(String[] board) {
		int answer = Integer.MAX_VALUE;
		
		int sx = 0;
		int sy = 0;
		int ex = 0;
		int ey = 0;
		
		for(int i=0; i<board.length; i++) {
			String s = board[i];
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j) == 'R') {
					sx = i;
					sy = j;
				}
				if(s.charAt(j) == 'G') {
					ex = i;
					ey = j;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sx, sy, 0});
		
		boolean[][] visited = new boolean[board.length][board[0].length()];
		visited[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int cnt = cur[2];
			
			if(x==ex && y == ey) {
				answer = Math.min(answer, cnt);
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int newx = x+X[i];
				int newy = y+Y[i];
				
				if(newx<0 || newy<0 || newx>= board.length || newy>= board[0].length()) {
					continue;
				}
				
				while(newx>=0 && newy>=0 && newx<board.length && newy<board[0].length() && board[newx].charAt(newy) != 'D') {
					newx+= X[i];
					newy+= Y[i];
				}
				
				newx-= X[i];
				newy-= Y[i];
				
				if(visited[newx][newy]) continue;
				
				visited[newx][newy] = true;
				
				q.offer(new int[] {newx,newy,cnt+1});
			}
		}
		
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
	}
}
