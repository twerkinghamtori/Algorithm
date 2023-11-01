package complete;

//프로그래머스 [1차]다트 게임
//이거 이상의 로직이 안떠오른다..
public class DartGame {
	public int solution(String dartResult) {
        int answer = 0;
        int lastAlpha = 0;
        int lastnum = 0;
        for(int i=0; i<dartResult.length(); i++) {
            if(dartResult.charAt(i) == 'S') {     
                int num = Integer.parseInt(dartResult.substring(lastAlpha, i));
                if(i != dartResult.length()-1) {                    
                    if(dartResult.charAt(i+1) == '*') {
                        answer += lastnum;
                        answer += Math.pow(num,1) *2;
                        lastAlpha = i+2;
                        lastnum = (int)Math.pow(num,1) *2;
                    } else if(dartResult.charAt(i+1) == '#') {
                        answer += Math.pow(num,1) *-1;
                        lastAlpha = i+2;
                        lastnum = (int)Math.pow(num,1) *-1;
                    } else {
                        answer += Math.pow(num,1);
                        lastAlpha = i+1; 
                        lastnum = (int)Math.pow(num,1);
                    }                     
                } else {
                    answer += Math.pow(num,1);
                    lastAlpha = i+1; 
                }                               
            } else if(dartResult.charAt(i) == 'D') {
                int num = Integer.parseInt(dartResult.substring(lastAlpha, i));
                if(i!=dartResult.length()-1) {
                    if(dartResult.charAt(i+1) == '*') {
                        answer += lastnum;
                        answer += Math.pow(num,2) *2;
                        lastAlpha = i+2;
                        lastnum = (int)Math.pow(num,2) *2;
                    } else if(dartResult.charAt(i+1) == '#') {
                        answer += Math.pow(num,2) *-1;
                        lastAlpha = i+2;
                        lastnum = (int)Math.pow(num,2) *-1;
                    } else {
                        answer += Math.pow(num,2);
                        lastAlpha = i+1;
                        lastnum = (int)Math.pow(num,2);
                    } 
                } else {
                    answer += Math.pow(num,2);
                    lastAlpha = i+1; 
                }
            } else if(dartResult.charAt(i) == 'T') {
                int num = Integer.parseInt(dartResult.substring(lastAlpha, i));
                if(i!=dartResult.length()-1) {
                   if(dartResult.charAt(i+1) == '*') {
                        answer += lastnum;
                        answer += Math.pow(num,3) *2;
                        lastAlpha = i+2;
                        lastnum = (int)Math.pow(num,3)*2;
                    } else if(dartResult.charAt(i+1) == '#') {
                        answer += Math.pow(num,3) *-1;
                        lastAlpha = i+2;
                        lastnum = (int)Math.pow(num,3) *-1;
                    } else {
                        answer += Math.pow(num,3);
                        lastAlpha = i+1;
                        lastnum = (int)Math.pow(num,3);
                    } 
                } else {
                    answer += Math.pow(num,3);
                    lastAlpha = i+1; 
                }           
            }
        }
        return answer;
    }
}
