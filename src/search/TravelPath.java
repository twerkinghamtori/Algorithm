package search;
import java.util.*;

//프로그래머스 여행경로
//dfs
//list에 담는 방법이 어려웠음 -> 공백으로 구분하여 저장 -> 모든 경로 저장과 정렬이 쉬워짐
public class TravelPath {
	
	List<String> list= new ArrayList<>();
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        int cnt = 0;
        dfs("ICN", "ICN", tickets, cnt);
        
        /*
        ICN SFO ATL ICN ATL SFO
		ICN ATL ICN SFO ATL SFO
		ICN ATL SFO ATL ICN SFO
         */
        //출발지가 같은 항공권이 여러개라면 알파벳 순서가 앞서는 경로를 채택
        Collections.sort(list);
        /*
        ICN ATL ICN SFO ATL SFO
		ICN ATL SFO ATL ICN SFO
		ICN SFO ATL ICN ATL SFO
         */

        answer = list.get(0).split(" ");         
        return answer;
    }
    
    void dfs(String start, String route, String[][] tickets, int cnt) {  
    	//주어진 항공권을 모두 이용한 경로 list에 저장
        if(cnt==tickets.length) {
            list.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(start.equals(tickets[i][0]) && !visited[i]) {
                visited[i]=true;
                //route에 " " 로 모든 경로를 이어서 저장
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1);
                //다시 false로 만들어서 출발지가 같은 다른 경로 탐색 
                visited[i] = false;
            }
        }
    }
}
