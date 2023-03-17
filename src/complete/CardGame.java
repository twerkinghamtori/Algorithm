package complete;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다. 
그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 
1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 
4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.
N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
조건 : 제한시간 1초대
<입력예시>
6
<출력예시>
4
 */
public class CardGame {
	private static int solution(int N) {
		long s = System.currentTimeMillis();
		List<Integer> cards = new LinkedList<>(); 
		/*
		 * ArrayList는 0번째를 지우면 나머지를 앞으로 다 당겨줘서 시간이 오래걸림
		 * LinkedList는 번지들이 따로따로 연결된 형태. 0번지를 지우면 그냥 없어지고, 붙이면 삭제되면서 마지막 번지에 연결됨.
		 */
		for(int i=1; i<=N; i++) {
			cards.add(i);
		}
		while(true) {
			cards.remove(0);
			cards.add(cards.get(0));
			cards.remove(0);
//			cards.add(cards.remove(0));
			if(cards.size()==1) break;
		}
		int answer = cards.get(0);

		long e = System.currentTimeMillis();
		System.out.println("실행시간 : "+((e-s)/1000)+"초");
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(10000000));
	}

}