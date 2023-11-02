package complete;

//프로그래머스 연속된 부분 수열의 합
//완전 탐색 -> 시간초과 -> 투포인터로 해결
public class ContinuousSequenceSum {
	public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0, sequence.length-1};
        int start = 0;
        int end = 1;
        
        int sum = sequence[0];
        
        while(start < end) {
            if(sum == k) {
                if(end -1 - start < answer[1] - answer[0]) {
                    answer[0] = start;
                    answer[1] = end -1;
                }
                sum -= sequence[start++];
            } else if(sum > k) {
                sum -= sequence[start++];
            } else if(end < sequence.length) {
                sum += sequence[end++];
            } else break;
        }
        return answer;
    }
}
