package search;
import java.util.*;

//프로그래머스 리코쳇 로봇
//최소 이동거리 보장 -> bfs로 해결
//D까지 미끄러지는 로직을 구현하기 어려웠음
public class Ricochet {
	int[] X = {0,0,1,-1};
    int[] Y = {1,-1,0,0};
    
    public int solution(String[] board) {
        //초기 세팅
        int answer = Integer.MAX_VALUE;
        
        int[] start = findPosition('R', board);
        
        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[start[0]][start[1]] = true;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start[0], start[1], 0));
        
        //bfs
        while(!q.isEmpty()) {
            Node cur = q.poll(); //현재(큐 맨 앞에 값)
            
            if(answer <= cur.cnt) {
                continue;
            }
            
            if(board[cur.x].charAt(cur.y) == 'G') {
                answer = Math.min(answer, cur.cnt);
                continue;
            }
            
            //미끄러지는 로직
            for(int i=0; i<4; i++) {
                //i=0 : 우, i=1 : 좌, i=2 : 상, i=3 : 하
                int x = cur.x + X[i];
                int y = cur.y + Y[i];
                
                if(x<0 || y<0 || x>= board.length || y>=board[0].length()) {
                    continue;
                }
                
                if(board[x].charAt(y) == 'D') {
                    continue;
                }
                
                //범위 내에 있고 D가 아닌 동안 반복해서 이동 -> D까지 한 방향으로 미끄러짐
                while(x>=0 && y>=0 && x< board.length && y<board[0].length() 
                     && board[x].charAt(y) != 'D') {
                    x += X[i];
                    y += Y[i];
                }
                
                //D앞에서 멈추기 때문에 1씩 빼줌
                x -= X[i];
                y -= Y[i];
                
                if(visited[x][y]) {
                    continue;
                }
                
                visited[x][y] = true; //방문처리
                
                //다음 깊이의 노드를 큐에 삽입
                q.offer(new Node(x, y, cur.cnt+1));
            }
        }
        
        return answer == Integer.MAX_VALUE? -1 : answer;
        
    }
    
    private int[] findPosition(char find, String[] board) {
        for(int i=0; i<board.length; i++) {
            String s = board[i];
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == find) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}

class Node {
    int x;
    int y;
    int cnt;
    
    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
