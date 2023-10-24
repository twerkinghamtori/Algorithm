package complete;

//프로그래머스 옹알이(2)
//연속해서 발음하는 경우 제외
//"yayae"와 같은 반례 찾기가 어려웠음 -> " "로 대체 이후 " "를 다시 ""로 대체하는 방식으로 해결
public class Babbling2 {
	public int solution(String[] babbling) {
        int answer = 0;
        
        for(String s : babbling) {
            if( s.contains("ayaaya") || s.contains("yeye") || s.contains("woowoo") || s.contains("mama")) continue;
            else {
                s = s.replace("aya", " ");
                s = s.replace("ye", " ");
                s = s.replace("woo", " ");
                s = s.replace("ma", " ");
                s = s.replace(" ", "");
            }    
            if(s.length() == 0) answer++;
        }
        
        return answer;
    }
}
