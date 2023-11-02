package search;
import java.util.*;

//프로그래머스 미로탈출
//레버까지 가는 최소거리 + 출구까지 가는 최소거리
//최소 이동거리를 보장해야하기 때문에 bfs를 이용해서 해결
public class MazeExit {
	
	int[] X = {0,0,1,-1};
    int[] Y = {1,-1,0,0};
    
    public int solution(String[] maps) {
    	
        int answer = Integer.MAX_VALUE;
        
        //시작점, 레버위치, 출구위치 세팅
        int sx = 0;
        int sy = 0;
        int lx = 0;
        int ly = 0;
        int ex = 0;
        int ey = 0;
        
        for(int i=0; i<maps.length; i++) {
            String s = maps[i];
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                }
                if(s.charAt(j) == 'L') {
                    lx = i;
                    ly = j;
                }
                if(s.charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        
        //레버까지 최소거리
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy, 0});
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        int ldist = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if(x==lx && y==ly) {
                ldist = Math.min(ldist, cnt);
                //lx의 위치를 다시 출발위치로 설정
                sx = x;
                sy = y;
                continue;
            }
            
            for(int i=0; i<4; i++) {
                int newx = x+X[i];
                int newy = y+Y[i];
                
                if(newx<0 || newy<0 || newx>=maps.length || newy>=maps[0].length()) {
                    continue;
                }
                
                if(maps[newx].charAt(newy) != 'X') {
                    if(visited[newx][newy]) continue;
                    visited[newx][newy] = true;
                    q.offer(new int[]{newx, newy, cnt+1});
                }                
            }
        }
        
        //레버까지 거리에 변화가 없다면 출구까지 갈 필요 없이 리턴
        if(ldist == Integer.MAX_VALUE) {
        	return -1;
        } 

        //큐 비우기
        q.clear();
        
        //레버까지 왔던 길을 되돌아가서 최소거리가 나올 수 있으므로 방문배열도 초기화
        visited = new boolean[maps.length][maps[0].length()];
        
        //새로운 출발위치(레버 위치)를 큐에 삽입
        q.offer(new int[] {sx, sy, 0});
        
        //출구까지 최소 거리(레버와 동일한 과정 반복)
        int edist = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if(x==ex && y==ey) {
                edist = Math.min(edist, cnt);
                continue;
            }
            
            for(int i=0; i<4; i++) {
                int newx = x+X[i];
                int newy = y+Y[i];
                
                if(newx<0 || newy<0 || newx>=maps.length || newy>=maps[0].length()) {
                    continue;
                }
                
                if(maps[newx].charAt(newy) != 'X') {
                    if(visited[newx][newy]) continue;
                    visited[newx][newy] = true;
                    q.offer(new int[]{newx, newy, cnt+1});
                }                
            }
        }
        
        if(edist == Integer.MAX_VALUE) {
        	return -1;
        } else return ldist + edist;
    }
}
