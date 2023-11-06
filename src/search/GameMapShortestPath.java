package search;
import java.util.*;

//프로그래머스 게임 맵 최단거리
//최단거리 -> bfs
public class GameMapShortestPath {
	
	boolean[][] visited; //방문배열
	//동서남북
    int[] X = {0,0,1,-1};
    int[] Y = {1,-1,0,0};
    
    public int solution(int[][] maps) {
    	//방문배열 초기화
        visited = new boolean[maps.length][maps[0].length];
        //큐 선언
        Queue<int[]> q = new LinkedList<>();
        //시작점 좌표와 카운트를 큐 삽입
        q.offer(new int[]{0,0,1});
        
        int mindist = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            //도착점에 도착하면 mindist(최소거리)계산
            if(x==maps.length-1 && y==maps[0].length-1) {
                mindist = Math.min(mindist, cnt);
                continue;
            }
            //동서남북 이동하여 큐 삽입
            for(int i=0; i<4; i++) {
                int newx = x+ X[i];
                int newy = y+ Y[i];
                //maps 범위 벗어난 경우 continue
                if(newx<0 || newy<0 || newx>=maps.length || newy>=maps[0].length) continue;
                
                if(maps[newx][newy]==1) {
                    if(visited[newx][newy]) continue;
                    visited[newx][newy] = true; //방문처리
                    q.offer(new int[]{newx,newy,cnt+1}); //새로운 좌표 큐 삽입
                }
            }
        }
        //mindist가 변화없이 초기 설정한 Integer.MAX_VALUE인 경우 도착점에 도달할 수 없으므로 -1 리턴 
        return mindist==Integer.MAX_VALUE?-1:mindist;
    }
}
