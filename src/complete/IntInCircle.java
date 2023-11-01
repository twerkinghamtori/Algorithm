package complete;

//프로그래머스 두 원 사이의 정수 쌍
//(int) Math.ceil(Math.sqrt((long) r1 * r1 - (long) i * i));
//(int) Math.floor(Math.sqrt((long) r2 * r2 - (long) i * i));
//위 두 식의 차로 쉽게 구할 수 있음
public class IntInCircle {
	public long solution(int r1, int r2) {
        long answer = 0;
        long big = 0;
        for(int i=r2*-1; i<=r2; i++) {
            long y2 = (int)Math.sqrt(Math.pow(r2,2) - Math.pow(i,2));
            big+=(y2*2+1);
        }
        long small = 0;
        for(int i=r1*-1+1; i<r1; i++) {
            long y1 = (int)Math.sqrt(Math.pow(r1,2) - Math.pow(i,2));
            small+=(y1*2+1);
            if(Math.pow(i,2) + Math.pow(y1,2) == Math.pow(r1,2)) {
                small -= 2;
            }            
        }
        answer = big-small;
        return answer;
    }
}
