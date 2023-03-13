
/*
* stack
 */
import java.util.Stack;

public class Stack {
	public static void main(String[] args) {
		solution("(( )))");
	}

	public static void solution(String str) {
		Stack stack = new Stack();

		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='(') {
				stack.push(str.charAt(i));
			} else if(str.charAt(i)==')') {
				try {
					stack.pop();
				} catch (Exception e) {
					System.out.println("닫는 괄호가 더 많음");
					return;
				}		
			}
		}

		if(!stack.empty()) {
			System.out.println("괄호 안맞음");
		} else System.out.println("ㅇㅋ");		

	}
}