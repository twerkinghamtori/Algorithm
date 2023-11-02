package complete;
import java.util.*;

//프로그래머스 뒤에 있는 큰 수 찾기
//완전탐색 -> 시간초과
//"가장 가까이 있는" -> stack 활용 힌트
public class BackBigNum {
	public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        
        int[] answer = new int[numbers.length];
        
        //맨 앞 숫자의 index 삽입
        stack.push(0);
        
        for(int i=1; i<numbers.length; i++) {
        	//현재 stack값보다 number의 값이 크면 뒤에 있는 큰수
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            
            //현재 index 삽입
            stack.push(i);
        }
        
        //모든 index 탐색 후 큰 수가 없는 경우 -1
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}
