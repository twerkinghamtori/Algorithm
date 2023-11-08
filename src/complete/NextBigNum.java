package complete;

//프로그래머스 다음 큰 숫자
//비트 연산 공부
public class NextBigNum {
	public int solution(int n) {
        int cnt = countSetBits(n);
        while (true) {
            n++;
            if (countSetBits(n) == cnt) {
                return n;
            }
        }
    }

    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
        	//맨 오른쪽 비트가 1이라면 1이고 아니면 0
            count += num & 1;
            //num 반으로 쪼개기, 오른쪽으로 1비트 시프트
            num >>= 1;
        }
        return count;
    }
}
