package search;

//프로그래머스 네트워크
//dfs
public class Network {
	
	boolean[][] visited;
    int cnt;
    
    public int solution(int n, int[][] computers) {
    	//방문배열
        visited = new boolean[computers.length][computers[0].length];
        
        //한 행에서 1인 경우가 한 번만 존재한다면 독립적인 네트워크 1개 -> 체크
        for(int i=0; i<computers.length; i++) {
            int cnt2 = 0;
            for(int j=0; j<computers[i].length; j++) {
                if(computers[i][j]==1) cnt2++;
            }
            if(cnt2==1) cnt++;
        }
        //i!=j이이면서 1인 경우 깊이 탐색
        for(int i=0; i<computers.length; i++) {
            for(int j=0; j<computers[i].length; j++) {
                if(i!=j && computers[i][j] == 1 && !visited[i][j]) {
                	//새로운 네트워크 탐색 시 카운트
                    cnt++;
                    dfs(i,j, computers);
                }
            }
        }
        return cnt;
    }
    
    void dfs(int i, int j, int[][]computers) {
        if(!visited[i][j]) {
            visited[i][j] = true;
            visited[j][i] = true;
            //행 <-> 열로 연결된 네트워크 탐색
            for(int a=0; a<computers[0].length; a++) {
                if(!visited[j][a] && computers[j][a] == 1) {
                   dfs(j,a,computers); 
                }
            }
        }
    }
}
