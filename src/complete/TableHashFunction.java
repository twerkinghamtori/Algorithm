package complete;
import java.util.*;

//프로그래머스 테이블 해시 함수
//정렬, 구현
//문제에서 "모든 S_i를 누적하여 bitwise XOR" 하라는 말을 이해하기 힘들었음
//answer 0 부터 개수 상관없이 계속 XOR 하면 된다.
public class TableHashFunction {
	public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        //col 컬럼(배열에서는 (col-1)번째) 순서대로 오름차순. 같다면 1번 컬럼(0열) 기준으로 내림차순
        Arrays.sort(data, (o1,o2) -> o1[col-1] != o2[col-1] ? o1[col-1] - o2[col-1] : o2[0] - o1[0]);
        
        //row_begin부터 row_end 컬럼까지
        for(int i=row_begin-1; i<=row_end-1; i++) {
            int S_i = 0;
            //i번째 행 튜플에 대해 각 컬럼의 값을 i로 나눈 합을 S_i라 함
            for(int j=0; j<data[i].length; j++) {
            	S_i += (data[i][j]%(i+1));
            }
            //S_i를 누적하여 XOR
            answer = answer^S_i;
        }
        return answer;
    }
}
