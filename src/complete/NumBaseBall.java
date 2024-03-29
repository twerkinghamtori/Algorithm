package complete;
import java.util.Stack;

/* 완료
숫자 야구
문제 설명
숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기
각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.
* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃
예를 들어, 아래의 경우가 있으면
A : 123
B : 1스트라이크 1볼.
A : 356
B : 1스트라이크 0볼.
A : 327
B : 2스트라이크 0볼.
A : 489
B : 0스트라이크 1볼.
이때 가능한 답은 324와 328 두 가지입니다.
질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 
주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.
제한사항
질문의 수는 1 이상 100 이하의 자연수입니다.
baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.
입출력 예
baseball	return
[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2
[결과]
324,328,=>2
 */
public class NumBaseBall {
	static int solution(int[][] nums) {
		int answer=0;
		Stack<String> all = new Stack<String>();
		
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				for(int k=1; k<10; k++) {
					if(i!=k && i!=j && j!=k) {
						all.push(Integer.toString(i) + Integer.toString(j) + Integer.toString(k));
					}
				}
			}
		}
		
		while(all.size()>0) {
			int chk=0;
			for(int i=0; i<nums.length; i++) {
				if(strike(all.peek() , Integer.toString(nums[i][0]))== nums[i][1]
    					&&ball(all.peek() , Integer.toString(nums[i][0])) == nums[i][2] ) {
    				chk += 1;
    			}
			}
			if(chk == nums.length) { //stack에서 만든 random숫자가 nums배열의 strike, ball 조건 모두 만족했을 때
				answer+=1;
//				System.out.println(all.peek()); //조건 만족하는 수 확인용
			}			
			all.pop();
		}
		return answer;
	}
	
	public static int strike(String stack, String ori) { //strike 개수 리턴
		int ans=0;
		String[] stk2 = stack.split("");
		String[] ori2 = ori.split("");
		
		for(int i=0; i<stk2.length; i++) {
			if(stk2[i].equals(ori2[i])) {
				ans+=1;
			}
		}
		return ans;
	}
	
	public static int ball(String stack, String ori) { //ball 개수 리턴
		int ans=0;
		
		String[] stk2 = stack.split("");
		String[] ori2 = ori.split("");
		
		for(int i=0; i<stk2.length; i++) {
			for(int j=0; j<ori2.length; j++) {
				if(i != j && stk2[i].equals(ori2[j])) {
					ans+=1;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println ("=>" + solution(new int[][] { 
	          { 123, 1, 1 }, 
	          { 356, 1, 0 }, 
	          { 327, 2, 0 }, 
	          { 489, 0, 1 } }));
	}
	

}