package complete;

//프로그래머스 숫자 짝꿍
//contains()로 풀었다가 시간초과남 -> 카운팅으로 해결
//X와 Y가 3000000자리수라 런타임 에러남 -> 마지막에 0 변환하는 걸 Long.parseLong() 에서 charAt(0) 확인 하는 걸로 해결
public class NumberPartner {
	public String solution(String X, String Y) {
        String answer = "";
        long[] x = new long[10];
        long[] y = new long[10];
        
        for(char c : X.toCharArray()) {
            x[c - '0']++;
        }
        for(char c : Y.toCharArray()) {
            y[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            long min = Math.min(x[i], y[i]);
            for(long j=0; j<min; j++) {
                sb.append(i);
            }
        }
        
        answer = sb.toString();
        
        if(answer.equals("")) answer = "-1";
        else if(answer.charAt(0)=='0') answer = "0";
                
        return answer;
    }
}
