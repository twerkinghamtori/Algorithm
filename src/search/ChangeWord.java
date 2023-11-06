package search;
import java.util.*;

//프로그래머스 단어 변환
//최소 단계 -> bfs
public class ChangeWord {
	
	public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        
        boolean[] visited = new boolean[words.length];
        Queue<Node2> q = new LinkedList<>();
        q.offer(new Node2(begin, 0));
        
        //words 배열에 target이 없다면 도달할 수 없기 때문에 0을 리턴
        int cnt = 0;
        for(int i=0; i<words.length; i++) {
            if(target.equals(words[i])) {
                cnt++;
            }
        }
        if(cnt == 0) return 0;
        
        //bfs
        else {
            while(!q.isEmpty()) {
                Node2 node = q.poll();
                //시작 단어
                String str = node.str;
                //변환 횟수
                int count = node.cnt;
                //시작 단어가 목표 단어와 같아지는 경우
                if(str.equals(target)) {
                    answer = Math.min(answer, count);
                    break;
                } 
                //시작단어에서 한글자만 변환할 수 있으므로 시작단어와 words배열에 있는 글자가 한글자 차이가 나는 단어인지 확인
                for(int i=0; i<words.length; i++) {
                    int wordcnt=0;
                    for(int j=0; j<words[i].length(); j++) {
                        if(str.charAt(j)==words[i].charAt(j)) {
                            wordcnt++;
                        }
                    }
                    //한글자 차이 나는 단어라면
                    if(wordcnt==words[i].length()-1) {
                        if(visited[i]) continue;
                        //바뀐 단어를 시작단어로 하고 카운트를 증가시켜 큐에 삽입
                        q.offer(new Node2(words[i],count+1));
                        //방문처리
                        visited[i]=true;
                    }
                }
            }
        }
        
        return answer;
    }
}

//큐에 다양한 자료형을 담을 Object 생성을 위한 클래스 정의
class Node2 {
    String str;
    int cnt;
    Node2(String str, int cnt) {
        this.str = str;
        this.cnt = cnt;
    }
}
