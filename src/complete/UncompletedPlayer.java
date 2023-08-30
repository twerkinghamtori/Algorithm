package complete;
/*
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 */
import java.util.*;

//getOrDefault 메서드

public class UncompletedPlayer {
	
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        //<선수이름, 선수 수>
        HashMap<String, Integer> hm = new HashMap<>();
        //참가자
        for(String s : participant) {
        	//getOrDefault(key, default value) : key값 있으면 value, 없으면 default 값
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        //완주자
        for(String c : completion) {
        	//완주자 있을 경우 value 에서 1 빼줌
            hm.put(c, hm.get(c)-1);            
        }
        //완주하지 못한 사람은 1명 -> value가 1이면 answer
        for(String hmk : hm.keySet()) {
            if(hm.get(hmk) >=1) answer = hmk;
        }
        return answer;
    }
	
}
