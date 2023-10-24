package complete;
import java.util.*;

//프로그래머스 햄버거 만들기
//ingredients의 길이 <= 1,000,000 -> 시간초과 -> stack으로 해결
public class Hamburger {
	public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i : ingredient) {
            stack.push(i);
            if(stack.size() >= 4) {
                int size = stack.size();
                if(stack.get(size-1) == 1 && stack.get(size-2) == 3 && stack.get(size-3) == 2 && stack.get(size-4) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;
    }
}
